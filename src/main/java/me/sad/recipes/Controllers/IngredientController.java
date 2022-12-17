package me.sad.recipes.Controllers;
import me.sad.recipes.model.Ingredient;
import me.sad.recipes.services.ServiceIngredients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {
    private ServiceIngredients serviceIngredients;

    public IngredientController(ServiceIngredients serviceIngredients) {
        this.serviceIngredients = serviceIngredients;

    }
    @PostMapping()
    public ResponseEntity createIngredient(@RequestBody Ingredient ingredient) {
        serviceIngredients.addIngredients(ingredient);
        return ResponseEntity.ok(ingredient);
    }
    @GetMapping("get")
    public ResponseEntity getIngredient(@RequestParam int count) {
        Ingredient ingredient = serviceIngredients.getIngredients(count);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
}
