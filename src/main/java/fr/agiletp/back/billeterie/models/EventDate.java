package fr.agiletp.back.billeterie.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dateevenement", schema = "public")
public class EventDate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddateevenement")
    private Integer id;

    @Column(name = "dateevenement")
    private Date date;

    @Column(name = "nbplacemax")
    private Integer placeNumber;

    @Column(name = "prixplaceunitaire")
    private Float placePrice;

    @ManyToOne
    @JoinColumn(name = "idevenement")
    private Event event;

    public EventDate() {
    }

    public EventDate(Date date, Integer placeNumber, Float placePrice, Event event) {
        this.date = date;
        this.placeNumber = placeNumber;
        this.placePrice = placePrice;
        this.event = event;
    }
     
    public Integer getId() {
        return id;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }

    public Float getPlacePrice() {
        return placePrice;
    }

    public void setPlacePrice(Float placePrice) {
        this.placePrice = placePrice;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


    

    
    
}
