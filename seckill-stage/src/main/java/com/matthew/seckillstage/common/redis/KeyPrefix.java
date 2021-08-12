package com.matthew.seckillstage.common.redis;

public interface KeyPrefix {
    public int expiredSeconds();

    public String getPrefix();
}
