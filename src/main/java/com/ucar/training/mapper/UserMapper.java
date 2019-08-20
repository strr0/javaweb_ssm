package com.ucar.training.mapper;

import com.ucar.training.entity.User;

import java.util.List;

public interface UserMapper {
    void insertUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> selectUsers();
    User getUserByName(String username);
    User getUserById(int id);
    User matchUser(String username, String password);
}
