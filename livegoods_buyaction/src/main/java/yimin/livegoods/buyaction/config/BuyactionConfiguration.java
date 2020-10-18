package yimin.livegoods.buyaction.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import yimin.livegoods.cache.config.RedisCacheConfiguration;
import yimin.livegoods.message.publisher.LivegoodsMessagePublisher;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/10/18 14:33
 *   @Description :
 *
 */
@Configuration
public class BuyactionConfiguration extends RedisCacheConfiguration {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        return super.redisTemplate(redisConnectionFactory);
    }

    @Bean
    public LivegoodsMessagePublisher livegoodsMessagePublisher(AmqpTemplate amqpTemplate){
        LivegoodsMessagePublisher messagePublisher = new LivegoodsMessagePublisher();
        messagePublisher.setAmqpTemplate(amqpTemplate);
        return messagePublisher;
    }
}
