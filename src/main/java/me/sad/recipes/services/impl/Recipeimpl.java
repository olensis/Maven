package me.sad.recipes.services.impl;
import me.sad.recipes.model.Recipe;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Stream;

@Service
public class Recipeimpl implements Service {
    private static Map<Long, Recipe> recipes = new HashMap<>();
    private static long count = 0;

    public void addRecipei(Recipe recipe) {
        recipes.put(count++, recipe);
    }

    public Recipe getRecipe(long count) {
        return recipes.get(count);
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
