package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cognizant")
public class StudentDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDbApplication.class, args);
	}

}
