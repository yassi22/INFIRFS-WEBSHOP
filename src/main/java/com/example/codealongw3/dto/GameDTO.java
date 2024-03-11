package com.example.codealongw3.dto;


import com.example.codealongw3.models.Game;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotNull;

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
    private String os;
    private String processor;
    private String memory;
    private String graphics;
    private String sound_card;


    public GameDTO(String title, String description, String developer, String publisher, String releaseDate, double price, int amount, String os, String processor, String memory, String graphics, String sound_card){
        this.title = title;
        this.description = description;
        this.developer = developer;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.price = price;
        this.amount = amount;
        this.os  = os;
        this.processor = processor;
        this.memory = memory;
        this.graphics = graphics;
        this.sound_card = sound_card;
    }




}
