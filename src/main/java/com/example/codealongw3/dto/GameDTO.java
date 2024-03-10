package com.example.codealongw3.dto;


import com.example.codealongw3.models.Game;
import jakarta.persistence.ElementCollection;

import java.util.ArrayList;
import java.util.List;

public class GameDTO {
    public String title;
    public String description;
    public String developer;
    public String publisher;
    public String releaseDate;

    public double price;
    public int amount;

    public GameDTO(String title, String description, String developer, String publisher, String releaseDate, double price, int amount){
        this.title = title;
        this.description = description;
        this.developer = developer;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.price = price;
        this.amount = amount;
    }



}
