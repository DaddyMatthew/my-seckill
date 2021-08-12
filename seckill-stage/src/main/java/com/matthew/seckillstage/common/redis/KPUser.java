package com.matthew.seckillstage.configuration.redis;

public class KPUser extends AbstractKeyPrefix {

    public KPUser(String prefix) {
        super(prefix);
    }

    public static KPUser getById = new KPUser("id");
    public static KPUser getByName = new KPUser("name");
}
