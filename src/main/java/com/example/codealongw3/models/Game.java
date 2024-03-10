package com.example.codealongw3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


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

    @ManyToOne
    @JsonBackReference
    private Order order;


    @NotNull
    private double price;

    @NotNull
    private int amount;


    public Game(){

    }

    public Game(String title, String description, String developer, String publisher, String releaseDate, double price, int amount){
        this.title = title;
        this.description = description;
        this.developer = developer;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.price = price;
        this.amount = amount;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //    public Review getReview() {
//        return review;
//    }
//
//    public void setReview(Review review) {
//        this.review = review;
//    }
//
//    public GameSystemRequirments getGameSystemRequirments() {
//        return gameSystemRequirments;
//    }
//
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
