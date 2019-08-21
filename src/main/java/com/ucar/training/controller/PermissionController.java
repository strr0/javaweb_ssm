package com.ucar.training.controller;

import com.ucar.training.service.impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class PermissionController {
    @Autowired
    private PermissionServiceImpl service;

    @RequestMapping(value = "/permission", method = GET)
    public String getPermissionForm(Model model){
        model.addAttribute("permissionKey", service.getPermissions());
        return "permission/permission";
    }
}
