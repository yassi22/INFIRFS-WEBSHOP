package com.example.codealongw3.utils;

import com.example.codealongw3.dao.GameDao;
import com.example.codealongw3.dao.GameRepository;
import com.example.codealongw3.dao.TaskDao;
import com.example.codealongw3.dao.TaskRepository;
import com.example.codealongw3.models.Category;
import com.example.codealongw3.models.Game;
import com.example.codealongw3.models.Task;
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

@Component
public class Seeder {

    private TaskDao taskDao;

    private GameRepository gameRepository;

    @ElementCollection
    private List<String> genre;

    @ElementCollection
    private List<String> languages;


    public Seeder(TaskDao taskDao, GameRepository gameRepository) {
        this.taskDao = taskDao;
        this.gameRepository = gameRepository;
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

        if (this.genre == null) {
            this.genre = new ArrayList<String>();
        }

        genre.add("Action");
        genre.add("Rpg");
        genre.add("Shooter");

        if (this.languages == null) {
            this.languages = new ArrayList<String>();
        }

        languages.add("English");
        languages.add("Spanish");
        languages.add("Dutch");


        Game game = new Game("Cyberpunk", "Game is set in a cyberpunk world", genre, "Cd project RED", "Cd project RED", "mar 20 2019", languages, 59.99);
//        game.setTitle("Cyberpunk");
//        game.setDescription("This game is set in a cyberpunk word!");
//
//
//        if(this.genre == null) {
//            this.genre = new ArrayList<String>();
//        }
//
//        genre.add("Action");
//        genre.add("Rpg");
//        genre.add("Shooter");
//
//        game.setGenre(genre);
//
//        game.setDeveloper("CD PROJEKT RED");
//        game.setPublisher("CD PROJEKT RED");
//        game.setReleaseDate("20 mar, 2019");
//
//        if(this.languages == null) {
//            this.languages = new ArrayList<String>();
//        }
//
//        languages.add("English");
//        languages.add("Spanish");
//        languages.add("Dutch");
//
//
//        game.setLanguages(languages);
//
//        game.setPrice(59.99);
        this.gameRepository.save(game);

    }

}
