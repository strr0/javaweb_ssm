package com.ucar.training.service.impl;

import com.ucar.training.entity.Role;
import com.ucar.training.mapper.RoleMapper;
import com.ucar.training.mapper.UserRolePermissionMapper;
import com.ucar.training.service.RoleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoleServiceImpl implements RoleService {
    @Resource
    private UserRolePermissionMapper userRolePermissionMapper;
    @Resource
    private RoleMapper roleMapper;

    public void addRole(Role role){
        String name = role.getName();
        List<String> permissions = role.getPermissions();
        roleMapper.insertRole(name, name);
        for(String permission : permissions){
            userRolePermissionMapper.insertRolePermission(name, permission);
        }
    }
    public void deleteRole(String name){
        userRolePermissionMapper.deleteUser(name);
        userRolePermissionMapper.deleteRolePermission(name);
        userRolePermissionMapper.deleteRole(name);
    }
    public void updateRole(Role role){
        String name = role.getName();
        userRolePermissionMapper.deleteRolePermission(name);
        List<String> permissions = role.getPermissions();
        for(String permission : permissions){
            userRolePermissionMapper.insertRolePermission(name, permission);
        }
    }
    public List<Role> getRoles(){
        List<Role> roles = new ArrayList<>();  //存放Role
        List<String> rolenames = roleMapper.selectRole();
        for(String rolename : rolenames){
            List<String> permissions = userRolePermissionMapper.selectRolePermission(rolename);
            roles.add(new Role(rolename, permissions));
        }
        return roles;
    }
    public Role getRole(String name){
        List<String> permissions = userRolePermissionMapper.selectRolePermission(name);
        return new Role(name, permissions);
    }
}
