package me.sad.recipes.Controllers;

import me.sad.recipes.model.Recipe;
import me.sad.recipes.services.Service;
import me.sad.recipes.services.ServiceIngredients;
import me.sad.recipes.services.impl.Recipeimpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Recipei")
public class RecipeController {
    private Recipeimpl recipeimpl;

    public RecipeController(Recipeimpl recipeimpl) {
        this.recipeimpl = recipeimpl;
    }

    @PostMapping
    public ResponseEntity createRecipe(@RequestBody Recipe recipe) {
        recipeimpl.addRecipei(recipe);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping()
    public ResponseEntity getRecipe(@RequestParam int count) {
        Recipe recipe = recipeimpl.getRecipe(count);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
}
