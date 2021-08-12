package com.matthew.seckillstage.dao;

import com.matthew.seckillstage.entities.dto.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from mt_user where mobile=#{mobile}")
    UserEntity selectByMobile(@Param("mobile") String mobile);
}
