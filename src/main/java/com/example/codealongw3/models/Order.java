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

    public String orderTitle;

    public double orderPrice;


    public Order(){

    }


    public Order(String orderTitle, double orderPrice,  LocalDateTime datum){
        this.orderTitle = orderTitle;
        this.orderPrice = orderPrice;
        this.datum = datum;
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

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
}
