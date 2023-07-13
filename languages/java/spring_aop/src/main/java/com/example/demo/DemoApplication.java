package com.example.demo;

import com.example.demo.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	private Subject subject;

	@Override
	public void run(String... args) {
		System.out.println(subject.doAction("I'm doing an action"));
	}
}
