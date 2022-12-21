package me.sad.recipes.services.impl;
import me.sad.recipes.model.Ingredient;
import me.sad.recipes.services.ServiceIngredients;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Ingredientsimpl implements ServiceIngredients {
    private static Map<Long, Ingredient> ingredients = new HashMap<>();
    private static long count = 0;


    @Override
    public void addIngredients(Ingredient ingredient) {
        ingredients.put(count++, ingredient);
    }
    @Override
    public Map<Long, Ingredient> editIngredient(long count, Ingredient ingredient){
        for (Ingredient ingredientEdit: ingredients.values()) {
            if (ingredients.containsKey(count)){
                ingredients.put(count,ingredient);
                return ingredients;
            }
        }
        return null;
    }
    @Override
    public boolean deleteIngredient(long count) {
         for (Ingredient ingredientDelete : ingredients.values()) {
            if (ingredients.containsKey(count)) {
                ingredients.remove(count);
                return true;
            }
        }
        return false;
    }

    @Override
    public Ingredient getIngredients(long count) {
        return ingredients.get(count);
    }

}


