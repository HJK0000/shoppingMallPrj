package com.green.security.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.security.config.CustomUserDetails;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/")
	public String welcome(Model model, Principal principal, @AuthenticationPrincipal CustomUserDetails customUserDetails) {

		System.out.println("admin welcome......");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 스프링 프레임워크 안에 있는 UserDetails
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
				
		model.addAttribute("username", userDetails.getUsername());
		model.addAttribute("name", userDetails.getName()); // UserDetails는 id,pw밖에 못 가지고 오는데 우리가 만든 CustomUserDetails 구현체로 형변환해서 받아오면 member의 name도 가지고 올 수 잇다.
		
		// Principal 객체 주입 : 사용자 인증 정보를 가진 객체
		
		model.addAttribute("username2", principal.getName()); // principal의 getName의 username(id)를 의미한다..
		
		// @AuthenticationPrincipal을 사용하여 UserDetails 인터페이스의 구현체 CustomUserDetails 객체를
		// 주입받아 사용하기(매개변수 주목)!
		
		model.addAttribute("username3", customUserDetails.getUsername());
		model.addAttribute("name3", customUserDetails.getName());
		model.addAttribute("role3", customUserDetails.getRole());
		
		return "admin/welcome";
	}
}
