package info.thecodinglive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import info.thecodinglive.model.UserEntity;
import info.thecodinglive.model.UserRole;
import info.thecodinglive.repository.UserRepository;

@SpringBootApplication
public class JPAMain {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		userRepository.save(new UserEntity("������", 60, UserRole.ADMIN));
		UserEntity user = userRepository.findByUserName("������");
		System.out.println("���� : " + user.getAge() + ", �̸� : " + user.getUserName() + "������ : " + user.getCreatedAt());
	}
}
