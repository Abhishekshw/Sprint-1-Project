package com.shopping.serviceimpl;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.Products;
import com.shopping.entity.UserClass;
import com.shopping.repository.Productrepository;
import com.shopping.repository.UserRepository;
import com.shopping.service.UserService;

@Service
public class Userimpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Productrepository productrepository;

	@Override
	public String Createuser(UserClass userclass) {
		userRepository.save(userclass);
		return "Caustomar is created";
	}

	@Override
	public UserClass updateuser(int id, UserClass uc) {
		UserClass us = new UserClass();
		if (uc.getUid() == id) {
			us.setEmail(uc.getEmail());
			us.setPass(uc.getPass());
			us.setAddress(uc.getAddress());
			us.setPin(uc.getPin());
			userRepository.save(us);
		}
		return us;
	}

	@Override
	public UserClass veiwprofile(int id) {
		UserClass us = userRepository.findById(id).get();
		return us;
	}

	@Override
	public String delete(int id) {
		Optional<UserClass> us = userRepository.findById(id);
		if (us != null) {
			userRepository.deleteById(id);
			return "id deleted";
		}
		return "id not found";
	}

	
		@Override
		public List<Products> getProductByName(String name) {
			List<Products> products=productrepository.getByName(name);
			return products;
		}

		@Override
		public String orderPlace(int id, int productId) {
			
			UserClass userClass = userRepository.findById(id).get();
			Products product =productrepository.findById(productId).get();
			product.setUserClass(userClass);
			productrepository.save(product);
			
			return "Order Placed Successfully on date : "+LocalDate.now();
		}

	


}
