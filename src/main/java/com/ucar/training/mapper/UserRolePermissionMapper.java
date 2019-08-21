package com.ucar.training.mapper;

import java.util.List;

public interface UserRolePermissionMapper {
    List<String> getPermissions(String username);
    void insertUserRole(String username, String rolename);
    void updateUserRole(String rolename, String username);
}
