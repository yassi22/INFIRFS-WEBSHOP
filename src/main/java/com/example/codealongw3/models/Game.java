package com.example.codealongw3.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

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


}
