package com.example.demo;

import com.example.demo.models.Address;
import com.example.demo.models.Profile;
import com.example.demo.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication
{

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

		var address = Address.builder()
					.id(123L)
					.street("abc")
					.city("abc")
					.zip("abc")
					.state("abc")
					.build();

		user.addAddress(address);

		user.addTag("tag1");
		user.addTag("tag2");

		var profile = Profile.builder()
				.id(123L)
				.bio("bio")
				.phoneNumber("1234567890")
				.dateOfBirth(LocalDate.now())
				.loyaltyPoints(123)
				.build();

		user.setProfile(profile);

		System.out.println("User : " + user);

	}

}
