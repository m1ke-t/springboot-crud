package com.company.crud;
import asg.cliche.Command;
import com.company.core.UserDao;
import com.company.core.UserDaoInMemory;
import com.company.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringbootCrudApplication {
	@Command // One
	public String hello() {
		return "Hello, World!";
	}

	@Command // two,
	public int add(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootCrudApplication.class, args);
		UserDao ud = (UserDaoInMemory) ctx.getBean("udim");

		ud.createUser(new User("fgd", "gfdg", "gfdg"));
		System.out.println(ud);




//		UserDaoInMemory udim2 = new UserDaoInMemory();
		//udim2.createUser(new User("fds", "fds", "gds"));
	}
}
