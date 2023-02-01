package com.ezen.service;

import java.util.List;

import com.ezen.entity.Recipe;

public interface RecipeService {
	void insertRecipe(Recipe recipe);
	
	//void updateRecipe(Recipe recipe);
	
	void deleteRecipe(Recipe recipe);
	
	//List<Recipe> getRecipeList(Recipe recipe);
}
