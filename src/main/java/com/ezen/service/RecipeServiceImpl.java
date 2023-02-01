package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.entity.Recipe;
import com.ezen.persistence.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepo;
	
	@Override
	public void insertRecipe(Recipe recipe) {
		recipeRepo.save(recipe);
	}

//	@Override
//	public void updateRecipe(Recipe recipe) {
//		Recipe findRecipe = recipeRepo.findById(recipe.getRecipe_seq()).get();
//		findRecipe.setRecipe_name(recipe.getRecipe_name());
//		findRecipe.setDegree(recipe.getDegree());
//		findRecipe.setCooking_time(recipe.getCooking_time());
//		findRecipe.setName(recipe.getName());
//		findRecipe.setImage(recipe.getImage());
//		findRecipe.setAmount(recipe.getAmount());
//		findRecipe.setKind(recipe.getKind());
//		
//		recipeRepo.save(findRecipe);
//	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		recipeRepo.deleteById(recipe.getRecipe_seq());
	}

//	@Override
//	public List<Recipe> getRecipeList(Recipe recipe) {
//		return (List<Recipe>) recipeRepo.findAll();
//	}

}
