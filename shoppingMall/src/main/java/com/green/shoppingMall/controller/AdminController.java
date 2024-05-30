package com.green.shoppingMall.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.shoppingMall.dto.ProductDto;
import com.green.shoppingMall.entity.Product;
import com.green.shoppingMall.repository.ProductRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductRepository productRepository;

	@Value("${spring.servlet.multipart.location}")
	String uploadPath;

	@RequestMapping("/productRegistForm")
	public String productRegistForm() {

		return "admin/productRegistForm";

	}

	@RequestMapping("/regist")
	public String regist(com.green.shoppingMall.dto.Product product, HttpServletRequest request) {

		HttpSession session = request.getSession();

		String aid = (String) session.getAttribute("id");
		String role = (String) session.getAttribute("role");

//		if (aid == null && role != "ROLE_ADMIN") {

//			return "error";

//		} else {

		// ProductDto productDto = new ProductDto();

		System.out.println("파라미터로 받는 product = " + product);

		Product productE = new Product();
		productE.setPcategory(product.getPcategory());
		productE.setPdelievery(product.getPdelievery());
		productE.setPinfo(product.getPinfo());
		productE.setPname(product.getPname());
		String Pprice_ = product.getPprice();
		Long pprice = Long.parseLong(Pprice_);
		productE.setPprice(pprice);
		productE.setPtotalcount(product.getPtotalcount());
		LocalDateTime now = LocalDateTime.now();
		productE.setPregdate(now);
		productE.setPstate(product.getPstate());
		productE.setPsoldcount(0L);
		String originName = product.getFileName();
		productE.setPorigin_name(originName);

		log.info(originName);

		String newName = UUID.randomUUID().toString() + "_" + originName;
		log.info(newName);
		productE.setPnewName(newName);

		// 파일 저장
		File file = new File(newName);

		try {

			product.getFile().transferTo(file);
			log.info("파일업로드 성공");

			// 썸네일 생성
			String thumbnailSaveName = "s_" + newName; // 스몰이미지(s_) + 새로만든 이름 --> 섬네일 이름
			productE.setPthumbnailName(thumbnailSaveName);

			File thumbnailFile = new File(uploadPath + thumbnailSaveName); // 섬네일 파일 생성
			File ufile = new File(uploadPath + newName);

			// Thumbnailator.createThumbnail(file, thumbnailFile, 100, 100);
			Thumbnails.of(ufile).size(100, 100).toFile(thumbnailFile); // 섬네일 사이즈 100 100 설정
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("저장할 product = " + productE);
		productRepository.save(productE);
		return "redirect:/";

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.getAttribute("id");
		session.invalidate();
		// System.out.println(" 관리자 로그아웃 됨");
		return "redirect:/";
	}

}
