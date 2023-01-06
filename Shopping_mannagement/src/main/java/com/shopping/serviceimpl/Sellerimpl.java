package com.shopping.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.Products;
import com.shopping.entity.Seller;
import com.shopping.repository.Productrepository;
import com.shopping.repository.SellerRepository;
import com.shopping.service.SellerService;

@Service
public class Sellerimpl implements SellerService {
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private Productrepository productrepository;

	@Override
	public String createSeller(Seller seller) {
		if (seller != null) {
			sellerRepository.save(seller);
			return " seller created";
		} else {
			return "failed to create Seller";
		}
	}

	@Override
	public String AddProduct(Products product) {
		if (product != null) {
			
			productrepository.save(product);
			return " product added";
		} else {
			return "failed to add product";
		}
	}

	@Override
	public Products updateproduct(Products product, int id) {
		Products pro = new Products();
		if (product.getProductId() == id) {
			pro.setPname(product.getPname());
			pro.setPDiscription(product.getPDiscription());
			pro.setPrice(product.getPrice());

		}
		return pro;
	}

	@Override
	public List<Products> getall() {
		List<Products> prod = productrepository.findAll();
		return prod;
	}

	@Override
	public String deleteproduct(int id) {
		Optional<Products> us = productrepository.findById(id);
		if (us != null) {
			productrepository.deleteById(id);
			return "id deleted";
		}
		return "id not found";
	}

	@Override
	public String deleteAll() {
		productrepository.deleteAll();
		return "all product are deleted";
	}

	@Override
	public Seller getbyIdSeller(int id) {
		Seller seller =sellerRepository.findById(id).get();	
		
		return seller;
	}

}
