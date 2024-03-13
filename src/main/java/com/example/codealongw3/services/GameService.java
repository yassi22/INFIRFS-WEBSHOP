package com.example.codealongw3.services;

import com.example.codealongw3.models.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    public double calculatePrice(List<Game> games) {
        double total = 0.0;
        for (Game game : games) {
            total += game.getPrice();
        }
        return total;
    }

    public String makeTitle(List<Game> games){
        List<String> titles = new ArrayList<>();
        for(Game game : games){
            titles.add(game.getTitle());
        }

        return String.join(" , ",titles);
    }


}
