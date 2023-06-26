package fr.agiletp.back.billeterie.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.agiletp.back.billeterie.models.Event;
import fr.agiletp.back.billeterie.models.EventDate;

public interface EventDateRepository extends JpaRepository<EventDate, Integer> {

    List<EventDate> findByEvent(Event event);
    EventDate findByEventAndDate(Event event, Date date);
}
