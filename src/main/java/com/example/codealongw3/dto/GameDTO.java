package com.example.codealongw3.dto;


import com.example.codealongw3.models.Game;

import java.util.ArrayList;

public class GameDTO {
    public String title;
    public String description;
    public  ArrayList<String> genre;
    public String developer;
    public String publisher;
    public String releaseDate;
    public ArrayList<String> languages;
    public double price;


    public GameDTO(String title, String description,ArrayList<String> genre, String developer, String publisher, String releaseDate, ArrayList<String> languages, double price){
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
