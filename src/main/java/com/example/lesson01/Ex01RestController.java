package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody // api를 만들떄 / 스프링 빈 
public class Ex01RestController { // Spring Bean
	
	// http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String pringtString() {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	// http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> printMap(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "zzz");
		map.put("bbb", "qqq");
		map.put("ccc", "lll");
		return map;
	}
	
	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data(); // 일반 자바 bean 
		data.setId(1);
		data.setName("심보람");
		
		return data; // 일반 bean 객체도 json으로 내려간다
	}
	// http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> printEntity(){
		Data data = new Data();
		data.setId(2);
		data.setName("신바다");
		//return new ResponseEntity<>(data, HttpStatus.OK ); // 원하는 상태의 값을 설정할수 있음 
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // Error는 아니지만 500 Error로 미리 내린다 (에러처리 및 정의을 디테일하게 할때) 
	}
	
}	
