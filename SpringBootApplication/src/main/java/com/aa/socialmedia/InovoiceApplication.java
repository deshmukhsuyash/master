package com.aa.socialmedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aa.socialmedia.controller.Controller;
import com.aa.socialmedia.repository.InovoiceRepository;
import com.aa.socialmedia.repository.UserRepository;

@SpringBootApplication
public class InovoiceApplication implements CommandLineRunner {

	@Autowired
	InovoiceRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(InovoiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(InovoiceApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		
		log.info("Student id 10001 -> {}", repository.findAll());
		
	}


}
