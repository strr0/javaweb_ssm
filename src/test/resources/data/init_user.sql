-- 如果存在user则删除 --
drop table if exists user;

-- 创建user表 --
create table user(
id int primary key auto_increment,
username varchar(20) not null,
sex varchar(10) not null,
age int not null,
password varchar(20) not null,
likes varchar(20) not null,
tag varchar(30) not null,
admin int not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入初始化数据 --
insert into user(username, sex, age, password, likes, tag, admin)
values("Java", "男", 20, "123123", "撩妹, 写代码", "No.1", 0),
("Python", "女", 21, "123123", "写代码", "No.2", 0),
("小萌新", "女", 22, "123123", "篮球, 足球", "No.3", 0),
("root", "女", 21, "password", "写代码", "个性签名", 1);