package com.example.codealongw3.controller;


import com.example.codealongw3.dao.GameDao;
import com.example.codealongw3.dto.GameDTO;
import com.example.codealongw3.models.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameDao gameDao;

    public GameController(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameDao.getAllGames());
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateGame(@PathVariable Long id, @RequestBody GameDTO gameDTO) {
        this.gameDao.updateGame(gameDTO, id);
        return ResponseEntity.ok("Game product is updated" + id);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        try {
            Game game = this.gameDao.getGame(id);
            return ResponseEntity.ok(game);
        } catch (ResponseStatusException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping
    public ResponseEntity<String> createGame(@RequestBody GameDTO gameDTO) {
        try {
            this.gameDao.createGame(gameDTO);
            return ResponseEntity.ok("Created a game");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        this.gameDao.deleteGameById(id);
        return ResponseEntity.ok("Task is deleted");

    }


}
