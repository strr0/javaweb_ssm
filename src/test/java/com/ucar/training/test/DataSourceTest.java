package com.ucar.training.test;

import com.ucar.training.config.DataConfig;
import com.ucar.training.entity.User;
import com.ucar.training.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class DataSourceTest {
    @Resource
    private UserMapper mapper;

    @Test
    public void testDataConfig(){
        List<User> users = mapper.selectUsers();
        if(users != null){
            System.out.println(users.get(0).getName());
        }
    }
}
