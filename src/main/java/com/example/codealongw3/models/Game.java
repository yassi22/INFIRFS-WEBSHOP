package com.example.codealongw3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String title;
    @NotNull
    private String description;

    @NotNull
    @Column(length = 1024)
    private String imageurl;

    @NotNull
    private String developer;
    @NotNull
    private String publisher;

    private String releaseDate;

    @ManyToMany
    @JsonBackReference
    private Set<Language> languages;

    @ManyToOne
    @JsonBackReference
    private Genre genre;

    @ManyToMany(mappedBy = "games")
    @JsonBackReference
    public List<Order> orders;

    @NotNull
    private double price;

    @NotNull
    private int amount;

    @NotNull
    private String os;

    @NotNull
    private String processor;

    @NotNull
    private String memory;

    @NotNull
    private String graphics;

    @NotNull
    private String sound_card;


    public Game(){

    }

    public Game(String title, String description, String imageurl, String developer, String publisher, String releaseDate, double price, int amount, String os, String processor, String memory, String graphics, String sound_card){
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

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getSound_card() {
        return sound_card;
    }

    public void setSound_card(String sound_card) {
        this.sound_card = sound_card;
    }
}
