package me.sad.recipes.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
@AllArgsConstructor
@Data
public class Recipe {
    private String title;
    private int cookingTime;
    ArrayList <Ingredient> ingredients;
    ArrayList <String> cookingSteps;



}
