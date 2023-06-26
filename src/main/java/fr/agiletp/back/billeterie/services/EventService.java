package fr.agiletp.back.billeterie.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import fr.agiletp.back.billeterie.models.Event;
import fr.agiletp.back.billeterie.models.EventDate;
import fr.agiletp.back.billeterie.models.json.DateEventJson;
import fr.agiletp.back.billeterie.models.json.DetailsEventJson;
import fr.agiletp.back.billeterie.models.json.HomeJson;
import fr.agiletp.back.billeterie.repositories.EventDateRepository;
import fr.agiletp.back.billeterie.repositories.EventRepository;

@Service
public class EventService {
    
    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventDateRepository eventDateRepository;

    public String getEventsListForHome(){
       List<Event> events =  eventRepository.findAll();
       List<HomeJson> homeJsons = new ArrayList<>();
       for (Event event : events) {
            HomeJson json = new HomeJson(event, getLowerPriceEvent(event));
            homeJsons.add(json);
       }
       Gson gson = new Gson();
      
        return gson.toJson(homeJsons);
      
    }

    public String getEventDetails(int id){
        Event event = null;
        if(eventRepository.existsById(id)){
            event = eventRepository.getReferenceById(id);
        }

        DetailsEventJson detailsEvent = new DetailsEventJson(event);
        List<DateEventJson> dateEventJsonList = new ArrayList<>();
        for(EventDate ed : eventDateRepository.findByEvent(event)){
            DateEventJson dateEventJson = new DateEventJson(ed);
            dateEventJsonList.add(dateEventJson);
        }
        detailsEvent.setDatesEvent(dateEventJsonList);

        Gson gson = new Gson();
      
        return gson.toJson(detailsEvent);
    }

    private Float getLowerPriceEvent(Event event){
        
        List<EventDate> eventDateList = eventDateRepository.findByEvent(event);
        List<Float> priceList = new ArrayList<>();
        for (EventDate eventDate : eventDateList) {
            priceList.add(eventDate.getPlacePrice());
        }

        Collections.sort(priceList);
        return priceList.get(0);
    }
}
