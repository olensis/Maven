package me.sad.recipes.services;

import me.sad.recipes.model.Ingredient;

import java.util.Map;

public interface IngredientService {

    void addIngredients(Ingredient ingredient);

    Map<Long, Ingredient> editIngredient(Long count, Ingredient ingredient);

    boolean deleteIngredient(Long count);

    Ingredient getIngredients(Long count);
}
