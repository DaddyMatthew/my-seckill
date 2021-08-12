package com.matthew.seckillstage.configuration.redis;

public interface KeyPrefix {
    public int expiredSeconds();

    public String getPrefix();
}
