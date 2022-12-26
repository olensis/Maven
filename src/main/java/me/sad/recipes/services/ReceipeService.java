package me.sad.recipes.services;

import me.sad.recipes.model.Recipe;

import java.util.Map;

public interface ReceipeService {
    void addRecipei(Recipe recipe);

    Map<Long, Recipe> editRecipe(Long count, Recipe recipe);


    boolean deleteRecipe(Long count);

    Recipe getRecipe(Long count);
}
