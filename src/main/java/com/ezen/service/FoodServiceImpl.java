package com.ezen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dto.FoodDTO;
import com.ezen.entity.Food;
import com.ezen.persistence.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	FoodRepository foodRepo;
	
	@Override
	public void insertFood(FoodDTO foodDTO) {
		foodDTO = FoodDTO.builder()
				.category(foodDTO.getCategory())
				.name(foodDTO.getName())
				.exp(foodDTO.getExp())
				.member(foodDTO.getMember())
				.build();
		
		Food food = foodDTO.toEntity(foodDTO);
		foodRepo.save(food);
	}

	@Override
	public void updateFood(FoodDTO foodDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFood(FoodDTO foodDTO) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void updateFood(Food food) {
//		Food findFood = foodRepo.findById(food.getFood_seq()).get();
//		findFood.setCategory(food.getCategory());
//		findFood.setName(food.getName());
//		findFood.setExp(food.getExp());
//		
//		foodRepo.save(findFood);
//	}
//
//	@Override
//	public void deleteFood(Food food) {
//		foodRepo.deleteById(food.getFood_seq());
//	}

//	@Override
//	public List<Food> getFoodList(Food food) {
//		return (List<Food>) foodRepo.findAll();
//	}

}
