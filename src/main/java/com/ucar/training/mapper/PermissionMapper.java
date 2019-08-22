package com.ucar.training.mapper;

import com.ucar.training.entity.Permission;

import java.util.List;

public interface PermissionMapper {
    //插入权限
    void insertPermission(Permission permission);
    //删除权限
    void deleteRolePermission(String name);
    void deletePermission(String name);
    //获取所有权限
    List<Permission> selectPermission();
    //根据权限名获取权限信息
    Permission getPermissionByName(String name);
    //修改权限信息
    void updatePermission(Permission permission);
}
