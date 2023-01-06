package com.shopping.service;

import java.util.List;

import com.shopping.entity.Products;
import com.shopping.entity.UserClass;

public interface UserService {
	String Createuser(UserClass userclass);

	UserClass updateuser(int id, UserClass uc);

	UserClass veiwprofile(int id);

	String delete(int id);
	List<Products> getProductByName(String name);
	
	String orderPlace(int id,int product);
	
	
}
