package com.aa.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.socialmedia.model.ValidationRequest;
import com.aa.socialmedia.service.ValidationService;

@RestController
@RequestMapping(value = "/api/validate")
public class ValidationController {

	@Autowired
	private ValidationService service;

	@PostMapping("validate-person")
	public List<String> validateRequest(@RequestBody ValidationRequest request) {

		return service.isValid(request);

	}

	@GetMapping
	public ValidationRequest getPersonJson() {
		return service.getPersonJson();

	}

}
