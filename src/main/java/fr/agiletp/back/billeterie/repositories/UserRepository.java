package fr.agiletp.back.billeterie.repositories;

import fr.agiletp.back.billeterie.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
