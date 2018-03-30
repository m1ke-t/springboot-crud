package com.company.crud;
import asg.cliche.*;
import com.company.core.UserDao;
import com.company.core.UserDaoInMemory;
import com.company.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class SpringbootCrudApplication {

	private UserDaoInMemory ud;
	@Autowired
	public void ud(UserDaoInMemory ud) {	this.ud = ud;	}

	private static ConsolePrompt cp;
	@Autowired
	public void cp(ConsolePrompt cp) {	SpringbootCrudApplication.cp = cp;	}


	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootCrudApplication.class, args);
		cp.startPrompt();
	}
}
