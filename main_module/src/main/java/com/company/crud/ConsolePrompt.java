package com.company.crud;

import asg.cliche.Command;
import com.company.core.UserDaoInMemory;
import com.company.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class ConsolePrompt {
    private static final Logger log = LoggerFactory.getLogger(ConsolePrompt.class.getName());

    @Autowired
    private UserDaoInMemory userDaoInMemory;


    @Command
    public void add(String login, String password, String name) {
        userDaoInMemory.createUser(new User(login, password, name));
    }

    @Command
    public void print(Integer userId) {
        userDaoInMemory.getById(userId);
    }

    @Command
    public void delete(Integer userId) {
        userDaoInMemory.deleteUser(userId);
    }

    @Command
    public void update(Integer userId, String login, String password, String name) {
        User user = new User(login, password, name);
        user.setId(userId);
        userDaoInMemory.updateUser(user);
    }

    @Command
    public void printAll() {
        ArrayList<User> list = userDaoInMemory.getAll();
        for (User user : list) {
            log.info("User {} {} {}", user.getId(), user.getLogin(), user.getName());
        }
    }
    @Command
    public void help() {
        log.info("\nadd login password name \n" +
                "delete userid\n" +
                "update login password name\n" +
                "printall\n" +
                "print userid");
    }
}
