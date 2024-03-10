package com.example.codealongw3.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;


    @OneToMany(mappedBy = "genre")
    @JsonManagedReference
    private Set<Game> games;



    public Genre(){

    }

    public Genre(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> game) {
        this.games = game;
    }
}
