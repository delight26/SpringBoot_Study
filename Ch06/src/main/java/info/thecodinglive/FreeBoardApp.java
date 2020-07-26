package info.thecodinglive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

import info.thecodinglive.model.FreeBoardVO;
import info.thecodinglive.repository.FreeBoardRepository;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class FreeBoardApp implements CommandLineRunner{
	
	@Autowired
	FreeBoardRepository freeBoardRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FreeBoardApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("frebboard run");
		FreeBoardVO freeBoardVO = new FreeBoardVO();
		freeBoardVO.setUserName("홍길동");
		freeBoardVO.setCategory("101");
		freeBoardVO.setContent("자유게시판 첫 글");
		freeBoardVO.setTitle("안녕");
		
		freeBoardRepository.registBoard(freeBoardVO);
	}

}
