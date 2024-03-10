package com.example.codealongw3.dao;


import com.example.codealongw3.dto.OrderDTO;
import com.example.codealongw3.models.Order;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDao {
    private final OrderRepository orderRepository;

    public OrderDao(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }

    public Order getOrder(long id){
        Optional<Order> order = this.orderRepository.findById(id);

        if(order.isPresent()){
            return order.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No specific order has been found");
        }
    }

    @Transactional
    public void createOrder(){
        Order order = new Order();
        this.orderRepository.save(order);

    }

    public void updateOrder(OrderDTO orderDTO, Long id ){
        Optional<Order> order = this.orderRepository.findById(id);

        if(order.isPresent()){
//            order.get().setGames();
            this.orderRepository.save(order.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fault this id does not exist");
        }
    }



    public void deleteOrderById(Long id){
        this.orderRepository.deleteById(id);
    }


}
