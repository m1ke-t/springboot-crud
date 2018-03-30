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


//	static private ConsolePrompt cp;
//	@Autowired
//	public static void consolePrompt(ConsolePrompt consolePrompt) {
//		cp = consolePrompt;
//	}

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootCrudApplication.class, args);
		//UserDao ud = (UserDaoInMemory) ctx.getBean("udim");

//		ud.createUser(new User("fgd", "gfdg", "gfdg"));
//		System.out.println(ud);


		//ConsolePrompt cp = (ConsolePrompt) ctx.getBean("consolePrompt");
		cp.startPrompt();



	}







}
