package com.company.crud;

import com.company.core.Storage;
import com.company.core.UserDaoInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserDaoInMemory userDaoInMemory() {
        return new UserDaoInMemory();
    }

    @Bean
    public Storage storage() {
        return Storage.getInstance();
    }

    @Bean("consolePrompt")
    public ConsolePrompt consolePrompt() {
        return new ConsolePrompt();
    }

    @Bean
    public SpringbootCrudApplication sbca() {
        return new SpringbootCrudApplication();
    }
}
