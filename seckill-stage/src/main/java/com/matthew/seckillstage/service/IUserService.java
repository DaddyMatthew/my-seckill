package com.matthew.seckillstage.service;

import com.matthew.seckillstage.entities.dto.UserEntity;
import com.matthew.seckillstage.entities.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

public interface IUserService {

    UserEntity getByToke(HttpServletResponse response, String token);

    String login(HttpServletResponse response, LoginVo loginVo);
}
