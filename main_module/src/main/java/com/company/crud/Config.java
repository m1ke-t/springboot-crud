package com.company.crud;

import com.company.core.Storage;
import com.company.core.UserDaoInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
        @Bean("udim")
        UserDaoInMemory userDaoInMemory() {
            return new UserDaoInMemory();
        }

        @Bean
        Storage storage() {
            return Storage.getInstance();
        }
}
