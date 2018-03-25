package com.company.crud;
import com.company.core.UserDaoInMemory;
import com.company.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringbootCrudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootCrudApplication.class, args);
		UserDaoInMemory udim = (UserDaoInMemory) ctx.getBean("udim");

		udim.createUser(new User("fgd", "gfdg", "gfdg"));
		System.out.println(udim);
		UserDaoInMemory udim2 = new UserDaoInMemory();
		//udim2.createUser(new User("fds", "fds", "gds"));
	}
}
