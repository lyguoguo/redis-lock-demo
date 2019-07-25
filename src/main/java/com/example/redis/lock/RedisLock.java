package com.example.redis.lock;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
public class RedisLock {

    private static String keyPrefix = "RedisLock:";

    @Resource
    private JedisPool jedisPool;

    public boolean addLock(String key, long expire) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String val = jedis.set(keyPrefix + key, "1", "nx", "ex", expire);
            return val != null;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    public void removeLock(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(keyPrefix + key);
        } finally {
            if (jedis != null) jedis.close();
        }
    }
}
