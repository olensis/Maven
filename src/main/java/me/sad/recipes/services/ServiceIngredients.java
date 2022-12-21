package me.sad.recipes.services;

import me.sad.recipes.model.Ingredient;

import java.util.Map;

public interface ServiceIngredients {

    void addIngredients(Ingredient ingredient);

    Map<Long, Ingredient> editIngredient(long count, Ingredient ingredient);

    boolean deleteIngredient(long count);

    Ingredient getIngredients(long count);

}
