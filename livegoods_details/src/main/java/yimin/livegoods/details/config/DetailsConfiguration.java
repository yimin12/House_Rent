package yimin.livegoods.details.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import yimin.livegoods.cache.config.RedisCacheConfiguration;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 11:55
 *   @Description :
 *      extends the parent class declared in cache_redis
 */
@Configuration
public class DetailsConfiguration extends RedisCacheConfiguration {

    /**
     * Declare the cache configuration
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        return super.cacheManager(redisConnectionFactory);
    }
}
