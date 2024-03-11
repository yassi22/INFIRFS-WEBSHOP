package com.example.codealongw3.dao;

import com.example.codealongw3.models.CustomUser;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<CustomUser> getAllUsers(){
        return this.userRepository.findAll();
    }




}
