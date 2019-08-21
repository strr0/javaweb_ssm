package com.ucar.training.controller;

import com.ucar.training.entity.UserForm;
import com.ucar.training.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class RegisterController {
    @Autowired
    private UserServiceImpl service;

    @RequestMapping(value = "/register", method = GET)
    public String getRegisterForm(Model model){
        model.addAttribute("rolesKey", service.getRoles());
        return "user/register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String postRegisterForm(UserForm userForm){
        if(service.getUserByName(userForm.getUsername()) != null){
            return "status/fail";
        }
        else{
            if(service.addUser(userForm)){
                return "status/success";
            }
            else{
                return "status/fail";
            }
        }

    }
}
