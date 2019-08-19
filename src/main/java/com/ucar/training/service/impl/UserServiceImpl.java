package com.ucar.training.service.impl;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserForm;
import com.ucar.training.mapper.UserMapper;
import com.ucar.training.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    public boolean addUser(User user){
        if(user != null){
            mapper.insertUser(user);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deleteUser(int id){
        if(id != 0){
            mapper.deleteUser(id);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean updateUser(UserForm userForm){
        if(userForm != null){
            User user = mapper.getUserByName(userForm.getName());
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
            mapper.updateUser(user);
            return true;
        }
        else{
            return false;
        }
    }
    public List<User> getUsers(){
        return mapper.selectUsers();
    }
    public User getUserByName(String name){
        return mapper.getUserByName(name);
    }
    public User getUserById(int id){
        return mapper.getUserById(id);
    }
    public User matchUser(String name, String password){
        return mapper.matchUser(name, password);
    }
}
