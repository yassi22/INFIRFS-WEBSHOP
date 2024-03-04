package com.example.codealongw3.dao;

import com.example.codealongw3.dto.GameDTO;
import com.example.codealongw3.models.Game;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class GameDao {

    private final GameRepository gameRepository;

    public GameDao(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return this.gameRepository.findAll();
    }


    public void updateGame(GameDTO gameDTO, Long id){
        Optional<Game> game = this.gameRepository.findById(id);

        if(game.isPresent()){

            game.get().setTitle(gameDTO.title);
            game.get().setDescription(gameDTO.description);
            game.get().setGenre(gameDTO.genre);
            game.get().setDeveloper(gameDTO.developer);
            game.get().setPublisher(gameDTO.publisher);
            game.get().setReleaseDate(gameDTO.releaseDate);
            game.get().setLanguages(gameDTO.languages);
            game.get().setPrice(gameDTO.price);

            this.gameRepository.save(game.get());

        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foutmelding Game product met dat id bestaat niet");
        }

    }

    @Transactional
    public void createGame(GameDTO gameDTO) {

        Game game = new Game(gameDTO.title, gameDTO.description, gameDTO.genre, gameDTO.developer, gameDTO.releaseDate, gameDTO.publisher, gameDTO.languages, gameDTO.price);
        this.gameRepository.save(game);
    }

    public void deleteGameById(Long id){
        this.gameRepository.deleteById(id);
    }

}
