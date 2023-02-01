package com.ezen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.dto.FoodDTO;
import com.ezen.dto.MemberDTO;
import com.ezen.service.FoodService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FoodController {
	@Autowired
	private FoodService foodService;
	
	@GetMapping("/food/insertFood")
	public String insertFoodView() {
		return "food/insertFood";
	}
	
	@PostMapping("/food/insertFood")
	public String insertFood(FoodDTO food, HttpSession session) {
		
		MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "food/foodList";
		} else {
			food.setMember(loginUser);
			foodService.insertFood(food);
			return "food/foodList";
		}
	}
	
	@RequestMapping("/food/foodList")
	public String foodList() {
		return "food/foodList";
	}
	
	@RequestMapping("/food/updateFood")
	public String updateFood() {
		return "food/updateFood";
	}
	
	@RequestMapping("/food/category")
	public String category() {
		return "food/category";
	}
}
