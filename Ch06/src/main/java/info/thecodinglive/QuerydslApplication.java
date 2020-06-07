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
		
		userRepository.save(new UserEntity("È«±æµ¿", 33, UserRole.USER));
		userRepository.save(new UserEntity("È«¿¬Èñ", 33, UserRole.USER));
		userRepository.save(new UserEntity("ÀÌÈ«·Ã", 33, UserRole.USER));
		userRepository.save(new UserEntity("Â÷¹ÌÈ«", 33, UserRole.USER));
		
		userRepository.save(new UserEntity("Ã¶¼ö", 24, UserRole.USER));
		userRepository.save(new UserEntity("¿µÈñ", 7, UserRole.USER));
		userRepository.save(new UserEntity("Ã´ÁØ°æ", 41, UserRole.USER));
		userRepository.save(new UserEntity("µ¥´Ï½º", 80, UserRole.USER));
		userRepository.save(new UserEntity("ºñ¼ó", 10, UserRole.USER));
		
		List<UserEntity> resultList = userRepository.findAllLike("%È«%");
		
		System.out.printf("ÀÌ¸§¿¡ È«À» Æ÷ÇÔÇÑ ÀÎ¿ø ¼ö : %d \n", resultList.size());
		
		for(UserEntity u : resultList) {
			System.out.println(u.getUserName());
		}
	}
}
