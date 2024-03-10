package com.example.codealongw3.utils;

import com.example.codealongw3.dao.*;
import com.example.codealongw3.models.*;
import jakarta.persistence.ElementCollection;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class Seeder {

    private TaskDao taskDao;

    private GameRepository gameRepository;

    private GenreRepository genreRepository;

    private LanguageRepository languageRepository;


    @ElementCollection
    private List<String> languages;


    public Seeder(TaskDao taskDao, GameRepository gameRepository, GenreRepository genreRepository, LanguageRepository languageRepository) {
        this.taskDao = taskDao;
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
        this.languageRepository = languageRepository;
    }



    @EventListener
    public void seed(ContextRefreshedEvent event) {
        this.seedTasks();
        this.seedGames();
    }

    private void seedTasks() {
        Category category = new Category("Study tasks");
        Task task1 = new Task("Angular video bekijken", "Week 1 video bekijken", category);
        Task task2 = new Task("Springboot vidoe bekijken", "Week 2 video bekijken", category);
        this.taskDao.createTask(task1);
        this.taskDao.createTask(task2);

    }

    private void seedGames() {

        Language language1 = new Language("English");
        Language language2 = new Language("Dutch");

        this.languageRepository.save(language1);
        this.languageRepository.save(language2);


        Game game = new Game(
                "Cyberpunk",
                "Game is set in a cyberpunk world",
                "Cd project RED",
                "Cd project RED",
                "mar 20 2019",
                59.99,
                3
        );

        Genre genre1 = new Genre("Shooter");
        game.setGenre(genre1);
        game.setLanguages(Set.of(language1,language2));


        this.genreRepository.save(genre1);



        Game gameGodOfWar = new Game(
                "God of war",
                "Enter the Norse realm\n" +
                "His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters",
                "Santa monica studio",
                "Playstation PC LLC",
                "14 Jan, 2002",
                49.99,
                3
        );

        Genre genre2 = new Genre("Action");
        gameGodOfWar.setGenre(genre2);

        gameGodOfWar.setLanguages(Set.of(language1,language2));
        
        this.genreRepository.save(genre2);


        this.gameRepository.save(game);
        this.gameRepository.save(gameGodOfWar);


    }

}
