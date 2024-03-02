package com.example.codealongw3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
public class Task {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String naam;

    @NotNull
    private String description;
    private boolean isFinsihed = false;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Category category;

    public Task() {

    }

    public Task(String naam, String description, Category category) {
        this.naam = naam;
        this.description = description;
        this.category = category;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinsihed() {
        return isFinsihed;
    } // finished

    public void setFinsihed(boolean finsihed) {
        isFinsihed = finsihed;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

