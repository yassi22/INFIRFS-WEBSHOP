package com.example.codealongw3.dto;

import com.example.codealongw3.models.Category;

public class TaskDTO {

    public String name;
    public String description;

    public long categoryId;



    public TaskDTO(String name, String description, long categoryId) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
    }




}
