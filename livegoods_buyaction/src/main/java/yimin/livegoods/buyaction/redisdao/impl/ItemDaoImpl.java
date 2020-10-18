package yimin.livegoods.buyaction.redisdao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import yimin.livegoods.buyaction.redisdao.ItemDao;
import yimin.livegoods.search.pojo.Item;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 14:40
 *   @Description :
 *
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Item get(String key) {
        return (Item) redisTemplate.opsForValue().get(key);
    }

    @Override
    public Item findById(String id) {
        return null;
    }
}
