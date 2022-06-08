package com.aa.socialmedia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Conditional(required = { "customerId", "name" })
public class Person {

	private Integer customerId;
	private String name;
	private String phoneNumber;

	// String[] required;

}
