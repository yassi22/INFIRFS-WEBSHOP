package com.example.codealongw3.dto;


import com.example.codealongw3.models.Game;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotNull;



public class GameDTO {
    public String title;
    public String description;

    public String imageurl;
    public String developer;
    public String publisher;
    public String releaseDate;
    public double price;
    public int amount;
    public String os;
    public String processor;
    public String memory;
    public String graphics;
    public String sound_card;


    public GameDTO(String title, String description,String imageurl, String developer, String publisher, String releaseDate, double price, int amount, String os, String processor, String memory, String graphics, String sound_card){
        this.title = title;
        this.description = description;
        this.imageurl = imageurl;
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
