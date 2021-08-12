package com.matthew.seckillstage.configuration.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz) {
        String realKey = keyPrefix.getPrefix() + ":" + key;
        return get(realKey, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            return stringToBean(value, clazz);
        } finally {
            returnToPool(jedis);
        }
    }

    public <T> boolean set(KeyPrefix keyPrefix, String key, T value) {
        String realKey = keyPrefix.getPrefix() + ":" + key;
        return set(realKey, value, keyPrefix.expiredSeconds());
    }

    public <T> boolean set(String key, T value) {
        return set(key, value, 0);
    }

    public <T> boolean set(String key, T value, int expiredTime) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if (str == null) {
                return false;
            }
            if (expiredTime <= 0) {
                jedis.set(key, str);
            } else {
                jedis.setex(key, expiredTime, str);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    public boolean exists(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (key == null || key.length() <= 0) {
                return false;
            }
            String realKey = keyPrefix.getPrefix() + ":" + key;
            return jedis.exists(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    public Long incr(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (key == null || key.length() <= 0) {
                return null;
            }
            String realKey = keyPrefix.getPrefix() + ":" + key;
            return jedis.incr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    public Long decr(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (key == null || key.length() <= 0) {
                return null;
            }
            String realKey = keyPrefix.getPrefix() + ":" + key;
            return jedis.decr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    private <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    private <T> String beanToString(T bean) {
        if (bean == null) {
            return null;
        }
        Class<?> clazz = bean.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + bean;
        } else if (clazz == String.class) {
            return (String) bean;
        } else {
            return JSON.toJSONString(bean);
        }
    }
}
