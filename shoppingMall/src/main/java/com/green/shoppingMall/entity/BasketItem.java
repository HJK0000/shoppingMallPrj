package com.green.shoppingMall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "basketItem")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bino;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "basket_id")
	private Basket basket;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;

	private Long count; // 장바구니 해당상품 개수

	public static BasketItem createBasketItem(Basket basket, Product product, Long amount) {

		BasketItem basketItem = new BasketItem();

		basketItem.setBasket(basket);
		basketItem.setProduct(product);
		basketItem.setCount(amount);
		return basketItem;

	}

	// 이미 담고 있는 물건을 또 담을 경우 수량 증가
	public void addCount(Long count) {

		this.count += count;

	}

}
