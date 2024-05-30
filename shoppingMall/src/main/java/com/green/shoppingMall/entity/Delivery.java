package com.green.shoppingMall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "delivery")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Delivery {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dno;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "username")
	//@ToString.Exclude
	private User username;
	
	@Column(name = "dname", length = 50)
	@NotNull
	private String dname;
	
	@Column(length = 100)
	@NotNull
	private String daddr;
	
	@Column(length = 13)
	@NotNull
	private String dtel;
	
	@Column(length = 30, nullable = true) // null일 수 있음. 
	private String dstate; // 문앞, 배송 전 연락주세요 등
}