package com.ucar.training.test;


import com.ucar.training.config.DataConfig;
import com.ucar.training.entity.Permission;
import com.ucar.training.mapper.RoleMapper;
import com.ucar.training.mapper.UserRolePermissionMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class UserRolePermissionTest {
    @Resource
    private UserRolePermissionMapper mapper;

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void getPermissionTest(){
        Assert.assertNotNull(mapper);
        List<Permission> permissions = mapper.getPermissions("root");
        Assert.assertNotNull(permissions);

        for(Permission permission : permissions){
            System.out.println(permission.getDescription());
            System.out.println(permission.getUrl());
        }
    }

    @Test
    public void getRolesTest(){
        List<String> roles = roleMapper.selectRole();
        Assert.assertNotNull(roles);
        for(String role : roles){
            System.out.println(role);
        }
    }

    @Test
    public void addUserRoleTest(){
        mapper.insertUserRole("222", "consumer");
    }

    @Test
    public void selectRolePermission(){
        List<String> permissions = mapper.selectRolePermission("admin");
        Assert.assertNotNull(permissions);
        for(String permission : permissions){
            System.out.println(permission);
        }
    }
}
