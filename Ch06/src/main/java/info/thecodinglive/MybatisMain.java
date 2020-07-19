package info.thecodinglive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

import info.thecodinglive.model.UserVO;
import info.thecodinglive.repository.UserRepositoryHsqldb;


@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class MybatisMain implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(MybatisMain.class, args);
	}
	
	@Autowired
	UserRepositoryHsqldb repositoryHsqldb;
	
	@Override
	public void run(String... args) throws Exception{
		UserVO userEntity = new UserVO("test4", "jpub", "qwer1234");
		repositoryHsqldb.addUserInfo(userEntity);
		System.out.println(repositoryHsqldb.getuserInfoAll().toString());
		System.out.println("like 이름 검색");
		System.out.println(repositoryHsqldb.findByUserNameLike("ki").toString());
		System.out.println("단건 조회");
		UserVO userVO = repositoryHsqldb.findByUserName("jpub");
		System.out.println(userVO.getId() + ", " + userVO.getPassWord() + ", " + userVO.getUserName());
	}
}
