package com.ucar.training.mapper;

import com.ucar.training.entity.Message;

import java.util.List;

public interface MessageMapper {
    void insertMessage(Message message);
    void deleteMessage(int id);
    List<Message> selectMessages();
}
