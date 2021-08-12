package com.matthew.seckillstage.service.impl;

import com.matthew.seckillstage.common.CodeMessage;
import com.matthew.seckillstage.common.exception.ApplicationException;
import com.matthew.seckillstage.common.util.MD5Util;
import com.matthew.seckillstage.common.util.UUIDUtil;
import com.matthew.seckillstage.common.redis.KPSeckillUser;
import com.matthew.seckillstage.common.redis.RedisService;
import com.matthew.seckillstage.dao.UserMapper;
import com.matthew.seckillstage.entities.dto.UserEntity;
import com.matthew.seckillstage.entities.vo.LoginVo;
import com.matthew.seckillstage.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserService implements IUserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public UserEntity getByToke(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        UserEntity user = redisService.get(KPSeckillUser.token, token, UserEntity.class);
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

    @Override
    public String login(HttpServletResponse response, LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        UserEntity user = userMapper.selectByMobile(mobile);
        if (user == null) {
            throw new ApplicationException(CodeMessage.MOBILE_NOT_EXIST);
        }
        String _password = MD5Util.formPassToDBPass(password, user.getSalt());
        if (!_password.equals(user.getPassword())) {
            throw new ApplicationException(CodeMessage.PASSWORD_ERROR);
        }
        String token = UUIDUtil.uuid();
        addCookie(response, token, user);
        return token;
    }

    private void addCookie(HttpServletResponse response, String token, UserEntity user) {
        redisService.set(KPSeckillUser.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(KPSeckillUser.token.expiredSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
