package me.sad.recipes.services.impl;
import me.sad.recipes.model.Recipe;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Recipeimpl implements ServiceRecipe {
    private static final Map<Long, Recipe> recipes = new HashMap<>();
    private static long count = 0;

    @Override
    public long addRecipei(Recipe recipe) {
        recipes.put(count, recipe);
        return count++;
    }
    @Override
    public Map<Long, Recipe> editRecipe(long count, Recipe recipe){
        for (Recipe recipeEdit: recipes.values()) {
            if (recipes.containsKey(count)){
                recipes.put(count,recipe);
                return recipes;
            }
        }
        return null;
    }
    @Override
    public boolean deleteRecipe(long count) {
        for (Recipe recipeDelete : recipes.values()) {
            if (recipes.containsKey(count)) {
               recipes.remove(count);
                return true;
            }
        }
        return false;
    }

    @Override
    public Recipe getRecipe(long count) {
        return recipes.get(count);
    }

}
