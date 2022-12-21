package me.sad.recipes.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.sad.recipes.model.Ingredient;
import me.sad.recipes.model.Recipe;
import me.sad.recipes.services.ServiceIngredients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/Ingredient")
@Tag(name = "Ингредиенты", description = "Операции удаления, создания, получения и редактирования ингредиентов ")
public class IngredientController {
    private ServiceIngredients serviceIngredients;

    public IngredientController(ServiceIngredients serviceIngredients) {
        this.serviceIngredients = serviceIngredients;

    }

    @PostMapping
    @Operation(summary = "Операция для создания ингредиента")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        serviceIngredients.addIngredients(ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/{count}")
    @Operation(summary = "Операция для получения ингредиента")
    public ResponseEntity<Ingredient> getIngredient(@RequestParam int count) {
        Ingredient ingredient = serviceIngredients.getIngredients(count);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/{count}")
    @Operation(summary = "Операция для редактирования ингредиента")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable long count, @RequestBody Ingredient ingredient) {
        Map<Long, Ingredient> ingredients = serviceIngredients.editIngredient(count, ingredient);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{count}")
    @Operation(summary = "Операция для удаления ингредиента")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long count) {
        if (serviceIngredients.deleteIngredient(count)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
