package com.ucar.training.service;

import com.ucar.training.entity.Message;

import java.util.List;

public interface MessageService {
    //添加留言
    boolean addMessge(Message message);
    //删除留言
    boolean deleteMessage(int id);
    //获取留言信息
    List<Message> getMessages();
}
