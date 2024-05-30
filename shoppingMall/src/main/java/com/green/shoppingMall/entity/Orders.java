package com.green.shoppingMall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ono;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "username") // 구매자 정보용(이름, 이메일, 전번) & 받는 사람 정보용(이름, 배송주소, 연라처, 배송 요청사항 등)
	//@ToString.Exclude
	private User username;
	
	@OneToOne
	@NotNull
	@JoinColumn(name = "pname") // 제품 정보 가져오는 용도
	//@ToString.Exclude
	private Product pname;
	
	@OneToOne
	@NotNull
	@JoinColumn(name = "bno") // 장바구니에 담은 품목들
	//@ToString.Exclude
	private Basket bno;
	
}