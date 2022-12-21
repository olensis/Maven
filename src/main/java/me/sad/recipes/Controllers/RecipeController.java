package me.sad.recipes.Controllers;

import me.sad.recipes.model.Recipe;
import me.sad.recipes.services.impl.ServiceRecipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Recipei")
public class RecipeController {
    private ServiceRecipe serviceRecipe;

    public RecipeController(ServiceRecipe serviceRecipe) {
        this.serviceRecipe = serviceRecipe;
    }

    @PostMapping
    public ResponseEntity <Recipe> createRecipe(@RequestBody Recipe recipe) {
        serviceRecipe.addRecipei(recipe);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/{count}")
    public ResponseEntity <Recipe> getRecipe(@RequestParam int count) {
        Recipe recipe = serviceRecipe.getRecipe(count);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/{count}")
    public ResponseEntity <Recipe> editRecipe (@PathVariable long count ,@RequestBody Recipe recipe){
       Map<Long, Recipe> recipes = serviceRecipe.editRecipe(count,recipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
    @DeleteMapping("/{count}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long count) {
        if (serviceRecipe.deleteRecipe(count)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
