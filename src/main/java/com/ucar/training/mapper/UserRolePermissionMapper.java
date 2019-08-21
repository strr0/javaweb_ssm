package com.ucar.training.mapper;

import com.ucar.training.entity.Permission;

import java.util.List;

public interface UserRolePermissionMapper {
    List<Permission> getPermissions(String username);
    void insertUserRole(String username, String rolename);
    void updateUserRole(String rolename, String username);
    void insertRolePermission(String name, String permission);
    List<String> selectRolePermission(String name);

    void deleteUser(String name);
    void deleteRolePermission(String name);
    void deleteRole(String name);
}
