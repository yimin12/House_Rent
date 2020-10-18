package yimin.livegoods.login.redisdao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import yimin.livegoods.login.pojo.ValidateCode;
import yimin.livegoods.login.redisdao.ValidateCodeDao;

import java.time.Duration;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 15:40
 *   @Description :
 *
 */
@Repository
public class ValidateCodeDaoImpl implements ValidateCodeDao {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * Store the data to redis, max-alive time is 2 minutes
     * @param key
     * @param value
     */
    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value, Duration.ofMinutes(2L));
    }

    /**
     * Get the value by given key in redis
     * @param key
     * @return
     */
    @Override
    public ValidateCode get(String key) {
        return (ValidateCode) redisTemplate.opsForValue().get(key);
    }

    /**
     * Delete the key in redis
     * @param key
     * @return
     */
    @Override
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }
}
