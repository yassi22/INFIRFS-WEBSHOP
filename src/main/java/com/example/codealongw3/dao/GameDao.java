package com.example.codealongw3.dao;

import com.example.codealongw3.dto.GameDTO;
import com.example.codealongw3.models.Game;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class GameDao {

    private final GameRepository gameRepository;

    public GameDao(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return this.gameRepository.findAll();
    }

    public void createGame(GameDTO gameDTO) {
        Game game = new Game(gameDTO.title, gameDTO.description, gameDTO.genre, gameDTO.developer, gameDTO.releaseDate, gameDTO.publisher, gameDTO.languages, gameDTO.price);
        this.gameRepository.save(game);
    }


}
