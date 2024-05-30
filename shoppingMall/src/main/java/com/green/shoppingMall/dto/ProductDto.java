package com.green.shoppingMall.dto;

import lombok.Data;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;

@Data
public class ProductDto {

	//private Long pnum; 
	//private String pcategory;
	//private String pdelievery;
	//private String poriginName;
	//private String pnewName;
	//private String pthumbnailName;
	//private String pinfo;
	//private String pname;
	//private Long pprice;
	//private LocalDateTime pregdate;
	//private Long psoldcount;
	//private String pstate;
	//private Long punitprice;
	//private Long ptotalcount;

	// gradle에 추가해야 import 가능
	private static ModelMapper modelMapper = new ModelMapper();

	public static ProductDto of(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}
}
