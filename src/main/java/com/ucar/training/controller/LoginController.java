package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl service;

    @RequestMapping(value = "/login", method = GET)
    public String getLoginForm(){
        return "user/login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String postLoginForm(String name, String password, Model model){
        User user = service.matchUser(name, password);
        if(user != null){
            if(user.getAdmin() == 1){
                model.addAttribute("usersKey", service.getUsers());
                return "admin/users";
            }
            else{
                model.addAttribute("userKey", user);
                return "user/profile";
            }
        }
        else{
            model.addAttribute("message", "用户名或密码错误");
            return "user/login";
        }
    }
}
