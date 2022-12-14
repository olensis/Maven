package me.sad.recipes.services.impl;

import me.sad.recipes.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Recipeimpl {
   private static Map <Long, Recipe> recipes = new HashMap<>();
   private static long count = 0;

   public void addRecipe (Recipe recipe){
       recipes.get(recipe);
       recipes.put(count++,recipe);
   }

}
