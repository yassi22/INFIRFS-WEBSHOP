package com.example.codealongw3.controller;


import com.example.codealongw3.dao.GameDao;
import com.example.codealongw3.dto.GameDTO;
import com.example.codealongw3.models.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameDao gameDao;

    public GameController(GameDao gameDao){
        this.gameDao = gameDao;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        return ResponseEntity.ok(gameDao.getAllGames());
    }

    @PostMapping
    public ResponseEntity<String> createGame(@RequestBody GameDTO gameDTO){
        try {
            this.gameDao.createGame(gameDTO);
            return ResponseEntity.ok("Created a game");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }



}
