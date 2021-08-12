drop table if exists `mt_user`;
create table `mt_user`
(
    `id`              int          not null auto_increment comment '用户ID, 手机号码',
    `mobile`          varchar(11)  not null unique,
    `nickname`        varchar(255) not null,
    `password`        varchar(32)  not null comment 'MD5(MD5(PASS明文+固定salt)+salt)',
    `salt`            varchar(10)  default null,
    `head`            varchar(128) default null,
    `register_date`   datetime     default null comment '注册时间',
    `last_login_date` datetime     default null comment '上次登录时间',
    `login_count`     int          default '0' comment '登录次数',
    primary key (`id`)
) engine=innoDB default charset=utf8mb4;

insert into `mt_user` (mobile, nickname, password, salt, head, register_date, last_login_date, login_count) values ('15216868861', 'Matthew', '1234', 'salt123');

