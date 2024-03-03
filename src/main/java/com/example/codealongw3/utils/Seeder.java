package com.example.codealongw3.utils;

import com.example.codealongw3.dao.GameDao;
import com.example.codealongw3.dao.GameRepository;
import com.example.codealongw3.dao.TaskDao;
import com.example.codealongw3.dao.TaskRepository;
import com.example.codealongw3.models.Category;
import com.example.codealongw3.models.Game;
import com.example.codealongw3.models.Task;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Seeder {

    private TaskDao taskDao;

    private GameRepository gameRepository;

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
        Game game = new Game();
        game.setTitle("Cyberpunk");
        game.setDescription("This game is set in a cyberpunk word!");
        ArrayList<String> genres = new ArrayList<>();
        genres.add("Action");
        genres.add("Rpg");
        genres.add("Schooter");
        game.setGenre(genres);
        game.setDeveloper("CD PROJEKT RED");
        game.setPublisher("CD PROJEKT RED");
        game.setReleaseDate("20 mar, 2019");
        ArrayList<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Spanish");
        languages.add("Dutch");
        game.setLanguages(languages);
        game.setPrice(59.99);
        this.gameRepository.save(game);
    }


}
