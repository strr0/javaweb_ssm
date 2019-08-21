package com.ucar.training.service;

import com.ucar.training.entity.Role;

import java.util.List;

public interface RoleService {
    //添加角色
    void addRole(Role role);
    //删除角色
    void deleteRole(String name);
    //更新角色
    void updateRole(Role role);
    //获取所有角色
    List<Role> getRoles();
    //获取角色
    Role getRole(String name);
}
