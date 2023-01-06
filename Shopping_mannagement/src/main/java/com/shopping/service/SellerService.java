package com.shopping.service;

import java.util.List;

import com.shopping.entity.Products;
import com.shopping.entity.Seller;

public interface SellerService {
	String createSeller(Seller seller);

	String AddProduct(Products product);

	Products updateproduct(Products product, int id);

	List<Products> getall();

	String deleteproduct(int id);

	String deleteAll();
	
	Seller getbyIdSeller(int id);
}
