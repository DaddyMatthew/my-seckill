package com.matthew.seckillstage.service;

import com.matthew.seckillstage.entities.dto.OrderEntity;

public interface IOrderService {
    OrderEntity queryOrder(int id);

    void addOrder(OrderEntity order);
}
