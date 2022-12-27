package me.sad.recipes.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Recipe  {
    private String title;
    private int cookingTime;
    ArrayList <Ingredient> ingredients;
    ArrayList <String> cookingSteps;
}
