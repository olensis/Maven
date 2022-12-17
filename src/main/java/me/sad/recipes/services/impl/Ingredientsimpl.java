package me.sad.recipes.services.impl;
import me.sad.recipes.model.Ingredient;
import me.sad.recipes.services.ServiceIngredients;
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
    public Ingredient getIngredients(long count) {
        return ingredients.get(count);
    }

}


