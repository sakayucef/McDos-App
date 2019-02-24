package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.McDoDao;

@SpringBootApplication
public class McDoApplication implements CommandLineRunner{

	
	@Autowired
	private 	 McDoDao	McDoRepository;
	public static void main(String[] args) {
		SpringApplication.run(McDoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
