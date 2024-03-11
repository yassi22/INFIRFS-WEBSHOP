package com.example.codealongw3.dao;

import com.example.codealongw3.dto.UserDTO;
import com.example.codealongw3.models.CustomUser;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class UserDao {
    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<CustomUser> getAllUsers(){
        return this.userRepository.findAll();
    }

//    public void updateUser(UserDTO userDTO, Long id){
//        Optional<CustomUser> user = this.userRepository.findById(id);
//
//        if(user.isPresent()){
//            user.get().setVoornaam(userDTO.voornaam);
//
//        }
//    }
//

    public CustomUser getUser(long id){
        Optional<CustomUser> user = this.userRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user has been found");
        }
    }

   @Transactional
    public void createUser(){
        CustomUser user = new CustomUser();
        this.userRepository.save(user);
   }

   public void deletUserById(Long id){
        this.userRepository.deleteById(id);
   }




}
