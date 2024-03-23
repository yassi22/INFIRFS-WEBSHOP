package com.example.codealongw3.utils;

import com.example.codealongw3.controller.AuthController;
import com.example.codealongw3.dao.*;
import com.example.codealongw3.dto.AuthenticationDTO;
import com.example.codealongw3.dto.OrderDTO;
import com.example.codealongw3.dto.UserDTO;
import com.example.codealongw3.models.*;
import jakarta.persistence.ElementCollection;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class Seeder {


    private GameRepository gameRepository;

    private GenreRepository genreRepository;

    private LanguageRepository languageRepository;

    private OrderRepository orderRepository;

    private OrderDao orderDao;

    private  UserDao userDao;

    private AuthController authController;


    private Game hellDivers2 = new Game(
            "Hell Divers",
            "A game about killing bugs",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.instant-gaming.com%2Fnl%2F9575-betaling-helldivers-2-pc-spel-steam-europe%2F&psig=AOvVaw3pp24Smey-MQ7aOo94xiOg&ust=1710961860664000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCLCIjeGDgYUDFQAAAAAdAAAAABAJ",
            "Arrowhead Game Studios",
            "PlayStation PC LLC",
            "8 Feb, 2024",
            49.99,
            4,
            "Windows 10 64 bit",
            "Intel Core 2 Quad CPU Q6600 @ 2.40GHz",
            "4 GB RAM",
            "NVIDIA 9800 GT 1GB",
            "100% DirectX 10 compatible");


    public Seeder( GameRepository gameRepository, GenreRepository genreRepository, LanguageRepository languageRepository, OrderRepository orderRepository, OrderDao orderDao, UserDao userDao, AuthController authController) {
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
        this.languageRepository = languageRepository;
        this.orderRepository = orderRepository;
        this.orderDao = orderDao;
        this.userDao = userDao;
        this.authController = authController;
    }


    @EventListener
    public void seed(ContextRefreshedEvent event) {
        this.seedGames();
        this.seedUsers();
        this.seedOrders();
    }




    private void seedGames() {

        Language language1 = new Language("English");
        Language language2 = new Language("Dutch");

        this.languageRepository.save(language1);
        this.languageRepository.save(language2);


        Game game = new Game(
                "Cyberpunk",
                "Game is set in a cyberpunk world",
                "https://image.api.playstation.com/vulcan/ap/rnd/202311/2812/ae84720b553c4ce943e9c342621b60f198beda0dbf533e21.jpg",
                "Cd project RED",
                "Cd project RED",
                "mar 20 2019",
                59.99,
                3,
                "Windows 10 64 bit",
                "Intel Core 2 Quad CPU Q6600 @ 2.40GHz",
                "4 GB RAM",
                "NVIDIA 9800 GT 1GB",
                "100% DirectX 10 compatible"
        );

        Genre genre1 = new Genre("Shooter");
        game.setGenre(genre1);
        game.setLanguages(Set.of(language1, language2));


        this.genreRepository.save(genre1);


        Game gameGodOfWar = new Game(
                "God of war",
                "Enter the Norse realm\n" + "His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters",
                "https://cdn.akamai.steamstatic.com/steam/apps/1593500/capsule_616x353.jpg?t=1695758729",
                "Santa monica studio",
                "Playstation PC LLC",
                "14 Jan, 2002",
                49.99,
                3,
                "Windows 10 64 bit",
                "Intel Core 2 Quad CPU Q6600 @ 2.40GHz",
                "4 GB RAM",
                "NVIDIA 9800 GT 1GB",
                "100% DirectX 10 compatible"
        );

        Genre genre2 = new Genre("Action");
        gameGodOfWar.setGenre(genre2);

        gameGodOfWar.setLanguages(Set.of(language1, language2));


        Game stray = new Game(
                "Stray",
                "Enter the Norse realm\n" + "His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters",
                "https://image.api.playstation.com/vulcan/ap/rnd/202206/0300/UogbMjgPOJrYBn5QvUmuR7G9.jpg",
                "Santa monica studio",
                "Playstation PC LLC",
                "14 Jan, 2002",
                49.99,
                3,
                "Windows 10 64 bit",
                "Intel Core 2 Quad CPU Q6600 @ 2.40GHz",
                "4 GB RAM",
                "NVIDIA 9800 GT 1GB",
                "100% DirectX 10 compatible"
        );

        stray.setGenre(genre2);

        stray.setLanguages(Set.of(language1, language2));





        this.genreRepository.save(genre2);


        this.gameRepository.save(game);
        this.gameRepository.save(gameGodOfWar);
        this.gameRepository.save(stray);


    }

    public void seedUsers(){

        AuthenticationDTO authenticationDTO = new AuthenticationDTO("test@mail.com","V!vU7%3_4R3>", "piet", null, "Jong", "Vliegweg",4,"2324KL");
        authController.register(authenticationDTO);
        userDao.makeUserAdmin(1L);

    }

    public void seedOrders() {
        OrderDTO orderDTO = new OrderDTO(List.of(1L,2L),"test@mail.com");
        orderDao.createOrder(orderDTO);

    }




}
