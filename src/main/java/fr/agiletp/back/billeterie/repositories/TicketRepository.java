package fr.agiletp.back.billeterie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.agiletp.back.billeterie.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
    
}
