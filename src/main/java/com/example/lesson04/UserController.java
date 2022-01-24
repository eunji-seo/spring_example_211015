package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@RequestMapping("/lesson04/ex01")
@Controller
public class UserController {
	
	@Autowired
	private UserBO userBO;
	
	//http://localhost:8080/lesson04/ex01/add_user_view
	@RequestMapping( path = "/add_user_view", method = RequestMethod.GET) // get방식 으로 요청함(or post 선택 가능)   path = 생략 가능   
	public String addUserView() { // @ResponseBody 없으면 view의 경로를 리턴한다 
		return "lesson04/addUser"; // /WEB-INF/jsp/lesson04/addUser.jsp
	}

	//http://localhost:8080/lesson04/ex01/add_user
	@PostMapping("/add_user") // 하나의 메소드 허용 // form tag 방식 
	public String addUser(
			@RequestParam("name" ) String name, // request 요청 
			@RequestParam("yyyymmdd" ) String yyyymmdd,
			@RequestParam("email" ) String email,
			@RequestParam( value = "introduce"  , required=false) String introduce // 비필수 
			
			) {
		// 쿼리 파라미터들을 받아온다 
		
		
		// DB insert // 1.view 데이터 넘어왔는가
		
		userBO.addUser(name, yyyymmdd,email, introduce );
		
		return "lesson04/afterAddUser";	//결과 view 화면 		
	}
	// http://localhost:8080/lesson04/ex01/get_last_user
		@GetMapping("/get_last_user")
		public String getLastUser(Model model) { // 결과 jsp view에 객체값을 넘겨 준다
			// 마지막(가장 최근)에 추가된 사람 한명 정보 가져오기
			
			User LastUser = userBO.getLastUser();
			model.addAttribute("result", LastUser);
			model.addAttribute("subject", "회원 정보");
			
			return "lesson04/getLastUser";
		}
}
