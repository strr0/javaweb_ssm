package com.ucar.training.mapper;

import com.ucar.training.entity.Permission;

import java.util.List;

public interface PermissionMapper {
    List<Permission> selectPermission();
}
