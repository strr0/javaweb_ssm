package com.ucar.training.test;

import com.ucar.training.config.DataConfig;
import com.ucar.training.entity.Permission;
import com.ucar.training.mapper.PermissionMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class PermissionTest {
    @Resource
    private PermissionMapper mapper;

    @Test
    public void getPermissionTest(){
        List<Permission> permissions = mapper.selectPermission();
        Assert.assertNotNull(permissions);
        for(Permission permission : permissions){
            System.out.println(permission.getDescription());
        }
    }
}
