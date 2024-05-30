package com.green.shoppingMall.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "basket")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;

	@OneToOne
	@NotNull
	@JoinColumn(name = "username")
	private User user; // 구매자

	@OneToOne
	@NotNull
	@JoinColumn(name = "pnum")
	// @ToString.Exclude
	private Product pnum; // 상품
	private Long basket_count; // 카트에 담긴 총 상품 개수
	private Long basket_price;

	@DateTimeFormat(pattern = "uuuu-mm-dd")
	private LocalDate created_at;

	@PrePersist
	public void created_at() {
		this.created_at = LocalDate.now();

	}

	public static Basket createBasket(User user) { // 사용자가 들어오면 기본 장바구니 개수는 0, 장바구니 유저는 사용자 아이디로 세팅됨
		Basket basket = new Basket();
		basket.setBasket_count(0L);
		basket.setUser(user);
		return basket;
	}
}