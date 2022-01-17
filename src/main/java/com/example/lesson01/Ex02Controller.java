package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // @RestControllet 가 아님의 주의 , 뷰는 @ResponseBody가 없다 
public class Ex02Controller { // 뷰는 @ResponseBody가 없어 무조건 String (경로때문에)
	
	@RequestMapping("/lesson01/ex02/1")
	public String view() {
		// ResponseBody가 아닌 상태로 String을 리턴하면
		// ViewResolver에 의해 리턴된 String의 경로에 해당하는  view를 찾고 view화면이 구성된다.
		
		// prefix,       suffix 가 되어있는부분을 빼고 사용함 
		// /WEB-INF/jsp/  .jsp
		return "lesson01/ex02"; 
	}
}
