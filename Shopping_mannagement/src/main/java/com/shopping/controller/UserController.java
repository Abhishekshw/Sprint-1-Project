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
import com.shopping.entity.UserClass;
import com.shopping.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<String> Createuser(@RequestBody UserClass userclass) {
		return new ResponseEntity<String>(userService.Createuser(userclass), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserClass> updateuser(@PathVariable("id") int id, @RequestBody UserClass uc) {
		return new ResponseEntity<UserClass>(userService.updateuser(id, uc), HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<UserClass> veiwprofile(@PathVariable("id") int id) {
		return new ResponseEntity<UserClass>(userService.veiwprofile(id), HttpStatus.OK);

	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		return new ResponseEntity<String>(userService.delete(id), HttpStatus.OK);
	}
	@GetMapping("/getProductByName/{name}")
	public ResponseEntity<List<Products>> getProductByName(@PathVariable("name") String name){
		return new ResponseEntity<List<Products>>(userService.getProductByName(name),HttpStatus.OK);
	}
	
	@PostMapping("/orderPlace/{id}/{productId}")
	public ResponseEntity<String> OrderPlaced(@PathVariable("id") int id,@PathVariable("productId") int productId){
		return new ResponseEntity<String>(userService.orderPlace(id, productId),HttpStatus.OK);
	}
	
}
