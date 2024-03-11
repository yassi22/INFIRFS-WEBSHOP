package com.example.codealongw3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    public long id;

    @OneToMany(mappedBy = "order")
    @JsonManagedReference
    public List<Game> games;

    public LocalDateTime datum;

    public Order(){

    }


    public Order(List<Game> games){
        this.games = games;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }




}
