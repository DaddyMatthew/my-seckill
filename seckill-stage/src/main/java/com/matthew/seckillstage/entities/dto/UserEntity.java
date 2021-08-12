package com.matthew.seckillstage.entities.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private int id;
    private String mobile;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private int loginCount;
}
