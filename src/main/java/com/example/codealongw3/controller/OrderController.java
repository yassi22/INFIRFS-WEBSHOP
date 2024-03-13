package com.example.codealongw3.controller;


import com.example.codealongw3.dao.OrderDao;
import com.example.codealongw3.dto.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.codealongw3.models.Order;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderDao orderDao;

    public OrderController(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderDao.getAllOrders());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO){
        this.orderDao.updateOrder(orderDTO, id);
        return ResponseEntity.ok("Order is updated" + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        try {
            Order order =  this.orderDao.getOrder(id);
            return ResponseEntity.ok(order);
        } catch (ResponseStatusException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO){
        try{
           this.orderDao.createOrder(orderDTO);
           return ResponseEntity.ok("Order created");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.orderDao.deleteOrderById(id);
        return ResponseEntity.ok("Order is deleted");
    }


}
