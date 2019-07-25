package com.example.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@Configuration
@PropertySource("classpath:config/redis.properties")
public class RedisConfig {

    @Value("${redisConfig.host}")
    private String redisHost  ;
    @Value("${redisConfig.port}")
    private Integer redisPort  ;
    @Value("${redisConfig.password}")
    private String redisPassword  ;
    @Value("${redisConfig.timeOut}")
    private Integer redisTimeOut  ;
    @Value("${redisConfig.database}")
    private Integer redisDatabase  ;

    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public Integer getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(Integer redisPort) {
        this.redisPort = redisPort;
    }

    public String getRedisPassword() {
        return redisPassword;
    }

    public void setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
    }

    public Integer getRedisTimeOut() {
        return redisTimeOut;
    }

    public void setRedisTimeOut(Integer redisTimeOut) {
        this.redisTimeOut = redisTimeOut;
    }

    public Integer getRedisDatabase() {
        return redisDatabase;
    }

    public void setRedisDatabase(Integer redisDatabase) {
        this.redisDatabase = redisDatabase;
    }
}