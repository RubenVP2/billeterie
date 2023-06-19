package fr.agiletp.back.billeterie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.agiletp.back.billeterie.models.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
    
}
