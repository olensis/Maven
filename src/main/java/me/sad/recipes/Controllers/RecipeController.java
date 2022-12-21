package me.sad.recipes.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.sad.recipes.model.Recipe;
import me.sad.recipes.services.impl.ServiceRecipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Recipei")
@Tag(name = "Рецепты", description = "Операции удаления, создания, получения и редактирования рецептов ")
public class RecipeController {
    private ServiceRecipe serviceRecipe;

    public RecipeController(ServiceRecipe serviceRecipe) {
        this.serviceRecipe = serviceRecipe;
    }

    @PostMapping
    @Operation(summary = "Операция для создания рецепта")
    public ResponseEntity <Recipe> createRecipe(@RequestBody Recipe recipe) {
        serviceRecipe.addRecipei(recipe);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/{count}")
    @Operation(summary = "Операция для получения рецепта")
    public ResponseEntity <Recipe> getRecipe(@RequestParam int count) {
        Recipe recipe = serviceRecipe.getRecipe(count);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/{count}")
    @Operation(summary = "Операция для редактирования рецепта")
    public ResponseEntity <Recipe> editRecipe (@PathVariable long count ,@RequestBody Recipe recipe){
       Map<Long, Recipe> recipes = serviceRecipe.editRecipe(count,recipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
    @DeleteMapping("/{count}")
    @Operation(summary = "Операция для удаления рецепта")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long count) {
        if (serviceRecipe.deleteRecipe(count)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
