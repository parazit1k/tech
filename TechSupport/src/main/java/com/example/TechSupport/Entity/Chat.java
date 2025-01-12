package com.example.TechSupport.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @ManyToOne
    public Users tech;

    @OneToOne
    public Users client;

    @ManyToMany
    public List<Messages> messagesList;
}
