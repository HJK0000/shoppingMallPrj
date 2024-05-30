package com.green.shoppingMall.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "stock")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno;
	
	@OneToOne
	@NotNull
	@JoinColumn(name = "pname")
	//@ToString.Exclude
	private Product pname;
	private Long stock_count; // 0일때도 있음
	
}
