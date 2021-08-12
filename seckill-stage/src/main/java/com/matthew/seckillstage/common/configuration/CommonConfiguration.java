package com.matthew.seckillstage.common.configuration;

import com.matthew.seckillstage.common.redis.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class CommonConfiguration {

    @Bean
    public JedisPool jedisPoolFactory(@Autowired RedisConfig rc) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(rc.getPoolMaxIdle());
        config.setMaxTotal(rc.getPoolMaxTotal());
        config.setMaxWaitMillis(rc.getPoolMaxWait() * 1000);

        JedisPool jp = new JedisPool(
                config,
                rc.getHost(), rc.getPort(),
                rc.getTimeout() * 1000,
                rc.getPassword(), 0);
        return jp;
    }
}
