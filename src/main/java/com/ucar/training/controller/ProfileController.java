package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {
    @Autowired
    private UserServiceImpl service;

    @RequestMapping("/profile")
    public String getProfile(HttpSession session, Model model){
        String username = (String)session.getAttribute("nameKey");
        if(username != null){
            User user = service.getUserByName(username);
            model.addAttribute("userKey", user);
        }
        return "user/profile";
    }

    @RequestMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("usersKey", service.getUsers());
        return "admin/users";
    }
}
