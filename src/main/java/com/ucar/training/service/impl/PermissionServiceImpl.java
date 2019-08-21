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

    public List<Permission> getPermissions(){
        return mapper.selectPermission();
    }
}
