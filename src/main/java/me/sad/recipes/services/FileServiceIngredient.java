package me.sad.recipes.services;

public interface FileServiceIngredient {
    boolean saveToFile(String json);

    String readFromFile();
}
