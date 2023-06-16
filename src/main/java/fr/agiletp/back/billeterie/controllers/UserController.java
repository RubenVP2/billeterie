package fr.agiletp.back.billeterie.controllers;

import fr.agiletp.back.billeterie.models.User;
import fr.agiletp.back.billeterie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Retourner la liste des utilisateurs (GET)
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
