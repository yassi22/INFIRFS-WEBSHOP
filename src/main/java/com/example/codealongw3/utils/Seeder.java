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


        Game gameCyberpunk = new Game(
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
        gameCyberpunk.setGenre(genre1);
        gameCyberpunk.setLanguages(Set.of(language1, language2));


        this.genreRepository.save(genre1);


        Game gameGodOfWar = new Game(
                "God of war",
                "Enter the Norse realm\n" + "His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters",
                "https://image.api.playstation.com/vulcan/img/rnd/202010/2217/p3pYq0QxntZQREXRVdAzmn1w.png",
                "Santa monica studio",
                "Playstation PC LLC",
                "14 Jan, 2020",
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

        this.genreRepository.save(genre2);


        Game gameHellDivers2 = new Game(
                "Helldivers2",
                "The Galaxy’s Last Line of Offence.\n" +
                        "\n" +
                        "Enlist in the Helldivers and join the fight for freedom across a hostile galaxy in a fast, frantic, and ferocious third-person shooter.",
                "https://gaming-cdn.com/images/products/9575/616x353/helldivers-2-pc-spel-steam-europe-cover.jpg?v=1708503564",
                "Arrowhead Game Studios",
                "Playstation PC LLC",
                "8 Feb, 2024",
                39.99,
                10,
                "Windows 10 64 bit",
                " Intel Core i7-4790K or AMD Ryzen 5 1500X",
                "8 GB RAM",
                "NVIDIA GeForce GTX 1050 Ti or AMD Radeon RX 470",
                "100% DirectX 10 compatible"
        );

        gameHellDivers2.setGenre(genre1);
        gameHellDivers2.setLanguages(Set.of(language1, language2));

        Game gameStray = new Game(
                "Stray",
                "Lost, alone and separated from family, a stray cat must untangle an ancient mystery to escape a long-forgotten city.",
                "https://image.api.playstation.com/vulcan/ap/rnd/202206/0300/UogbMjgPOJrYBn5QvUmuR7G9.jpg",
                "BlueTwelve Studio",
                "Annapurna Interactive",
                "19 Jul, 2022",
                27.99,
                5,
                "Windows 10 64 bit",
                " Intel Core i5-2300 | AMD FX-6350",
                "8 GB RAM",
                "NVIDIA GeForce GTX 650 Ti, 2 GB | AMD Radeon R7 360, 2 GB",
                "Version 12"
        );

        gameStray.setGenre(genre1);
        gameStray.setLanguages(Set.of(language1, language2));


        Game gameLastOfUs = new Game(
                "The Last of Us™ Part I",
                "Experience the emotional storytelling and unforgettable characters in The Last of Us™, winner of over 200 Game of the Year awards.",
                "https://image.api.playstation.com/vulcan/ap/rnd/202206/0720/0kRqUeSBIbQzz7cen3c989c6.jpg",
                "Naughty Dog LLC, Iron Galaxy Studios",
                "PlayStation PC LLC",
                "28 Mar, 2023",
                59.99,
                6,
                "Windows 10 (Version 1909 or Newer)",
                " AMD Ryzen 5 1500X, Intel Core i7-4770K",
                "16 GB RAM",
                "AMD Radeon RX 470 (4 GB), AMD Radeon RX 6500 XT (4 GB), NVIDIA GeForce GTX 970 (4 GB), NVIDIA GeForce GTX 1050 Ti (4 GB)",
                "Version 12"
        );

        gameLastOfUs.setGenre(genre1);
        gameLastOfUs.setLanguages(Set.of(language1, language2));


        Game gameSpiderman = new Game(
                "Marvel’s Spider-Man Remastered",
                "Developed by Insomniac Games in collaboration with Marvel, and optimized for PC by Nixxes Software, Marvel's Spider-Man Remastered on PC introduces an experienced Peter Parker who’s fighting big crime and iconic villains in Marvel’s New York.",
                "https://image.api.playstation.com/vulcan/ap/rnd/202009/3021/5ayReKkz8RaBVuTvrxgA3rvh.png?w=440",
                " Insomniac Games, Nixxes Software",
                "PlayStation PC LLC",
                "12 Aug, 2022",
                35.99,
                6,
                "Windows 10 64-bit",
                " Intel Core i3-4160, 3.6 GHz or AMD equivalent",
                "8 GB RAM",
                "NVIDIA GTX 950 or AMD Radeon RX 470",
                "Version 12"
        );

        gameSpiderman.setGenre(genre1);
        gameSpiderman.setLanguages(Set.of(language1, language2));


        Game gameRedDead2 = new Game(
                "Red Dead Redemption 2",
                "America, 1899.\n" +
                        "\n" +
                        "Arthur Morgan and the Van der Linde gang are outlaws on the run. With federal agents and the best bounty hunters in the nation massing on their heels, the gang must rob, steal and fight their way across the rugged heartland of America in order to survive.",
                "https://i.ytimg.com/vi/HVRzx17WHVk/maxresdefault.jpg",
                " Rockstar Games",
                "Rockstar Games",
                "5 Dec, 2019",
                59.99,
                6,
                "Windows 10 - April 2018 Update (v1803)",
                " Intel® Core™ i7-4770K / AMD Ryzen 5 1500X",
                "12 GB RAM",
                "Nvidia GeForce GTX 1060 6GB / AMD Radeon RX 480 4GB",
                "Direct X Compatible"
        );

        gameRedDead2.setGenre(genre1);
        gameRedDead2.setLanguages(Set.of(language1, language2));


        Game gameForzaHorizon5 = new Game(
                "Forza Horizon 5",
                "Your Ultimate Horizon Adventure awaits! Explore the vibrant and ever-evolving open world landscapes of Mexico with limitless, fun driving action in hundreds of the world’s greatest cars.",
                "https://store-images.s-microsoft.com/image/apps.33953.13718773309227929.bebdcc0e-1ed5-4778-8732-f4ef65a2f445.9428b75f-2c08-4e70-9f95-281741b15341",
                " Playground Games",
                "Xbox Game Studios",
                "9 Nov, 2021",
                59.99,
                6,
                "Windows 10 version 18362.0 or higher",
                " Intel i5-4460 or AMD Ryzen 3 1200",
                "8 GB RAM",
                "NVidia GTX 970 OR AMD RX 470",
                "Version 12"
        );

        gameForzaHorizon5.setGenre(genre1);
        gameForzaHorizon5.setLanguages(Set.of(language1, language2));


        Game gameEaFc24 = new Game(
                "EA SPORTS FC™ 24",
                "EA SPORTS FC™ 24 welcomes you to The World’s Game: the most true-to-football experience ever with HyperMotionV, PlayStyles optimised by Opta, and an enhanced Frostbite™ Engine.",
                "https://fs-prod-cdn.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_4/2x1_NSwitch_EaSportsFc24_image1600w.jpg",
                "EA Canada & EA Romania",
                "Electronic Arts",
                "29 Sep, 2023",
                13.99,
                6,
                "Windows 10 - 64-Bit",
                "Intel Core i5-6600K @ 3.50GHz or AMD Ryzen 5 1600 @ 3.2 GHZ",
                "8 GB RAM",
                "NVIDIA GeForce GTX 1050 Ti 4GB or AMD Radeon RX 570 4GB",
                "Version 12"
        );

        gameEaFc24.setGenre(genre1);
        gameEaFc24.setLanguages(Set.of(language1, language2));

        Game gameseaOfThieves = new Game(
                "Sea of Thieves: 2024 Edition",
                "Sea of Thieves is a smash-hit pirate adventure game, offering the quintessential pirate experience of plundering lost treasures, intense battles, vanquishing sea monsters and more",
                "https://assets.xboxservices.com/assets/b9/4d/b94db758-13a0-4f5c-8796-b8485f0cfdac.jpg?n=SoT_GLP-Page-Hero-1084_1920x1080_03.jpg",
                "Rare Ltd",
                "Xbox Game Studios",
                "3 Jun, 2020",
                39.99,
                6,
                "Windows 10",
                "Intel Q9450 @ 2.6GHz - AMD Phenom II X6 @ 3.3 GHz",
                "4 GB RAM",
                "Nvidia GeForce GTX 650 - AMD Radeon 7750 - Intel A310",
                "Version 11"
        );

        gameseaOfThieves.setGenre(genre1);
        gameseaOfThieves.setLanguages(Set.of(language1, language2));

        Game gamesonsOfTheForest = new Game(
                "Sons Of The Forest",
                "Sent to find a missing billionaire on a remote island, you find yourself in a cannibal-infested hellscape. Craft, build, and struggle to survive, alone or with friends, in this terrifying new open-world survival horror simulator.",
                "https://i0.wp.com/insider-gaming.com/wp-content/uploads/2023/09/sons-of-the-forest.jpg?fit=1920%2C1080&ssl=1",
                "Endnight Games Ltd",
                "Newnight",
                "22 Feb, 2024",
                28.99,
                6,
                "64-bit Windows 10",
                "INTEL CORE I5-8400 or AMD RYZEN 3 3300X",
                "12 GB RAM",
                "NVIDIA GeForce GTX 1060 3GB or AMD Radeon RX 570 4GB",
                "Version 11"
        );

        gamesonsOfTheForest.setGenre(genre1);
        gamesonsOfTheForest.setLanguages(Set.of(language1, language2));

        Game gameLethalCompany = new Game(
                "Lethal Company",
                "You are a contracted worker for the Company. Your job is to collect scrap from abandoned, industrialized moons to meet the Company's profit quota.",
                "https://cdn.akamai.steamstatic.com/steam/apps/1966720/capsule_616x353.jpg?t=1700231592",
                "Zeekerss",
                "Zeekerss",
                "23 Oct, 2023",
                9.75,
                12,
                "Windows 10",
                "Intel Core i5-7400 CPU @ 3.00GHz",
                "8 GB RAM",
                "NVIDIA GForce GTX 1050",
                "Version 11"
        );

        gameLethalCompany.setGenre(genre1);
        gameLethalCompany.setLanguages(Set.of(language1, language2));





        this.gameRepository.save(gameCyberpunk);
        this.gameRepository.save(gameHellDivers2);
        this.gameRepository.save(gameStray);
        this.gameRepository.save(gameLastOfUs);
        this.gameRepository.save(gameSpiderman);
        this.gameRepository.save(gameRedDead2);
        this.gameRepository.save(gameForzaHorizon5);
        this.gameRepository.save(gameEaFc24);
        this.gameRepository.save(gameseaOfThieves);
        this.gameRepository.save(gamesonsOfTheForest);
        this.gameRepository.save(gameLethalCompany);
        this.gameRepository.save(gameGodOfWar);


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
