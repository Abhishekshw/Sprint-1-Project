package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
