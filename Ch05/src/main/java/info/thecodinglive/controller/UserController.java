package info.thecodinglive.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import info.thecodinglive.model.User;

@RestController
public class UserController {
	private static List<User> userList = new ArrayList<User>();
	{
		userList.add(new User(1,"jpub01", "user01@test.com", "remine", new Date()));
		userList.add(new User(2,"jpub02", "user02@test.com", "restart", new Date()));
		userList.add(new User(3,"jpub03", "user03@test.com", "nine", new Date()));
		userList.add(new User(4,"jpub04", "user04@test.com", "namu", new Date()));
	}
	
	@RequestMapping("/user/{userNo}")
	public ResponseEntity<User> getUserInfo(@PathVariable int userNo){
		User user = userList.get(userNo);
		UriComponentsBuilder.newInstance().scheme("http")
									.host("movie.naver.com")
									.port(80)
									.path("/movie/sdk/rank/rmovie.nhn")
									.queryParam("code", 146506)
									.build()
									.encode()
									.toUri();
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping("/book/{bookId}")
	public void getBookInfo(@PathVariable int bookId){
		UriComponentsBuilder.newInstance().scheme("http")
									.host("test.book.com")
									.port(80)
									.path("/book/{bookId}")
									.build().expand(bookId)
									.encode()
									.toUri();
	}
	
	@RequestMapping("/user")
	public ResponseEntity<List<User>> getUserList(){
		HashMap<String, Object> resultList = new HashMap<String, Object>();
		resultList.put("result", userList);
		
		return new ResponseEntity(resultList, HttpStatus.OK);
	}
}
