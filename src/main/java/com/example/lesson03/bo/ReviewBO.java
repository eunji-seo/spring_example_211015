package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {

	@Autowired
	private ReviewDAO reviewDAO; 
	
	public Review getReview(int id1) {
		return reviewDAO.selectReview(id1);
	}
	
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	}
}
