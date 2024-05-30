package com.green.shoppingMall.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import com.green.shoppingMall.dto.ProductDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pnum;
	@Column(name = "pname", length = 50, nullable = false)
	private String pname;
	@Column(nullable = false)
	private Long pprice;
	@Column(name = "pinfo", length = 1000, nullable = false)
	private String pinfo;
	@Column(name = "porigin_name", length = 100, nullable = true)
	private String porigin_name;
	@Column(name = "pnewName", length = 100, nullable = true)
	private String pnewName;
	@Column(name = "pthumbnailName", length = 100, nullable = true)
	private String pthumbnailName;
	@Column(name = "pstate", length = 10, nullable = false)
	private String pstate;
	@Column(name = "ptotalcount", nullable = true)
	private Long ptotalcount;
	@Column(name = "psoldcount", nullable = false)
	private Long psoldcount;
	@Column(name = "pregdate", nullable = false)
	@ColumnDefault("now()") // default = now()
	private LocalDateTime pregdate;
	@Column(name = "pcategory", nullable = false)
	private String pcategory;
	@Column(name = "pdelievery", nullable = false)
	private String pdelievery;
	@Column(name = "punitprice", nullable = true)
	private Long punitprice;

	// gradle에 추가해야 import 가능
	private static ModelMapper modelMapper = new ModelMapper();

	public static ProductDto of(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}

}
