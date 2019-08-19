package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserForm;
import com.ucar.training.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class UserDataChangeController {
    @Autowired
    private UserServiceImpl service;

    @RequestMapping("/deleteuser")
    public String deleteUser(int idDelete, Model model){
        if(service.deleteUser(idDelete)){
            model.addAttribute("usersKey", service.getUsers());
            return "admin/users";
        }
        else{
            return "status/fail";
        }
    }

    @RequestMapping(value = "/updateuser", method = GET)
    public String getUpdateUserForm(int idChange, Model model){
        model.addAttribute("userKey", service.getUserById(idChange));
        return "admin/datachange";
    }
    @RequestMapping(value = "updateuser", method = POST)
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
