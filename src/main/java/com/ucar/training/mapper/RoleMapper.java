package com.ucar.training.mapper;

import java.util.List;

public interface RoleMapper {
    void insertRole(String name, String description);
    List<String> selectRole();
}
