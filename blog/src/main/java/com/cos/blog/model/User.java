package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴!
@Entity //테이블화 -> User클래스가 MySQL에 테이블이 생성이 된다.
//@DynamicInsert // insert 할 때 null인 필드 제외 
public class User {

	@Id //Primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; //시퀀스, auto_increment
	
	@Column(nullable=false, length=30)
	private String username; //아이디
	 
	@Column(nullable=false, length=100) //암호화 된 비밀번호를 넣을 것이기 때문에 넉넉하게 !
	private String password;
	
	@Column(nullable=false, length=50)
	private String email;
	
	//@ColumnDefault("user")
	//DB는 RoleType이라는게 없다 
	@Enumerated(EnumType.STRING) //해당 enum은 string 이다 
	private RoleType role; //Enum을 쓰는게 좋다.  
	
	@CreationTimestamp //시간이 자동 입력 (비워놔도)
	private Timestamp createDate;
	
}
