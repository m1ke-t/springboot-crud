package com.company.crud;

import asg.cliche.Command;
import com.company.core.Storage;
import com.company.core.UserDaoInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
//    @Autowired
//    public void context(ApplicationContext context) { this.context = context; }
    @Autowired
    private UserDaoInMemory udim;
        @Bean("udim")
        UserDaoInMemory userDaoInMemory() {
            return new UserDaoInMemory();
        }

        @Bean
        Storage storage() {
            return Storage.getInstance();
        }
    @Command
    @Bean
    public String add() {
    udim.createUser();
    }
    @Bean
    @Command
    public String delete(Integer id) {
        return "Hello, World!";
    }
    @Bean
    @Command
    public String update() {
        return "Hello, World!";
    }
    @Bean
    @Command
    public String printAll() {
        return "Hello, World!";
    }
    @Bean
    @Command
    public String print() {
        return "Hello, World!";
    }
    @Bean
    @Command // two,
    public int add(int a, int b) {
        return a + b;
    }
}
