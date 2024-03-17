package com.example.codealongw3.dao;


import com.example.codealongw3.dto.OrderDTO;
import com.example.codealongw3.models.Game;
import com.example.codealongw3.models.Order;
import com.example.codealongw3.services.GameService;
import com.example.codealongw3.services.UserService;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class OrderDao {
    private final OrderRepository orderRepository;
    private final GameDao gameDao;
    private final GameService gameService;

    private final UserRepository  userRepositor;

    private final UserDao userDao;



    public OrderDao(OrderRepository orderRepository, GameDao gameDao, GameService gameService, UserDao userDao, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.gameDao = gameDao;
        this.gameService = gameService;
        this.userDao = userDao;
        this.userRepositor = userRepository;
    }

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order getOrder(long id) {
        Optional<Order> order = this.orderRepository.findById(id);

        if (order.isPresent()) {
            return order.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No specific order has been found");
        }
    }


    @Transactional
    public void createOrder(OrderDTO orderDTO) {
        List<Game> gameList = gameDao.getGames(orderDTO.game_ids);

        Order order = new Order(gameService.makeTitle(gameList), gameService.calculatePrice(gameList), LocalDateTime.now(), gameList);
        order.setUser(userRepositor.findByEmail(orderDTO.user_email));
        this.orderRepository.save(order);

    }



    public void updateOrder(OrderDTO orderDTO, Long id) {
        Optional<Order> order = this.orderRepository.findById(id);
        List<Game> gameList = gameDao.getGames(orderDTO.game_ids);
        if (order.isPresent()) {
            order.get().setGames(gameList);
            order.get().setOrderTitle(gameService.makeTitle(gameList));
            order.get().setOrderPrice(gameService.calculatePrice(gameList));
            order.get().setUser(userRepositor.findByEmail(orderDTO.user_email));
            this.orderRepository.save(order.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fault this id does not exist");
        }
    }


    public void deleteOrderById(Long id) {
        this.orderRepository.deleteById(id);
    }


}
