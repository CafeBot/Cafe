package com.incedo.Cafe;

import ch.qos.logback.classic.db.SQLBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.Query;

@SpringBootApplication
public class CafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);
		System.out.println("Heello");
		Greeting g =new Greeting(1,"sssd");
		System.out.println(g);

		//SQLBuilder sq =new SQLBuilder();


	}

}
