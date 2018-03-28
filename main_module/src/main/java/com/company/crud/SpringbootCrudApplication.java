package com.company.crud;
import asg.cliche.*;
import com.company.core.UserDao;
import com.company.core.UserDaoInMemory;
import com.company.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class SpringbootCrudApplication {


	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootCrudApplication.class, args);
		UserDao ud = (UserDaoInMemory) ctx.getBean("udim");

		ud.createUser(new User("fgd", "gfdg", "gfdg"));
		System.out.println(ud);

        ShellFactory.createConsoleShell("cliche> ", "Enter '?list' to list all commands",
                new SpringbootCrudApplication()).commandLoop();




//		UserDaoInMemory udim2 = new UserDaoInMemory();
		//udim2.createUser(new User("fds", "fds", "gds"));
	}
}
