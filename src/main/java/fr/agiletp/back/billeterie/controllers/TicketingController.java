package fr.agiletp.back.billeterie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.agiletp.back.billeterie.models.json.PurchaseJson;
import fr.agiletp.back.billeterie.services.EventService;
import fr.agiletp.back.billeterie.services.PurchaseService;

/**
 * Classe controller pour la page de la billterie
 */
@RestController
@RequestMapping("/api/event")
public class TicketingController {

    @Autowired
    EventService eventService;

    @Autowired
    PurchaseService purchaseService;

    /**
     * Route pour récupèrer un détail d'un event
     * 
     * @param id l'id de l'event
     * @return String(json de DetailsEventJson)
     */
    @GetMapping("/getDetails")
    public String getDetailEvent(@RequestParam int id) {
        return eventService.getEventDetails(id);
    }

    @PostMapping("/buy")
    public ResponseEntity<String> doPurchase(@RequestBody PurchaseJson request){
          try {
            purchaseService.doAPurchase(request);
            String message = "L'événement a été acheté avec succès.";
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            // Gérer les erreurs
            String errorMessage = "Une erreur s'est produite lors de l'achat de l'événement.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


}
