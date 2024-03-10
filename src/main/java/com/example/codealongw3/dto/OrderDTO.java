package com.example.codealongw3.dto;
import com.example.codealongw3.models.Game;

import java.util.List;
public class OrderDTO {


    public List<Game> games;

    public OrderDTO(List<Game> games){
        this.games = games;
    }


}
