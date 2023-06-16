package fr.agiletp.back.billeterie.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="billetmultipass", schema = "public")
public class MultiPass {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbilletmultipass")
    private Integer id;

    @Column(name = "nom")
    private String lastName;

    @Column(name = "prenom")
    private String firstName;

    @ManyToOne
    @JoinColumn(name = "idevenement")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "idachat")
    private Purchase purchase;

    public MultiPass() {
    }

    public MultiPass(String lastName, String firstName, Event event, Purchase purchase) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.event = event;
        this.purchase = purchase;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
