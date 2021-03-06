package service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC (메모리에 대신 띄워준다) 
@Service
//1. 트랜잭션 관리 : 두 개의 트랜잭션을 하나로 묶어서 처리할 수 있음
//2. 서비스 의미때문에 
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional //하나의 트랜잭션으로 묶임 ,전체를 성공하면 commit, 하나라도 실패하면 rollback 
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
