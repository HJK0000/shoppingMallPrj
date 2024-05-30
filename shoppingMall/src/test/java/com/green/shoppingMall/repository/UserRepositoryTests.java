package com.green.shoppingMall.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.green.shoppingMall.entity.User;

@SpringBootTest
//@Transactional
public class UserRepositoryTests {

	@Autowired
	UserRepository userRepository;

	@Test
	public void 회원가입() {

		IntStream.rangeClosed(1, 9).forEach(i -> {

			User user = User.builder().username("member" + i + "@gmail.com").addr("부산시 동래구 사직" + i + "동")
					.created_at(LocalDateTime.now()).name("홍길동").password1("1234").password2("1234").role("ROLE_MEMBER")
					.tel("010-" + i + i + i + i + "-" + i + i + i + i).build();
			User user2 = User.builder().username("admin" + i + "@gmail.com").addr("부산시 연제구 연산" + i + "동")
					.created_at(LocalDateTime.now()).name("임꺽정").password1("1234").password2("1234").role("ROLE_ADMIN")
					.tel("010-1234" + "-" + i + i + i + i).build();
			userRepository.save(user);
			userRepository.save(user2);

		});

	}

	@Test
	public void findByName() {

		List<User> list = userRepository.findByName("홍길동");

		for (User user : list) {
			System.out.println(user);

		}

	}

	@Test
	public void findByRoleMem() {

		List<User> list = userRepository.findByRole("ROLE_MEMBER");

		for (User user : list) {
			System.out.println(user);

		}

	}

	@Test
	public void findByRoleAdm() {

		List<User> list = userRepository.findByRole("ROLE_ADMIN");

		for (User user : list) {
			System.out.println(user);

		}

	}
}
