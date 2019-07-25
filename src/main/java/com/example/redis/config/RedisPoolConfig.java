package com.example.redis.config;

import io.opentracing.Tracer;
import io.opentracing.contrib.redis.common.RedisSpanNameProvider;
import io.opentracing.contrib.redis.common.TracingConfiguration;
import io.opentracing.contrib.redis.jedis.TracingJedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class RedisPoolConfig {

    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public JedisPool convertJedisPool(Tracer tracer){
        JedisPoolConfig config = new JedisPoolConfig();
        TracingConfiguration tracingConfiguration = new TracingConfiguration.Builder(tracer)
                .withSpanNameProvider(RedisSpanNameProvider.PREFIX_OPERATION_NAME("redis."))
                .build();
        return new TracingJedisPool(config, redisConfig.getRedisHost (), redisConfig.getRedisPort (), redisConfig.getRedisTimeOut ()
                , redisConfig.getRedisPassword (),redisConfig.getRedisDatabase(),tracingConfiguration);
    }

}