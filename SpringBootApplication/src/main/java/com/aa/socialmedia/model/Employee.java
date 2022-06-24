package com.aa.socialmedia.model;

import com.aa.socialmedia.util.Conditional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Conditional(required = { "customerId" })
public class Employee {

	private Integer customerId;
	private String name;
	private String phoneNumber;

	String[] required;

}
