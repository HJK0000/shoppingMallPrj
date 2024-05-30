package com.green.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.security.entity.Member;
import com.green.security.repository.MemberRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// username으로 사용자를 load함
		// +) form의 id의 name은 id가 아닌 username으로 쓰자!(security에서 정해져있음)

		// UserDetails가 원하는건 db의 사용자정보!

		Member member = memberRepository.findByUsername(username); // username으로 Member객체를 얻어냄

		if (member != null) {

			return new CustomUserDetails(member); // 앞서서 만든 클래스에 담아준다.
		}

		return null;
	}

}
