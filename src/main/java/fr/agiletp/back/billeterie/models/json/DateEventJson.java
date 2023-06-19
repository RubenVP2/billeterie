package fr.agiletp.back.billeterie.models.json;

import java.util.Date;

import fr.agiletp.back.billeterie.models.EventDate;

public class DateEventJson {
    
    private Integer id;
    private Date date;
    private Float price;
    private Integer placeMax;
    
    public DateEventJson() {
    }

    public DateEventJson(Integer id, Date date, Float price, Integer placeMax) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.placeMax = placeMax;
    }

    public DateEventJson(EventDate eventDate) {
        this.id = eventDate.getId();
        this.date = eventDate.getDate();
        this.price = eventDate.getPlacePrice();
        this.placeMax = eventDate.getPlaceNumber();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getPlaceMax() {
        return placeMax;
    }

    public void setPlaceMax(Integer placeMax) {
        this.placeMax = placeMax;
    }

    

    

    
}
