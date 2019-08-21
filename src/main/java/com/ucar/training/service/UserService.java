package com.ucar.training.service;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.User;
import com.ucar.training.entity.UserForm;

import java.util.List;

public interface UserService {
    boolean addUser(UserForm userForm);
    boolean deleteUser(int id, String username);
    boolean updateUser(UserForm userForm);
    List<User> getUsers();
    User getUserByName(String username);
    User getUserById(int id);
    User matchUser(String username, String password);
    List<Permission> getPermissions(String username);
    List<String> getRoles();  //获取所有角色名
}
