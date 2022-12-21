package me.sad.recipes.Controllers;

import me.sad.recipes.model.Ingredient;
import me.sad.recipes.model.Recipe;
import me.sad.recipes.services.ServiceIngredients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/Ingredient")
public class IngredientController {
    private ServiceIngredients serviceIngredients;

    public IngredientController(ServiceIngredients serviceIngredients) {
        this.serviceIngredients = serviceIngredients;

    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        serviceIngredients.addIngredients(ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/{count}")
    public ResponseEntity<Ingredient> getIngredient(@RequestParam int count) {
        Ingredient ingredient = serviceIngredients.getIngredients(count);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/{count}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable long count, @RequestBody Ingredient ingredient) {
        Map<Long, Ingredient> ingredients = serviceIngredients.editIngredient(count, ingredient);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{count}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long count) {
        if (serviceIngredients.deleteIngredient(count)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
