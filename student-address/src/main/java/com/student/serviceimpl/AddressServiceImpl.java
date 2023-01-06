package com.student.serviceimpl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Address;
import com.student.entity.Student;
import com.student.repository.AddressRepository;
import com.student.service.AddressService;
import com.student.util.AddressConverter;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	AddressConverter addressConverter;
	private static final Logger l =LoggerFactory.getLogger(Address.class);
	@Override
	public String createAddress(Address address) {
		String message=null;
		addressRepository.save(address);
		if(address!=null)
		{
			message="New address saved successfully!!";
		}
		else
		{
			message="Address was not saved!!";
		}
		
		l.info("Address "+address.toString()+" added at date : "+new Date());
		return message;
	}
	

}
