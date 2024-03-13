package com.example.codealongw3.dto;
import com.example.codealongw3.models.Game;

import java.time.LocalDateTime;
import java.util.List;
public class OrderDTO {


    public List<Game> games;

    public LocalDateTime datum;

    public OrderDTO(List<Game> games, LocalDateTime datum) {
        this.games = games;
        this.datum = datum;
    }
}
