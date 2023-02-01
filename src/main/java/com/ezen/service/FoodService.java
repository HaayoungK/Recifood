package com.ezen.service;

import com.ezen.dto.FoodDTO;
import com.ezen.entity.Food;

public interface FoodService {
	void insertFood(FoodDTO foodDTO);
	
	void updateFood(FoodDTO foodDTO);
	
	void deleteFood(FoodDTO foodDTO);
	
	//List<Food> getFoodList(Food food);
}
