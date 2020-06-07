package info.thecodinglive;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import info.thecodinglive.model.UserEntity;
import info.thecodinglive.model.UserRole;
import info.thecodinglive.querydsl.UserRepository;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class QuerydslApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(QuerydslApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		userRepository.save(new UserEntity("ȫ�浿", 33, UserRole.USER));
		userRepository.save(new UserEntity("ȫ����", 33, UserRole.USER));
		userRepository.save(new UserEntity("��ȫ��", 33, UserRole.USER));
		userRepository.save(new UserEntity("����ȫ", 33, UserRole.USER));
		
		userRepository.save(new UserEntity("ö��", 24, UserRole.USER));
		userRepository.save(new UserEntity("����", 7, UserRole.USER));
		userRepository.save(new UserEntity("ô�ذ�", 41, UserRole.USER));
		userRepository.save(new UserEntity("���Ͻ�", 80, UserRole.USER));
		userRepository.save(new UserEntity("���", 10, UserRole.USER));
		
		List<UserEntity> resultList = userRepository.findAllLike("%ȫ%");
		
		System.out.printf("�̸��� ȫ�� ������ �ο� �� : %d \n", resultList.size());
		
		for(UserEntity u : resultList) {
			System.out.println(u.getUserName());
		}
	}
}
