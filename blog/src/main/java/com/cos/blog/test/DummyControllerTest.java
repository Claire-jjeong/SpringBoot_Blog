package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController //html파일이 아니라 데이터만 리턴 해주는 컨트롤러 
public class DummyControllerTest {

	@Autowired //의존성 주입 
	private UserRepository userRepository;
	
	
	@GetMapping("/dummy/users")
	public List<User>list(){
		return userRepository.findAll();
	}
	
	//한 페이지당 2건의 데이터를 리턴받아 볼 예정 
	@GetMapping("dummy/user")								//한 페이지 당 2건이기 때문에 사이즈 2
	public List<User>pageList(@PageableDefault(size=2, sort="id",direction=Sort.Direction.DESC)Pageable pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	//{id}주소로 파라미터를 전달 받을 수 있음
	//http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user/4를 찾으면 내가 데이터베이스에서 못찾아오면 null 값
		// null값 리턴-> 프로그램에 문제
		//Optinal로 user 객체 감싸서 가져올테니 null인지 아닌지 판단 필요 
		
		//람다식
		//User user = userRepository.findById(id).orElseThrow(()->{
		//		return new IllegalArgumentException("해당사용자는 없습니다.");
		//});
		//return user;
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id : "+id);
			}
		});
		//요청 : 웹 브라우저 
		//user객체 = 자바 오브젝트 
		//변환(웹브라우저가 이해할 수 있는 데이터) -> json (Gson라이브러리 사용)
		//스프링부트 = MessageConverter라는 애가 응답시에 자동으로 작동 
		// 만약 자바 오브젝트를 리턴 -> MessageConverter가 Jackson라이브러리 호출해서
		//user 오브젝트 -> json으로 변해서 브라우저에게 전달 
		return user;
	}
	//http://localhost:8000/blog/dummy/join (요청)
	//http의 바디에 username,password,email 데이터를 가지고 요청
	@PostMapping("/dummy/join")
	public String join(User user) { //오브젝트로 받아주기 
		
		System.out.println("id: "+user.getId());
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email : "+ user.getEmail());
		System.out.println("role : "+ user.getRole());
		System.out.println("createDate : "+ user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다!";
	}
}
