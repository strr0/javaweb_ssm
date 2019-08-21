package com.ucar.training.controller;

import com.ucar.training.entity.Role;
import com.ucar.training.service.impl.PermissionServiceImpl;
import com.ucar.training.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class RoleController {
    @Autowired
    private RoleServiceImpl service;
    @Autowired
    private PermissionServiceImpl permissionService;

    @RequestMapping("/role")
    public String getRoles(Model model){
        model.addAttribute("roles", service.getRoles());
        model.addAttribute("permissionKey", permissionService.getPermissions());
        return "role/role";
    }

    @RequestMapping(value = "/roleadd", method = GET)
    public String getRoleForm(Model model){
        model.addAttribute("permissionKey", permissionService.getPermissions());
        return "role/roleadd";
    }

    @RequestMapping(value = "/roleadd", method = POST)
    public String postRoleForm(Role role){
        service.addRole(role);
        return "status/success";
    }

    @RequestMapping(value = "/rolechange", method = GET)
    public String getChangeForm(String name, Model model){
        model.addAttribute("roleKey", service.getRole(name));
        model.addAttribute("permissionKey", permissionService.getPermissions());
        return "role/rolechange";
    }
    @RequestMapping(value = "rolechange", method = POST)
    public String postChangeForm(Role role){
        service.updateRole(role);
        return "status/success";
    }

    @RequestMapping(value = "/roledelete", method = POST)
    public String deleteRole(String name, Model model){
        service.deleteRole(name);
        model.addAttribute("roles", service.getRoles());
        return "role/role";
    }
}
