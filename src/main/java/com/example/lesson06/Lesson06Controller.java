package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
public class Lesson06Controller {
	
	@Autowired
	private UserBO userBO;

	//유저 추가 화면
	//http://localhost:8080/lesson06/add_user_view
	@RequestMapping("/lesson06/add_user_view")
	public String addUserView() {
		return "lesson06/addNewUser";
	}
	
	// 유처 추가 (view(x) 스트링만받음 )
	@PostMapping("/lesson06/add_user")
	@ResponseBody // 기능을 수행후 결과나올때(json)
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce
			) { // RequestParams
		// insert db
			userBO.addUser(name, yyyymmdd, email, introduce);
		// return String 
		return "성공!!!";
	}
	
}
