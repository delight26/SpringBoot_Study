package info.thecodinglive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

import info.thecodinglive.repository.UserRepositoryHsqldb;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class ForEachMain implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(ForEachMain.class, args);
	}
	
	@Autowired
	UserRepositoryHsqldb userRepositoryHsqldb;

	@Override
	public void run(String... args) throws Exception {
		List<String> userList = new ArrayList<String>();
		
		userList.add("test1");
		userList.add("test2");
		userList.add("test3");
		
		Map<String, Object> paraMap	 = new HashMap<String, Object>();
		
		paraMap.put("user_list", userList);
		
		System.out.println(userRepositoryHsqldb.findByForeach(paraMap));
	}
	
}
