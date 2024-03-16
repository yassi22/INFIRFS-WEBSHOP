package com.example.codealongw3.services;

import com.example.codealongw3.dao.OrderDao;
import com.example.codealongw3.dao.UserDao;
import com.example.codealongw3.dto.OrderDTO;
import com.example.codealongw3.models.CustomUser;
import com.example.codealongw3.models.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public UserDao userDao;

    public OrderService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<Order> findOrderUser(long userId) {
        CustomUser user = userDao.getUser(userId);

        if (user.orders == null) {
            return new ArrayList<>();
        } else {
            return user.orders;
        }
    }
}
