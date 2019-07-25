package com.example.redis;

import com.example.redis.lock.RedisLock;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.example.redis.lock
 * @date:2019/7/25
 **/
public class RedisTest extends RedisLockDemoApplicationTests {

    private Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisLock redisLock;

    @Test
    public void testLock(){
        String key = "java";
        boolean addLock = redisLock.addLock(key,60);
        if(!addLock){
            logger.info("方法已加锁，请不要在一分钟内重复操作！");
            return;
        }
        logger.info("正在执行。。。");
    }
}
