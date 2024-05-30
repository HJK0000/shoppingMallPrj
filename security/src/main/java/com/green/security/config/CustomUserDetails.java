package com.green.security.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.green.security.entity.Member;

public class CustomUserDetails implements UserDetails { // UserDetails implements해서 매서드 오버라이딩(security용 매서드-> 우리는 구현체
														// 만들어서 아래 사용한다)

	private Member member;

	public CustomUserDetails(Member member) {
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		// extends GrantedAuthority -> GrantedAuthority를 상속받은 애들(Member 등)은 Collection의
		// 타입으로 지정할 수 있다.
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {

				return member.getRole();
			}
		});

		return collection; // return이 null이면 인증, 인가가 안될 수 있다. return은 꼭 위의 collection의 참조변수로 해준다.

	}

	@Override
	public String getPassword() {

		return member.getPassword();
	}

	@Override
	public String getUsername() {

		return member.getUsername();

	}

	public String getName() { // 필요하면 가져다 씀

		return member.getName();

	}

	public String getRole() { // 필요하면 가져다 씀

		return member.getRole();

	}

	@Override
	public boolean isAccountNonExpired() {

		return true;

	}

	@Override
	public boolean isAccountNonLocked() {

		return true;

	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
