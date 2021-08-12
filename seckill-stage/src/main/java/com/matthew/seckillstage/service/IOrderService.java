package com.matthew.seckillstage.service;

import com.matthew.seckillstage.entities.OrderEntity;

public interface OrderService {
    OrderEntity queryOrder(int id);

    OrderEntity addOrder(OrderEntity order);
}
