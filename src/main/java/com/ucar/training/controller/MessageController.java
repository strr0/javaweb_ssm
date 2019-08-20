package com.ucar.training.controller;

import com.ucar.training.entity.Message;
import com.ucar.training.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class MessageController {
    @Autowired
    private MessageServiceImpl service;

    @RequestMapping(value = "/messages", method = GET)
    public String getMessagesForm(Model model){
        model.addAttribute("messagesKey", service.getMessages());
        return "message/messages";
    }
    @RequestMapping(value = "/addmessage", method = POST)
    public String addMessage(String data, HttpSession session){
        String username = (String)session.getAttribute("nameKey");
        if(username == null){
            return "redirect:login";
        }
        else{
            Message message = new Message(username, data);
            service.addMessge(message);
            return "redirect:messages";
        }
    }
    @RequestMapping(value = "deletemessage", method = GET)
    public String deleteMessage(int id){
        service.deleteMessage(id);
        return "redirect:messages";
    }
}
