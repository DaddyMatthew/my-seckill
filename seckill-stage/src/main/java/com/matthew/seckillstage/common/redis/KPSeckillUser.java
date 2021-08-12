package com.matthew.seckillstage.common.redis;

public class KPUser extends AbstractKeyPrefix {

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    public KPUser(String prefix) {
        super(prefix);
    }

    public static KPUser token = new KPUser("tk");
    public static KPUser getById = new KPUser("id");
    public static KPUser getByName = new KPUser("name");
}
