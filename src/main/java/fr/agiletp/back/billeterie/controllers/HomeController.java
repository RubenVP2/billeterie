package fr.agiletp.back.billeterie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.agiletp.back.billeterie.services.EventService;

@RestController
@RequestMapping("/api/home")
public class HomeController {
    
    @Autowired
    EventService eventService;

    @GetMapping("/getEvents")
    public String getEvents(){
        return eventService.getEventsListForHome();
    }

}
