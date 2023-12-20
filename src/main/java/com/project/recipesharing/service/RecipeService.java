package com.project.recipesharing.service;

import com.project.recipesharing.exception.RecipeNotFoundException;
import com.project.recipesharing.model.Recipe;
import com.project.recipesharing.repo.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe findRecipeById(Integer id) {
        return recipeRepository.findRecipeById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe by id " + id + " was not found"));
    }

    public void deleteRecipe(Integer id){
        recipeRepository.deleteById(id);
    }
}
