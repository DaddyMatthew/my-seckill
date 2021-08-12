package com.matthew.seckillstage.common.redis;

public class KPOrder extends AbstractKeyPrefix{

    public KPOrder(int expiredSeconds) {
        super(expiredSeconds, "order_key");
    }
}
