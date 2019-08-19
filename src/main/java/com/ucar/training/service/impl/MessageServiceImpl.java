package com.ucar.training.service.impl;

import com.ucar.training.entity.Message;
import com.ucar.training.mapper.MessageMapper;
import com.ucar.training.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MessageServiceImpl implements UserService {
    @Resource
    private MessageMapper mapper;

    public boolean addMessge(Message message){
        if(message != null){
            mapper.insertMessage(message);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deleteMessage(int id){
        if(id != 0){
            mapper.deleteMessage(id);
            return true;
        }
        else{
            return false;
        }
    }
    public List<Message> getMessages(){
        return mapper.selectMessages();
    }
}
