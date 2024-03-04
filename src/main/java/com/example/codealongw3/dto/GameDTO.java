package com.example.codealongw3.dto;


import com.example.codealongw3.models.Game;
import jakarta.persistence.ElementCollection;

import java.util.ArrayList;
import java.util.List;

public class GameDTO {
    public String title;
    public String description;
    public List<String> genre;
    public String developer;
    public String publisher;
    public String releaseDate;
    public List<String> languages;
    public double price;


    public GameDTO(String title, String description, List<String> genre, String developer, String publisher, String releaseDate, List<String> languages, double price){
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.developer = developer;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.languages = languages;
        this.price = price;
    }



}
