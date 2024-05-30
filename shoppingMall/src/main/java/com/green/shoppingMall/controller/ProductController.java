package com.green.shoppingMall.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.shoppingMall.entity.Basket;
import com.green.shoppingMall.entity.Product;
import com.green.shoppingMall.entity.User;
import com.green.shoppingMall.repository.BasketRepositoty;
import com.green.shoppingMall.repository.ProductRepository;
import com.green.shoppingMall.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BasketRepositoty basketRepository;

	public void test() {
		System.out.println(userRepository.getClass().getName());

	}

	@RequestMapping("/productDetail")
	public String productDetail(Model model, HttpServletRequest request) {

		String spnum = request.getParameter("pnum");
		Long pnum = Long.parseLong(spnum);
		Product product = productRepository.findById(pnum).orElse(null);

		model.addAttribute("product", product);

		return "member/productDetail";

	}

}
