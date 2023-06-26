package fr.agiletp.back.billeterie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.agiletp.back.billeterie.services.EventService;

/**
 * Classe controler pour la page d'accueil
 */
@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    EventService eventService;

    /**
     * Méthode route pour récupérer la liste des évenements
     * 
     * @return String (json de HomeJson)
     */
    @GetMapping("/getEvents")
    public String getEvents() {
        return eventService.getEventsListForHome();
    }

}
