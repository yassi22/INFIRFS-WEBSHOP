package com.example.codealongw3.controller;

import com.example.codealongw3.dao.UserDao;
import com.example.codealongw3.dto.UserDTO;
import com.example.codealongw3.models.CustomUser;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    private UserDao userDao;


    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PreAuthorize(" hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<CustomUser>> getAllUsers() {
        return ResponseEntity.ok(userDao.getAllUsers());
    }

    @PreAuthorize(" hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<CustomUser> getUser(@PathVariable Long id) {
        try {
            CustomUser user = this.userDao.getUser(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize(" hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        this.userDao.updateUser(userDTO, id);
        return ResponseEntity.ok("User details is updated " + id);
    }

    @PreAuthorize(" hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        try {
            this.userDao.createUser(userDTO);
            return ResponseEntity.ok("Created a new user");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PreAuthorize(" hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        this.userDao.deletUserById(id);
        return ResponseEntity.ok("User is deleted");
    }


}
