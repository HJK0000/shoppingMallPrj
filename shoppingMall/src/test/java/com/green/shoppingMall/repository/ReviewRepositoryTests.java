package com.green.shoppingMall.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.shoppingMall.entity.Review;
import com.green.shoppingMall.entity.User;

@SpringBootTest
public class ReviewRepositoryTests {

	//@Autowired
	//ReviewRepository reviewRepository;

	@Autowired
	UserRepository userRepository;

//	@Test
//	public void 리뷰등록() {
//
//		IntStream.rangeClosed(1, 9).forEach(i -> {
//
//			User user = userRepository.findByusername("member" + i + "@gmail.com");
//
//			Review review = Review.builder().preview("좋은 상품입니다..").pnum(i).username(user).build();
//
//		});

//	}

}
