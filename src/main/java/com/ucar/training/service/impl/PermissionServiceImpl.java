package com.ucar.training.service.impl;

import com.ucar.training.entity.Permission;
import com.ucar.training.mapper.PermissionMapper;
import com.ucar.training.service.PermissionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper mapper;

    public void addPermission(Permission permission){
        mapper.insertPermission(permission);
    }
    public void deletePermission(String name){
        mapper.deleteRolePermission(name);
        mapper.deletePermission(name);
    }
    public List<Permission> getPermissions(){
        return mapper.selectPermission();
    }
    public Permission getPermission(String name){
        return mapper.getPermissionByName(name);
    }
    public void changePermission(Permission permission){
        mapper.updatePermission(permission);
    }
}
