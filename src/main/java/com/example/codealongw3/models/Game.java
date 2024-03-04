package com.example.codealongw3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

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
    @ElementCollection
    private List<String> genre;

    @NotNull
    private String developer;
    @NotNull
    private String publisher;

    private String releaseDate;

    @NotNull
    @ElementCollection
    private List<String> languages;


//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JsonBackReference
//    private Review review;
//
//    @NotNull
//    @OneToOne(cascade = CascadeType.MERGE)
//    @JsonBackReference
//    private GameSystemRequirments gameSystemRequirments;

    @NotNull
    private double price;


    public Game(){

    }

    public Game(String title, String description, List<String> genre, String developer, String publisher, String releaseDate,List<String> languages, double price){
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.developer = developer;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.languages = languages;
        this.price = price;
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

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
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

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
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
//    public void setGameSystemRequirments(GameSystemRequirments gameSystemRequirments) {
//        this.gameSystemRequirments = gameSystemRequirments;
//    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
