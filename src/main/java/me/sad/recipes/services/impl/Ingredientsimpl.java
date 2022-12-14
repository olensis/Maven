package me.sad.recipes.services.impl;
import me.sad.recipes.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Service
public class Ingredientsimpl {
    private static Map<Long, Ingredient> ingredients = new HashMap<>();
    private static long count = 0;

    public void addIngredients (Ingredient ingredient){
        Map<Long, Ingredient> addIngridients = ingredients.getOrDefault(count,new LinkedHashMap<>());
        ingredients.put(count++,ingredient);
    }

    public long getIngredients (Long count){
        for (Long : ingredients.keySet()) {

        }
    }

}
