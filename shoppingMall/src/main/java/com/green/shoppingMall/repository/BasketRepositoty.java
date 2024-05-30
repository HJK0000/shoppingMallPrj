package com.green.shoppingMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.shoppingMall.entity.Basket;

public interface BasketRepositoty extends JpaRepository<Basket, Long> {
	
	

}
