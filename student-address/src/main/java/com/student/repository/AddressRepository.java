package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
