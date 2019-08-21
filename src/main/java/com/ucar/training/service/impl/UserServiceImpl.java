package com.ucar.training.service.impl;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserForm;
import com.ucar.training.mapper.RoleMapper;
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
    @Resource
    private RoleMapper roleMapper;

    public boolean addUser(UserForm userForm){
        if(userForm != null){
            urpMapper.insertUserRole(userForm.getUsername(), userForm.getUsertype());
            userMapper.insertUser(userForm.userFromToUser());
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deleteUser(int id, String username){
        if(id != 0 && username != null){
            if(userMapper.getUserById(id).getUsername().equals(username)){  //删除自己
                return false;
            }
            else{
                userMapper.deleteUser(id);
                return true;
            }
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
            if(userForm.getUsertype().equals("admin")){
                user.setAdmin(1);
            }
            else{
                user.setAdmin(0);
            }
            userMapper.updateUser(user);
            urpMapper.updateUserRole(userForm.getUsertype(), userForm.getUsername());
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
    public List<String> getRoles(){
        return roleMapper.selectRole();
    }
}
