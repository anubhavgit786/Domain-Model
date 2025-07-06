package com.example.demo;

import com.example.demo.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)
	{
		//SpringApplication.run(DemoApplication.class, args);

		//var user = new User();
		//user.setId(123L);
		//user.setName("abc");
		//user.setPassword("123");
		//user.setEmail("abc@123");

		//var user = new User(123L, "abc", "123", "abc@123");

		var user = User.builder()
				.id(123L)
				.name("abc")
				.password("123")
				.email("abc@123")
				.build();

		System.out.println("User: " + user);
	}

}
