package com.matthew.seckillstage.dao;

import com.matthew.seckillstage.entities.dto.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

    @Select("select * from s_order where id=#{id}")
    OrderEntity queryOrder(@Param("id") int id);

    @Insert("insert into s_order (id,name) values (#{order.id},#{order.name})")
    void addOrder(@Param("order")OrderEntity order);
}
