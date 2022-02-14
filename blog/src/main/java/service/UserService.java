package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC
@Service
//1. 트랜잭션 관리
//2. 서비스 의미때문에 
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public int 회원가입(User user) {
		try {
			userRepository.save(user);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입(): " + e.getMessage());
		}
		return -1;
	}
}
