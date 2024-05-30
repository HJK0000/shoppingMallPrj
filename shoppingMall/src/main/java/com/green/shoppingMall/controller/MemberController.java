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
import jakarta.websocket.Session;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BasketRepositoty basketRepository;

	public void test() {
		System.out.println(userRepository.getClass().getName());

	}

	@RequestMapping("/registForm")
	public String registForm() {

		return "member/registForm";
	}

	@RequestMapping("/regist")
	public String regist(Model model, HttpServletRequest request) {

		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String role = request.getParameter("role");
		// LocalDate now = LocalDate.now();

		User user = User.builder().username(username).password1(password1).password2(password2).name(name).tel(tel)
				.addr(addr).created_at(LocalDateTime.now()).role("ROLE_MEMBER").build();

		userRepository.save(user);

		return "member/loginForm";

	}

	@RequestMapping("/loginForm")
	public String loginForm() {

		return "member/loginForm";
	}

	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User userResult = userRepository.findByUsernameAndPassword1(username, password);
		
		log.info("username = " + username);
		log.info("password = " + password);
		
		String role = userResult.getRole();
		
		log.info("role = " + role);
		

		HttpSession session = request.getSession();
		session.setAttribute("id", username);
		session.setAttribute("role", role);
		

		List<Product> result = productRepository.findAll();

		Collections.sort(result, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return Long.compare(p2.getPsoldcount(), p1.getPsoldcount());

			}

		});

		List<Product> result2 = productRepository.findAll();

		Collections.sort(result2, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p2.getPregdate().compareTo(p1.getPregdate());

			}

		});

		model.addAttribute("soldCountList", result);
		model.addAttribute("recentUpdateList", result2);
		
		return "index";
		
	}
		
		
//		if (role.equals("ROLE_MEMBER")) {
//
//			HttpSession session = request.getSession();
//			session.setAttribute("id", username);
//			session.setAttribute("role", role);
//			
//			return "/";
//
//		} else if (role.equals("ROLE_ADMIN")) {
//
//			HttpSession session = request.getSession();
//			session.setAttribute("id", username);
//			session.setAttribute("role", role);
//		} else {
//
//			return "index";
//		}
//
//		return "index";
//	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.getAttribute("id");
		session.invalidate();
		// System.out.println("로그아웃 됨");
		return "redirect:/";
	}

	@RequestMapping("/toMyBasket")
	public String toMyBastket(HttpServletRequest request, Model model, HttpSession session) {

		Long pnum = Long.parseLong(request.getParameter("pnum"));
		Product product = productRepository.findById(pnum).orElse(null);

		product.getPprice();

		String id = (String) session.getAttribute("id");
		User user = userRepository.findByusername(id).orElse(null);

		if (user == null) {

			model.addAttribute("errorMessage", "로그인이 필요합니다.");
			return "member/loginForm";

		}

		Basket basket = new Basket();

		basket.setUser(user);
		basket.setPnum(product);
		basket.setBasket_count(1L);
		basket.setBasket_price(product.getPprice());

		basketRepository.save(basket);

		model.addAttribute("product", product); // 내가 선택한 pnum에 해당하는 product
		model.addAttribute("basket", basket); // 장바구니 내용

		return "member/basket";
	}

}
