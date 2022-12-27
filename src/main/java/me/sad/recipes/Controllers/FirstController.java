

package me.sad.recipes.Controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "Общая информация")

public class FirstController {


    @GetMapping
    @Operation(summary = "Метод приветсвия")
    public String helloWord(){
        return "Привет, это приложение с рецептами";
    }

    @GetMapping("/info")
    @Operation(summary = "Общая информация о приложении")
    public String Info(@RequestParam String name, @RequestParam String nameProject,@RequestParam Integer dateOfCreation,@RequestParam String  description ) {

        return "Привет, меня зовут: " + name + " название проекта " + nameProject + " дата создания " + dateOfCreation + " описание " + description;
    }

}
