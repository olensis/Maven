package me.sad.recipes.services.impl;

import me.sad.recipes.model.Recipe;

import java.util.Map;

public interface ServiceRecipe {
    long addRecipei(Recipe recipe);

    Map<Long, Recipe> editRecipe(long count, Recipe recipe);

    boolean deleteRecipe(long count);

    Recipe getRecipe(long count);
}
