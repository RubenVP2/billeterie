package fr.agiletp.back.billeterie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import fr.agiletp.back.billeterie.models.User;
import fr.agiletp.back.billeterie.services.UserService;

/**
 * Classe controller pour la gestion des utilisateurs et de la connexion
 */
@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Connexion de l'utilisateur
     * 
     * @param email    email de l'utilisateur
     * @param password mot de passe de l'utilisateur
     * @return utilisateur connecté
     */
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

    /**
     * Création d'un utilisateur
     * 
     * @param user utilisateur à créer
     * @return utilisateur créé
     */
    @PostMapping("/create")
    public ResponseEntity<User> create(User user) {
        try {
            // Création de l'utilisateur
            User createdUser = userService.create(user);
            return ResponseEntity.ok().body(createdUser);
        } catch (Exception e) {
            // Erreur remonté pour utilisateur introuvable
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    /**
     * Suppression d'un utilisateur
     * 
     * @param email email de l'utilisateur à supprimer
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(String email) {
        try {
            // Suppression de l'utilisateur
            userService.deleteUser(email);
            return ResponseEntity.ok().body("Utilisateur supprimé");
        } catch (Exception e) {
            // Erreur remonté pour utilisateur introuvable
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
