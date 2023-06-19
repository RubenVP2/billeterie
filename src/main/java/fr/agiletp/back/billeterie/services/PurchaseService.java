package fr.agiletp.back.billeterie.services;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.agiletp.back.billeterie.models.Event;
import fr.agiletp.back.billeterie.models.EventDate;
import fr.agiletp.back.billeterie.models.MultiPass;
import fr.agiletp.back.billeterie.models.Purchase;
import fr.agiletp.back.billeterie.models.Ticket;
import fr.agiletp.back.billeterie.models.User;
import fr.agiletp.back.billeterie.models.json.PurchaseJson;
import fr.agiletp.back.billeterie.models.json.TicketJson;
import fr.agiletp.back.billeterie.repositories.EventDateRepository;
import fr.agiletp.back.billeterie.repositories.EventRepository;
import fr.agiletp.back.billeterie.repositories.MultiPassRepository;
import fr.agiletp.back.billeterie.repositories.PurchaseRepository;
import fr.agiletp.back.billeterie.repositories.TicketRepository;
import fr.agiletp.back.billeterie.repositories.UserRepository;

@Service
public class PurchaseService {
    
    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    MultiPassRepository multiPassRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventDateRepository eventDateRepository;

    @Autowired
    UserRepository userRepository;


    public void doAPurchase(PurchaseJson purchaseJson) throws Exception{

        User user = userRepository.findByEmail(purchaseJson.getEmailUser());
        Event event = eventRepository.getReferenceById(purchaseJson.getIdEvent());

        Calendar calendar = Calendar.getInstance();
        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setDate((Date)calendar.getTime());
        purchase.setTotalPrice(purchaseJson.getTotalPrice());
        for (TicketJson ticketJson : purchaseJson.getTicketsList()) {
            if(ticketJson.getIsMultiPass()){
                buyMultiPass(event, purchase, ticketJson.getLastName(), ticketJson.getFirstName());
            } else {

                buyTicket(event, purchase, ticketJson.getDate(), ticketJson.getLastName(), ticketJson.getFirstName());

            }
        }

    }

    private void buyMultiPass(Event event, Purchase purchase, String lastName, String firstName) throws Exception{
       MultiPass multiPass = new MultiPass(lastName, firstName, event, purchase);
       

       for (EventDate eventDate : eventDateRepository.findByEvent(event)) {
            eventDate.setPlaceNumber(eventDate.getPlaceNumber()-1);
            eventDateRepository.save(eventDate);
        }

        multiPassRepository.save(multiPass);
    }

    private void buyTicket(Event event, Purchase purchase, java.util.Date date, String lastName, String firstName) throws Exception{
        EventDate eventDate = eventDateRepository.findByEventAndDate(event, (Date)date);

        eventDate.setPlaceNumber(eventDate.getPlaceNumber()-1);

        ticketRepository.save(new Ticket(lastName, firstName, eventDate, purchase));
        eventDateRepository.save(eventDate);
    }
}
