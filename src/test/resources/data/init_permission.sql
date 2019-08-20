-- 如果存在permission则删除 --
drop table if exists permission;

-- 创建permission表 --
create table permission(
id int primary key auto_increment,
name varchar(20) not null,
description varchar(20) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入数据 --
insert into permission(name, description)
values("profile_priv", "个人信息权限"),
("message_priv", "留言权限"),
("edituser_priv", "修改用户信息权限"),
("editmessage_priv", "修改留言信息权限");