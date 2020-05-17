package info.thecodinglive.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.http.client.config.RequestConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.thecodinglive.model.Todo;
import info.thecodinglive.model.TodoResource;

@RestController
@RequestMapping(value="/basic")
public class BasicController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/todo")
	public Todo basic(){
		return new Todo(counter.incrementAndGet(), "�������");
	}
	
	@RequestMapping(value="/todop", method=RequestMethod.POST)
	public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle) {
		return new Todo(counter.incrementAndGet(), todoTitle);
	} 
	
	@RequestMapping(value="/todor", method=RequestMethod.POST)
	public ResponseEntity<Todo> postBasicResponseEntity(@RequestParam(value = "todoTitle") String todoTitle){
		return new ResponseEntity(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/todos/{todoId}", method=RequestMethod.GET)
	public Todo getPath(@PathVariable int todoId){
		Todo todo1 = new Todo(1L, "��������");
		Todo todo2 = new Todo(2L, "��ȹȸ��");
		Todo todo3 = new Todo(3L, "�");
		
		Map <Integer, Todo> todoMap = new HashMap<>();
		
		todoMap.put(1, todo1);
		todoMap.put(2, todo2);
		todoMap.put(3, todo3);
		
		return todoMap.get(todoId);
	}
	
	@RequestMapping(value="/todoh", method=RequestMethod.GET)
	public ResponseEntity<TodoResource> geth(@RequestParam(value="todoTitle") String todoTitle){
		TodoResource todoResource = new TodoResource(todoTitle);
		
		todoResource.add(linkTo(methodOn(BasicController.class).geth(todoTitle)).withSelfRel());

		return new ResponseEntity(todoResource, HttpStatus.OK);
	}
}
