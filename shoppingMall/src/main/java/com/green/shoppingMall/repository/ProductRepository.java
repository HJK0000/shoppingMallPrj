package com.green.shoppingMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.shoppingMall.dto.ProductDto;
import com.green.shoppingMall.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	// 쿼리 매서드
		
	
	
}
