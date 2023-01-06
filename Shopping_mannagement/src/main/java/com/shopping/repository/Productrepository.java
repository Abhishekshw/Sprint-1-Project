package com.shopping.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.entity.Products;

public interface Productrepository extends JpaRepository<Products, Integer> {

	@Query("from Products where pname like :s%")
	public List<Products> getByName(@Param("s") String name);
}
