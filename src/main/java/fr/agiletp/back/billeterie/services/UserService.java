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

    /**
     * Connexion de l'utilisateur
     * @param email email de l'utilisateur
     * @param password mot de passe de l'utilisateur
     * @return utilisateur connecté
     * @throws Exception erreur si l'utilisateur n'est pas trouvé
     */
    public User login(String email, String password) throws NullPointerException {
        // Récupération de l'utilisateur
        User user = userRepository.findByEmailAndPassword(email, password);

        if (user == null) {
            // Throw erreur pour dire qu'aucun user n'a été trouvé
            throw new NullPointerException("Utilisateur introuvable, veuillez vérifier l'email ou le mot de passe.");
        }
        // Retourner l'utilisateur
        return user;
    }

    /**
     * Création d'un utilisateur
     * @param user utilisateur à créer
     * @return utilisateur créé
     */
    public User create(User user) {
        if (Boolean.TRUE.equals(userRepository.existsByEmail(user.getEmail()))) {
            // Throw erreur pour dire qu'un utilisateur existe déjà avec cet email
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Un utilisateur existe déjà avec cet email");
        }
        return userRepository.save(user);
    }

    /**
     * Suppression d'un utilisateur
     * @param email email de l'utilisateur à supprimer
     */
    public void deleteUser(String email) {
        // Récupération de l'utilisateur
        User user = userRepository.findByEmail(email);

        if (user == null) {
            // Throw erreur pour dire qu'aucun user n'a été trouvé
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Suppression impossible, utilisateur introuvable.");
        }
        // Suppression de l'utilisateur
        userRepository.delete(user);
    }
}
