package com.green.shoppingMall.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {

	private String pcategory;
	private String pname;
	private String pprice;
	private String pinfo;
	private String pstate;
	private MultipartFile file;
	private Long ptotalcount;
	private String pdelievery;

	public String getFileName() {
		return file.getOriginalFilename();
	}
}
