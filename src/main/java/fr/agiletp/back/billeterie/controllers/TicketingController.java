package fr.agiletp.back.billeterie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.agiletp.back.billeterie.services.EventService;

@RestController
@RequestMapping("/api/event")
public class TicketingController {
    
    @Autowired
    EventService eventService;

    @GetMapping("/getDetails")
    public String getDetailEvent(@RequestParam int id){
        return eventService.getEventDetails(id);
    }
}
