-- 如果存在role则删除 --
drop table if exists role;

-- 创建role表 --
create table role(
id int primary key auto_increment,
name varchar(20) not null,
description varchar(20) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入数据 --
insert into role(name, description)
values("consumer", "普通用户"),
("admin", "管理员");