package com.wj.springboot.controller.pro;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class re {
    public static RedisTemplate getRedisTemplate(JedisConnectionFactory connectionFactory){

        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        StringRedisSerializer serializer = new StringRedisSerializer();
        redisTemplate.setDefaultSerializer(serializer);
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setValueSerializer(serializer);

        /**必须执行这个函数,初始化RedisTemplate*/
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
