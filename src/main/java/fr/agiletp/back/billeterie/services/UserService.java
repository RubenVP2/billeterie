package fr.agiletp.back.billeterie.services;

import fr.agiletp.back.billeterie.models.User;
import fr.agiletp.back.billeterie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
