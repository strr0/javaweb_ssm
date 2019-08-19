package com.ucar.training.controller;

import com.ucar.training.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {
    @Autowired
    private MessageServiceImpl service;

    @RequestMapping("messages")
    public String getMessagesForm(Model model){
        model.addAttribute("messagesKey", service.getMessages());
        return "message/messages";
    }
}
