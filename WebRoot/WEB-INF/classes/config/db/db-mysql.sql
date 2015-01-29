create table User(
	id varchar(32) primary key not null comment '主键ID',
    name varchar(100) comment '用户名',
    pwd varchar(100) comment '密码'
) comment='用户表';

