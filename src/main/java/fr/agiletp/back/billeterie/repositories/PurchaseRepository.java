package fr.agiletp.back.billeterie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.agiletp.back.billeterie.models.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    
}
