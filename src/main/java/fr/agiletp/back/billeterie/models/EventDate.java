package fr.agiletp.back.billeterie.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dateevenement", schema = "public")
public class EventDate {
    
    @Id
    @Column(name = "iddateevenement")
    private Integer id;

    @Column(name = "dateevenement")
    private Date date;

    @Column(name = "nbplacemax")
    private Integer placeNumber;

    @Column(name = "prixplaceunitaire")
    private Float placePrice;

    @Column(name = "idevenement")
    
}
