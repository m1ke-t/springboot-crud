package com.company.core;

import com.company.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
@Service
public class UserDaoInMemory implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoInMemory.class.getName());

    @Autowired
    private Storage storage;

    @Override
    public void createUser(User user) {
        storage.save(user);
        log.info("com.company.domain.User {} {} {} added", user.getId(), user.getLogin(), user.getName());
    }

    @Override
    public void updateUser(User user) {
        log.info("Searching user with id {}...", user.getId());
        User dbUser = storage.findById(user.getId());
        if (dbUser != null) {
            log.info("com.company.domain.User {} {} {} was found, updating...", dbUser.getId(), dbUser.getLogin(), dbUser.getName());
            createUser(user);
            log.info("com.company.domain.User {} {} {} updated!", user.getId(), user.getLogin(), user.getName());
        } else {
            log.info("com.company.domain.User with id {} was not found!", user.getId());
        }
    }

    @Override
    public void deleteUser(Integer id) {

        if (storage.deleteById(id)) {
            log.info("com.company.domain.User with login {} removed", id);
        } else {
            log.info("com.company.domain.User with login {} was not found", id);
        }
    }

    @Override
    public void deleteUser(String login) {
        if (storage.deleteByLogin(login)) {
            log.info("com.company.domain.User with login {}  removed", login);
        } else {
            log.info("com.company.domain.User with login {} was not found", login);
        }
    }

    @Override
    public User getById(Integer id) {
        log.info("Trying to get user by id {}", id);
        User user = storage.findById(id);
        if (user != null) {
            log.info("com.company.domain.User with id {} was found");
            log.info("com.company.domain.User {} {} {}", user.getId(), user.getLogin(), user.getName());
            return user;
        } else {
            log.info("com.company.domain.User with id {} was not found!", id);
            return null;
        }
    }

    @Override
    public ArrayList<User> getAll() {
        return new ArrayList<>(storage.getAll());
    }
}
