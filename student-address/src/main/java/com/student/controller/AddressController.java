package com.student.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Address;
import com.student.model.AddressDTO;
import com.student.service.AddressService;
import com.student.util.AddressConverter;

@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressConverter addressConverter;
	
	@PostMapping("/createAddress")
	public String createAddress(@Valid @RequestBody AddressDTO addressDTO)
	{
		final Address address= addressConverter.convertToAddressEntity(addressDTO);
		return addressService.createAddress(address);
	}
}
