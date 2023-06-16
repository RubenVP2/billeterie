package fr.agiletp.back.billeterie.services;

import fr.agiletp.back.billeterie.models.User;
import fr.agiletp.back.billeterie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Récupération de l'utilisateur par son email et son mot de passe
    public User login(String email, String password) throws Exception {
        // Récupération de l'utilisateur
        User user = userRepository.findByEmailAndPassword(email, password);

        if (user == null) {
            // Throw erreur pour dire qu'aucun user n'a été trouvé
            throw new Exception("Utilisateur introuvable");
        }
        // Retourner l'utilisateur
        return user;
    }

    // Création d'un utilisateur
    public User create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            // Throw erreur pour dire qu'un utilisateur existe déjà avec cet email
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Un utilisateur existe déjà avec cet email");
        }
        return userRepository.save(user);
    }

}
