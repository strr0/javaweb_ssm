package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
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
    public String getPermissions(Model model){
        model.addAttribute("permissionKey", service.getPermissions());
        return "permission/permission";
    }

    @RequestMapping(value = "/permissionadd", method = GET)
    public String getPermissionForm(){
        return "permission/permissionadd";
    }
    @RequestMapping(value = "/permissionadd", method = POST)
    public String postPermissionForm(Permission permission){
        service.addPermission(permission);
        return "status/success";
    }

    @RequestMapping(value = "/permissionchange", method = GET)
    public String getChangeForm(String name, Model model){
        model.addAttribute("permissionKey", service.getPermission(name));
        return "permission/permissionchange";
    }
    @RequestMapping(value = "/permissionchange", method = POST)
    public String postChangeForm(Permission permission){
        service.changePermission(permission);
        return "status/success";
    }

    @RequestMapping(value = "/permissiondelete", method = POST)
    public String deletePermission(String name, Model model){
        service.deletePermission(name);
        model.addAttribute("permissionKey", service.getPermissions());
        return "permission/permission";
    }
}
