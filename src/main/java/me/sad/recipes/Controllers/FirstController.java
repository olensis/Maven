package me.sad.recipes.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String HelloWord(){
        return "Привет, это приложение с рецептами";
    }
    @GetMapping("/info")
    public String Info(@RequestParam String name, String nameProject, Integer dateOfCreation, String  description ) {
        return "Привет, меня зовут: " + name + " название проекта " + nameProject + " дата создания " + dateOfCreation + " описание " + description;
    }

}
