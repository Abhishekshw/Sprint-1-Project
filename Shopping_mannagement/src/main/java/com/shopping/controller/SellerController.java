package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Products;
import com.shopping.entity.Seller;
import com.shopping.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private SellerService sellerService;

	@PostMapping("/create")
	public ResponseEntity<String> createSeller(@RequestBody Seller seller) {
		return new ResponseEntity<String>(sellerService.createSeller(seller), HttpStatus.CREATED);

	}

	@PostMapping("/addpro")
	public ResponseEntity<String> AddProduct(@RequestBody Products product) {
		return new ResponseEntity<String>(sellerService.AddProduct(product), HttpStatus.CREATED);
	}

	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Products> updateproduct(@RequestBody Products product, @PathVariable("id") int id) {
		return new ResponseEntity<Products>(sellerService.updateproduct(product, id), HttpStatus.OK);
	}

	@GetMapping("/getproduct")
	public ResponseEntity<List<Products>> getall() {
		return new ResponseEntity<List<Products>>(sellerService.getall(), HttpStatus.OK);
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteproduct(@PathVariable("id") int id) {
		return new ResponseEntity<String>(sellerService.deleteproduct(id), HttpStatus.OK);
	}

	@DeleteMapping("/delall")
	public ResponseEntity<String> deleteAllproduct() {
		return new ResponseEntity<String>(sellerService.deleteAll(), HttpStatus.OK);
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<Seller> getSellerById(@PathVariable("id") int id){
		return new ResponseEntity<Seller>(sellerService.getbyIdSeller(id),HttpStatus.OK);
	}
 }
