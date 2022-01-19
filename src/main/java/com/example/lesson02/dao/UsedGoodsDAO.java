package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

@Repository // Spring bean 을 가져옴 
public interface UsedGoodsDAO { // null 이라고 나오면 어노테이션 누락 확인 
	
	public List<UsedGoods> selectUsedGoodsList();

}
