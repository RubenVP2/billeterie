package fr.agiletp.back.billeterie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.agiletp.back.billeterie.models.User;
import fr.agiletp.back.billeterie.services.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Connexion de l'utilisateur
    @PostMapping("/login")
    public ResponseEntity<User> login(String email, String password) {
        try {
            // Récupération de l'utilisateur
            User user = userService.login(email, password);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            // Erreur remonté pour utilisateur introuvable
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
