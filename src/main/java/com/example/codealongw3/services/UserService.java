package com.example.codealongw3.services;

import com.example.codealongw3.dao.UserRepository;
import com.example.codealongw3.models.CustomUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomUser customUser = userRepository.findByEmail(email);
        return new User(email, customUser.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE USER")));
    }

    public UserDetails setAdmin(String email) throws  UsernameNotFoundException{
        return new User(email,);
    }

}
