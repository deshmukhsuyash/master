package com.aa.socialmedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aa.socialmedia.repository.InovoiceRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootApplication {

	@Autowired
	InovoiceRepository repository;

	public static void main(String[] args) {
		log.info("Strting application");
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
