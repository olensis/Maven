package me.sad.recipes.services;

import me.sad.recipes.model.Ingredient;

public interface ServiceIngredients {

    void addIngredients(Ingredient ingredient);

    Ingredient getIngredients(long count);

}
