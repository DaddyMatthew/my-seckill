package com.matthew.seckillstage.service.impl;

import com.matthew.seckillstage.dao.OrderMapper;
import com.matthew.seckillstage.entities.dto.OrderEntity;
import com.matthew.seckillstage.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderEntity queryOrder(int id) {
        return orderMapper.queryOrder(id);
    }

    @Override
    @Transactional
    public void addOrder(OrderEntity order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(2);
        orderEntity.setName("name_2");
        orderMapper.addOrder(orderEntity);
        Long.valueOf("s");
    }
}
