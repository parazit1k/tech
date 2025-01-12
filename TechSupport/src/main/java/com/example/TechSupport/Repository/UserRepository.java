package com.example.TechSupport.Repository;

import com.example.TechSupport.Entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByEmail(String email);
    Users findByEmailOrLogin(String emailOrLogin);
    boolean existsByEmailOrLogin(String email, String login);
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByLoginAndPassword(String email, String password);
}
