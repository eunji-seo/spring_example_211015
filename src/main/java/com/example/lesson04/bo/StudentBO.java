package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.StudentDAO;
import com.example.lesson04.model.Student;

@Service
public class StudentBO {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public void addStudent(Student student) { // insert는 return 받을 필요 없음
		studentDAO.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentDAO.selectStudentById(id);
	}
	
}
