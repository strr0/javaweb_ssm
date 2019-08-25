-- 如果存在permission则删除 --
drop table if exists permission;

-- 创建permission表 --
create table permission(
id int primary key auto_increment,
name varchar(20) not null,
description varchar(20) not null,
url varchar(20) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入数据 --
insert into permission(name, description, url)
values('profile_priv', '个人信息', 'profile'),
('message_priv', '留言板', 'messages'),
('edituser_priv', '所有用户', 'users'),
('role_priv', '角色管理', 'role'),
('permission_priv', '权限管理', 'permission');