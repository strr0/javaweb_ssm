-- 如果存在message则删除 --
drop table if exists message;

-- 创建message表
create table message(
id int primary key auto_increment,
m_name varchar(20) not null,
m_data varchar(50) not null,
m_time datetime not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入初始化数据 --
insert into message(m_name, m_data, m_time)
values("root", "第一条留言...", now());