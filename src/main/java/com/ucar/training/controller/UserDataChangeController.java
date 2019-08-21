package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserForm;
import com.ucar.training.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class UserDataChangeController {
    @Autowired
    private UserServiceImpl service;

    @RequestMapping(value = "/deleteuser", method = POST)
    public String deleteUser(int id, Model model, HttpSession session){
        if(session.getAttribute("admin") != null){
            model.addAttribute("usersKey", service.getUsers());
            String username = (String)session.getAttribute("nameKey");
            if(service.deleteUser(id, username)){
                return "admin/users";
            }
            else{
                model.addAttribute("message", "你不能删除自己");
                return "admin/users";
            }
        }
        else{
            model.addAttribute("message", "你没有权限删除");
            return "admin/users";
        }
    }

    @RequestMapping(value = "/updateuser", method = GET)
    public String getUpdateUserForm(int id, Model model){
        model.addAttribute("rolesKey", service.getRoles());
        model.addAttribute("userKey", service.getUserById(id));
        return "admin/datachange";
    }
    @RequestMapping(value = "/updateuser", method = POST)
    public String updateUser(UserForm userForm, Model model){
        if(service.updateUser(userForm)){
            model.addAttribute("usersKey", service.getUsers());
            return "admin/users";
        }
        else{
            return "status/fail";
        }
    }
}
