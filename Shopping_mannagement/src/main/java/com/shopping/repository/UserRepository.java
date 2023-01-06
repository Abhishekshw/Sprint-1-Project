package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.UserClass;

public interface UserRepository extends JpaRepository<UserClass, Integer> {

}
