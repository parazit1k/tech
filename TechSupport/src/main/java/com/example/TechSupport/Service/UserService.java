package com.example.TechSupport.Service;

import com.example.TechSupport.DTO.UsersDTO;
import com.example.TechSupport.Entity.Users;
import com.example.TechSupport.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean createUser(Users newUser) {
        if(userRepository.existsByEmailOrLogin(newUser.email, newUser.login)){
            return false;
        }

        userRepository.save(newUser);

        return true;
    }

    public boolean login(UsersDTO usersDTO){
        return userRepository.existsByLoginAndPassword(usersDTO.getLogin(), usersDTO.getPassword()) || userRepository.existsByEmailAndPassword(usersDTO.getLogin(), usersDTO.getPassword());
    }

    public Optional<Users> getUser(String login){
        return Optional.ofNullable(userRepository.findByEmailOrLogin(login));
    }
}
