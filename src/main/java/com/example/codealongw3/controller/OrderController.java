package com.example.codealongw3.controller;


import com.example.codealongw3.dao.OrderDao;
import com.example.codealongw3.dao.UserDao;
import com.example.codealongw3.dto.OrderDTO;
import com.example.codealongw3.models.CustomUser;
import com.example.codealongw3.services.OrderService;
import com.example.codealongw3.services.UserService;
import jakarta.annotation.security.RolesAllowed;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.codealongw3.models.Order;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/order")
public class OrderController {

    private OrderDao orderDao;
    private UserDao userDao;

    private OrderService orderService;

    public OrderController(OrderDao orderDao, UserDao userDao, OrderService orderService){
        this.orderDao = orderDao;
        this.userDao = userDao;
        this.orderService = orderService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderDao.getAllOrders());
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO){
        this.orderDao.updateOrder(orderDTO, id);
        return ResponseEntity.ok("Order is updated" + id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        try {
            Order order =  this.orderDao.getOrder(id);
            return ResponseEntity.ok(order);
        } catch (ResponseStatusException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping ("/user/{userId}")
    public ResponseEntity <List<Order>> getOrderUser(@PathVariable Long userId) {
        try {

            List<Order> order = this.orderService.findOrderUser(userId);
            return ResponseEntity.ok(order);

        } catch (ResponseStatusException e) {
            return ResponseEntity.badRequest().build();
        }


    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO){
        try{
           this.orderDao.createOrder(orderDTO);
           return ResponseEntity.ok("Order created");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.orderDao.deleteOrderById(id);
        return ResponseEntity.ok("Order is deleted");
    }


}
