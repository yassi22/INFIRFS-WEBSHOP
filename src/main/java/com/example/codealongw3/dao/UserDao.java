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



    public CustomUser getUser(long id){
        Optional<CustomUser> user = this.userRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user has been found");
        }
    }

    public void updateUser(UserDTO userDTO, Long id){
        Optional<CustomUser> user = this.userRepository.findById(id);

        if(user.isPresent()){
            user.get().setEmail(userDTO.email);
            user.get().setPassword(userDTO.password);
            user.get().setVoornaam(userDTO.voornaam);
            user.get().setTussenvoegsel(userDTO.tussenvoegsel);
            user.get().setAchternaam(userDTO.achternaam);
            user.get().setStraat(userDTO.straat);
            user.get().setHuisnummer(userDTO.huisnummer);
            user.get().setPostcode(userDTO.postcode);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not update user");
        }

    }



    @Transactional
    public void createUser(UserDTO userDTO){
        CustomUser user = new CustomUser(userDTO.email, userDTO.password, userDTO.voornaam, userDTO.tussenvoegsel, userDTO.achternaam, userDTO.straat, userDTO.huisnummer, userDTO.postcode, "ROLE: USER");
        this.userRepository.save(user);
    }

    @Transactional
    public void makeUserAdmin(Long userId){
        CustomUser userAdmin = userRepository.findById(userId).get();
        userAdmin.setRole("ROLE_ADMIN");
        userRepository.save(userAdmin);
    }

    @Transactional
    public void makeUserBeheerder(Long userId){
        CustomUser userBeheerder = userRepository.findById(userId).get();
        userBeheerder.setRole("ROLE_BEHEERDER");
        userRepository.save(userBeheerder);
    }




    public void deletUserById(Long id){
        this.userRepository.deleteById(id);
   }


}
