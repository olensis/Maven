package me.sad.recipes.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.sad.recipes.model.Ingredient;
import me.sad.recipes.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/Ingredient")
@Tag(name = "Ингредиенты", description = "Операции удаления, создания, получения и редактирования ингредиентов ")
public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;

    }

    @PostMapping
    @Operation(summary = "Операция для создания ингредиента")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredients(ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/{count}")
    @Operation(summary = "Операция для получения ингредиента")
    public ResponseEntity<Ingredient> getIngredient(@RequestParam Long count) {
        Ingredient ingredient = ingredientService.getIngredients(count);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/{count}")
    @Operation(summary = "Операция для редактирования ингредиента")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable Long count, @RequestBody Ingredient ingredient) {
        Map<Long, Ingredient> ingredients = ingredientService.editIngredient(count, ingredient);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{count}")
    @Operation(summary = "Операция для удаления ингредиента")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long count) {
        if (ingredientService.deleteIngredient(count)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
