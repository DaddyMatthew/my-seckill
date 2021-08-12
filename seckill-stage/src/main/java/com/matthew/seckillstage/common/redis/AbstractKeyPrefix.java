package com.matthew.seckillstage.configuration.redis;

public abstract class AbstractKeyPrefix implements KeyPrefix {
    private int expiredSeconds;
    private String prefix;

    public AbstractKeyPrefix(String prefix) {
        this(0, prefix);
    }

    public AbstractKeyPrefix(int expiredSeconds, String prefix) {
        this.expiredSeconds = expiredSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expiredSeconds() {
        return expiredSeconds;
    }

    @Override
    public String getPrefix() {
        return getClass().getSimpleName() + ":" + prefix;
    }
}
