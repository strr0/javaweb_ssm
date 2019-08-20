package com.ucar.training.service.impl;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserForm;
import com.ucar.training.mapper.UserMapper;
import com.ucar.training.mapper.UserRolePermissionMapper;
import com.ucar.training.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRolePermissionMapper urpMapper;

    public boolean addUser(User user){
        if(user != null){
            userMapper.insertUser(user);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deleteUser(int id){
        if(id != 0){
            userMapper.deleteUser(id);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean updateUser(UserForm userForm){
        if(userForm != null){
            User user = userMapper.getUserByName(userForm.getUsername());
            if(userForm.getSex() != null){
                user.setSex(userForm.getSex());
            }
            if(userForm.getAge() != 0){
                user.setAge(userForm.getAge());
            }
            if(userForm.getLikes() != null){
                user.setLikes(userForm.likesToLIKES());
            }
            if(userForm.getTag() != null){
                user.setTag(userForm.getTag());
            }
            userMapper.updateUser(user);
            return true;
        }
        else{
            return false;
        }
    }
    public List<User> getUsers(){
        return userMapper.selectUsers();
    }
    public User getUserByName(String username){
        return userMapper.getUserByName(username);
    }
    public User getUserById(int id){
        return userMapper.getUserById(id);
    }
    public User matchUser(String username, String password){
        return userMapper.matchUser(username, password);
    }

    public List<String> getPermissions(String username){
        if(username != null){
            return urpMapper.getPermissions(username);
        }
        else{
            return null;
        }
    }
}
