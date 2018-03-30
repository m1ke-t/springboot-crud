package com.company.crud;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import com.company.core.UserDaoInMemory;
import com.company.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import sun.plugin2.gluegen.runtime.CPU;

import java.io.IOException;
import java.util.ArrayList;

public class ConsolePrompt {
    private static final Logger log = LoggerFactory.getLogger(ConsolePrompt.class.getName());


    private ConsolePrompt cp;
    @Autowired
    public void cp(ConsolePrompt cp) {	this.cp = cp; }

    private UserDaoInMemory ud;
    @Autowired
    public void ud(UserDaoInMemory ud) {	this.ud = ud;	}


    public void startPrompt() throws IOException
    {
        ShellFactory.createConsoleShell("command", "Create, Update, Delete. \nPrint help to list available commands",
            cp).commandLoop();
    }

    @Command
    public void add(String login, String password, String name) {
        ud.createUser(new User(login, password, name));
    }

    @Command
    public void print(Integer userId) {
        ud.getById(userId);
    }

    @Command
    public void delete(Integer userId) {
        ud.deleteUser(userId);
    }

    @Command
    public void update(Integer userId, String login, String password, String name) {
        User user = new User(login, password, name);
        user.setId(userId);
        ud.updateUser(user);
    }

    @Command
    public void printAll() {
        ArrayList<User> list = ud.getAll();
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
