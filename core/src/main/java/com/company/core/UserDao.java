package com.company.core;

import com.company.domain.User;
import java.util.ArrayList;


public interface UserDao {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    void deleteUser(String login);
    User getById(Integer id);
    ArrayList<User> getAll();

}
