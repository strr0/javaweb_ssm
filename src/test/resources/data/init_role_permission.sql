-- 如果存在role_permission则删除 --
drop table if exists role_permission;

-- 创建role_permission表 --
create table role_permission(
id int primary key auto_increment,
role_name varchar(20) not null,
permission_name varchar(20) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入初始化数据 --
insert into role_permission(role_name, permission_name)
values("consumer", "profile_priv"),
("consumer", "message_priv"),
("admin", "profile_priv"),
("admin", "message_priv"),
("admin", "edituser_priv"),
("admin", "role_priv"),
("admin", "permission_priv");