package info.thecodinglive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import info.thecodinglive.service.SchoolService;

@SpringBootApplication
public class OneToManyRun {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
		SchoolService schoolService = context.getBean(SchoolService.class);
		schoolService.findSchoolInfo();
	}
}
