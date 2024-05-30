package com.green.shoppingMall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer { // 웹MVC컨피큐어를 구현하기 위한 구현체

	@Value("${spring.servlet.multipart.location}") // C:upload
	String uploadPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) { // 자원을 관리하는 매서드 -> addResourceHandler

		registry.addResourceHandler("/images/**").addResourceLocations("file:///" + uploadPath); // 실제 저장되는건 uploadPath에
																									// 저장되고, 뷰에서 읽어들이는건
																									// static - images
																									// 폴더에서 읽어들임

	}
}
