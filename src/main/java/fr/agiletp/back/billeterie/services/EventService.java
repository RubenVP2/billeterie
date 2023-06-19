package fr.agiletp.back.billeterie.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import fr.agiletp.back.billeterie.models.Event;
import fr.agiletp.back.billeterie.models.EventDate;
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
            HomeJson json = new HomeJson(event.getId(), event.getName(), event.getLocation(), getLowerPriceEvent(event), event.getImagePath(), event.getMultipassPrice(), event.getStartDate(), event.getEndDate());
            homeJsons.add(json);
       }
       Gson gson = new Gson();
      
        return gson.toJson(homeJsons);
      
    }

    private Float getLowerPriceEvent(Event event){
        
        List<EventDate> eventDateList = eventDateRepository.getFindByEvent(event);
        List<Float> priceList = new ArrayList<>();
        for (EventDate eventDate : eventDateList) {
            priceList.add(eventDate.getPlacePrice());
        }

        return priceList.stream().min(Float::compare).get();
    }
}
