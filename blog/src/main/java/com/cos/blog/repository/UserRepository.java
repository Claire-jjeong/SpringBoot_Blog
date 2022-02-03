package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//DAO
//자동으로 bean등록이 된다
//@Repository 생략 가능 
public interface UserRepository extends JpaRepository<User,Integer>{
//해당 jpa레파지토리는 유저테이블이 관리, user tbl의 pk는 Integer

}
