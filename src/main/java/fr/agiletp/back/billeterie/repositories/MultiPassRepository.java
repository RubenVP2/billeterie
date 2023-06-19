package fr.agiletp.back.billeterie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.agiletp.back.billeterie.models.MultiPass;

public interface MultiPassRepository extends JpaRepository<MultiPass, Integer> {
    
}
