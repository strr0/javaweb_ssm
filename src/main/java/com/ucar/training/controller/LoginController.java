package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl service;

    @RequestMapping(value = "/login", method = GET)
    public String getLoginForm(HttpSession session, Model model){
        String username = (String) session.getAttribute("nameKey");
        if(username == null){
            return "user/login";
        }
        else{
            if(session.getAttribute("admin").equals(1)){
                model.addAttribute("usersKey", service.getUsers());
                return "admin/users";
            }
            else{
                model.addAttribute("userKey", service.getUserByName(username));
                return "user/profile";
            }
        }
    }

    @RequestMapping(value = "/login", method = POST)
    public String login(String username, String password,HttpSession session, Model model){
        User user = service.matchUser(username, password);
        if(user != null){
            session.setAttribute("nameKey", user.getUsername());
            /*if(user.getAdmin() == 1){
                model.addAttribute("usersKey", service.getUsers());
                session.setAttribute("admin", 1);
            }*/
            /*else{
                model.addAttribute("userKey", user);
            }*/
            return "wrap/main";
        }
        else{
            model.addAttribute("message", "用户名或密码错误");
            return "user/login";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model){
        session.invalidate();
        model.addAttribute("message", "注销成功");
        return "wrap/main";
    }
}
