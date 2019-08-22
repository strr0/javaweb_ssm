package com.ucar.training.service;

import com.ucar.training.entity.Permission;

import java.util.List;

public interface PermissionService {
    //添加权限
    void addPermission(Permission permission);
    //删除权限
    void deletePermission(String name);
    //获取所有权限
    List<Permission> getPermissions();
    //根据权限名获取权限
    Permission getPermission(String name);
    //修改权限
    void changePermission(Permission permission);
}
