package yimin.livegoods.buyaction.message.consumer.redisdao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Repository;
import yimin.livegoods.buyaction.message.consumer.redisdao.ItemDao4Redis;
import yimin.livegoods.search.pojo.Item;

import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 18:17
 *   @Description :
 *
 */
@Repository
public class ItemDao4RedisImpl implements ItemDao4Redis {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * The current method require atomic operation. Before update, we need to check
     * the key and its corresponding commodity so that we can know its rented status.
     * If it can be rented, update it. Otherwise, we ignore this operation.
     * In redisTemplate operation, we need take care about the 'execute' function.
     * It does not use try...catch block to handle the exception, we should do it for get function
     * @param key
     * @return
     */
    @Override
    public Item get(String key) {
        return (Item) redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean set(String key, Object value) {
        try{
            redisTemplate.setEnableTransactionSupport(true); // declare this should support rollback if fail
            List<Object> result = redisTemplate.execute(
                new SessionCallback<List<Object>>() {
                    @Override
                    public List<Object> execute(RedisOperations redisOperations) throws DataAccessException {
                        Item item = (Item) redisOperations.opsForValue().get(key);
                        if(item.getRented()){
                            // should handle the concurrency problem
                            return null;
                        }
                        redisOperations.multi(); // init the transactions, and inform others this is an atomic action
                        redisOperations.opsForValue().set(key, value);
                        return redisOperations.exec();
                    }
                }
            );
            redisTemplate.setEnableTransactionSupport(false); // close the transaction support when finish
            if(null == result){
                return false;
            }
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }
}
