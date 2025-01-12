package com.example.TechSupport.Controller;

import com.example.TechSupport.DTO.UsersDTO;
import com.example.TechSupport.Entity.Users;
import com.example.TechSupport.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public String createUser(@RequestBody Users newUser) {
        if(userService.createUser(newUser)) return "Такой пользователь уже существует!";

        return newUser.toString();
    }

    @GetMapping("login")
    public ResponseEntity<Optional<Users>> login(@RequestParam String login, @RequestParam String password) {

        if (userService.login(new UsersDTO(login, password))) return ResponseEntity.ok(userService.getUser(login));

        return ResponseEntity.notFound().build();
    }

}
