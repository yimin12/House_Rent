package yimin.livegoods.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import yimin.livegoods.cache.config.RedisCacheConfiguration;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 15:53
 *   @Description :
 *
 */
@Configuration
public class LoginRedisConfiguration extends RedisCacheConfiguration {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        return super.redisTemplate(redisConnectionFactory);
    }
}
