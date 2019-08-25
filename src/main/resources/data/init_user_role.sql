-- 如果存在user_role则删除 --
drop table if exists user_role;

-- 创建user_role表 --
create table user_role(
id int primary key auto_increment,
user_name varchar(20) not null,
role_name varchar(20) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入初始化数据 --
insert into user_role(user_name, role_name)
values('Java', 'consumer'),
('Python', 'consumer'),
('小萌新', 'consumer'),
('root', 'admin');