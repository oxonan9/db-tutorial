package io.github.dunwu.javadb.redis;

import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhang Peng
 * @since 2018/6/19
 */
public class RedissonStandaloneTest {

    @Test
    public void testRedissonConnect() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:redisson-standalone.xml");
        RedissonClient redisson = (RedissonClient) applicationContext.getBean("standalone");
        // 首先获取redis中的key-value对象，key不存在没关系
        RBucket<String> keyObject = redisson.getBucket("key");
        // 如果key存在，就设置key的值为新值value
        // 如果key不存在，就设置key的值为value
        keyObject.set("value");
    }

}
