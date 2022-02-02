package com.cos.blog.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.User;

@RestController
public class DummyControllerTest {

	//http://localhost:8000/blog/dummy/join (요청)
	//http의 바디에 username,password,email 데이터를 가지고 요청
	@PostMapping("/dummy/join")
	public String join(User user) {
		
		System.out.println("id: "+user.getId());
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email : "+ user.getEmail());
		System.out.println("role : "+ user.getRole());
		System.out.println("createDate : "+ user.getCreateDate());
		return "회원가입이 완료되었습니다!";
	}
}
