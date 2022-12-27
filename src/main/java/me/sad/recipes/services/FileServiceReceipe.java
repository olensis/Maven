package me.sad.recipes.services;

public interface FileServiceReceipe {

    boolean saveToFile(String json);

    String readFromFile();

}
