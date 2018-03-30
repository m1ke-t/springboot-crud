package com.company.crud;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import com.company.core.UserDaoInMemory;
import com.company.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import sun.plugin2.gluegen.runtime.CPU;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mike S. on 29.03.2018.
 */
public class ConsolePrompt {

    private ConsolePrompt cp;
    @Autowired
    public void cp(ConsolePrompt cp) {	this.cp = cp; }

    private UserDaoInMemory ud;
    @Autowired
    public void ud(UserDaoInMemory ud) {	this.ud = ud;	}


    public void startPrompt() throws IOException
    {
        ShellFactory.createConsoleShell("cliche> ", "Enter '?list' to list all commands",
            cp).commandLoop();
    }

    @Command
    public void add(String login, String password, String name) {
        ud.createUser(new User(login, password, name));
    }

    @Command
    public String print() {
        return "Hello, World!";
    }

    @Command
    public String delete(Integer id) {
        return "Hello, World!";
    }

    @Command
    public String update() {
        return "Hello, World!";
    }

    @Command
    public void printAll() {
        ArrayList<User> list = ud.getAll();
        for (User user : list) {
            System.out.println(user.getId());
            System.out.println(user.getLogin());
            System.out.println(user.getName());
        }
    }
}
