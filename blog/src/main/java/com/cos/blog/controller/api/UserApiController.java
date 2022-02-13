package com.cos.blog.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.User;

import dto.ResponseDto;

@RestController //데이터만 리턴 
public class UserApiController {

	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) { //요청 받는게 json이기 때문에 RequestBody선언 
		System.out.println("UserApiController : save 호출 됨 ");
		return new ResponseDto<Integer>(200,1);
	}
}