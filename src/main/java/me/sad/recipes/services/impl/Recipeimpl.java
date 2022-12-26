package me.sad.recipes.services.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.sad.recipes.model.Recipe;
import me.sad.recipes.services.FileServiceReceipe;
import me.sad.recipes.services.ReceipeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Recipeimpl implements ReceipeService {
    private final FileServiceReceipe fileServiceReceipe;
    private static Map<Long, Recipe> recipes = new HashMap<>();
    private static long count = 0;


    public Recipeimpl( FileServiceReceipe fileServiceReceipe) {
        this.fileServiceReceipe = fileServiceReceipe;
    }

    @Override
    public void addRecipei(Recipe recipe) {
        recipes.put(count++, recipe);
        saveToFile();
    }
    @Override
    public Map<Long, Recipe> editRecipe(Long count, Recipe recipe){
        for (Recipe recipeEdit: recipes.values()) {
            if (recipes.containsKey(count)){
                recipes.put(count,recipe);
                saveToFile();
                return recipes;
            }
        }
        return null;
    }
//    @PostConstruct
//    private void init(){
//        readFromFile();
//    }
    @Override
    public boolean deleteRecipe(Long count) {
        for (Recipe recipeDelete : recipes.values()) {
            if (recipes.containsKey(count)) {
               recipes.remove(count);
                return true;
            }
        }
        return false;
    }

    @Override
    public Recipe getRecipe(Long count) {
        return recipes.get(count);
    }
    private void saveToFile (){
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            fileServiceReceipe.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
    private void readFromFile (){
       String json = fileServiceReceipe.readFromFile();
        try {
           recipes = new ObjectMapper().readValue(json, new TypeReference<HashMap<Long,Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
