package com.matthew.seckillstage.common.redis;

public class KPSeckillUser extends AbstractKeyPrefix {

    private static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    public KPSeckillUser(int expiredSeconds, String prefix) {
        super(expiredSeconds, prefix);
    }

    public static KPSeckillUser token = new KPSeckillUser(TOKEN_EXPIRE, "tk");
    public static KPSeckillUser getById = new KPSeckillUser(0, "id");
}
