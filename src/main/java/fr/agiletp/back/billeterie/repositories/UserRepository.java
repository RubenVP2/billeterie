package fr.agiletp.back.billeterie.repositories;

import fr.agiletp.back.billeterie.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    Boolean existsByEmail(String email);
}
