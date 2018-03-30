package com.company.crud;

import com.company.core.Storage;
import com.company.core.UserDaoInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

//    private ConfigurableApplicationContext context;
//    @Autowired
//    public void context(ConfigurableApplicationContext context) { this.context = context; }
//
//    private UserDaoInMemory ud = (UserDaoInMemory) context.getBean("udim");


    @Bean("udim")
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
    //@Scope("prototype")
    public SpringbootCrudApplication sbca() {
        return new SpringbootCrudApplication();
    }







}
