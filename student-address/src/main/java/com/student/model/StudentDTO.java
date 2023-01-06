package com.student.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.student.entity.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {

	private int id;
	@Size(min = 3, message = "name is invalid")
	private String studentName;

//	@Pattern(regexp = "^\\d{10}$", message = "Phone number should have 10 digits")
	@Min(value = 10, message = "should be 10 phone")
	private long phone;

	@Email
	private String email;

	private Address address;
}
