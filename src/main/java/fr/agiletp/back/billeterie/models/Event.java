package fr.agiletp.back.billeterie.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evenement", schema = "public")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idevenement")
    private Integer id;

    @Column(name = "nomevenement")
    private String name;

    @Column(name = "lieuevenement")
    private String location;

    @Column(name = "datedebut")
    private Date startDate;

    @Column(name = "datefin")
    private Date endDate;

    @Column(name = "prixpassunitaire")
    private Float multipassPrice;

    @Column(name = "imagepath")
    private String imagePath;

    public Event() {
    }

    public Event(String name, Date startDate, Date endDate, Float price, String imagePath) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.multipassPrice = price;
        this.imagePath = imagePath;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getMultipassPrice() {
        return multipassPrice;
    }

    public void setMultipassPrice(Float price) {
        this.multipassPrice = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    
}
