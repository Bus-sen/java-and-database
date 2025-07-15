package com.busra.dao;

import com.busra.user.User;

import java.util.List;

public interface UserDAO {
    void createTable();
    void save(User user);
    void update(User user);
    void delete(int id);
    List<User> findAll();
}
