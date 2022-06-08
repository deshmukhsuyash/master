package com.aa.socialmedia.service;

import java.util.List;

import com.aa.socialmedia.model.ValidationRequest;

public interface ValidationService {

	public List<String> isValid(ValidationRequest request);

	public ValidationRequest getPersonJson();

}
