package com.example.codealongw3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.lang.reflect.Array;
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
    private ArrayList<String> genre = new ArrayList<>();

    @NotNull
    private String developer;
    @NotNull
    private String publisher;
    @NotNull
    private String releaseDate;

    @NotNull
    @ElementCollection
    private ArrayList<String> languages = new ArrayList<>();

    @NotNull
    private String systemRequirments;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Review review;




    public Game(){

    }




}
