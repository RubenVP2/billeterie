package fr.agiletp.back.billeterie.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evenement", schema = "public")
public class Event {
    
    @Id
    @Column(name = "idevenement")
    private Integer id;

    @Column(name = "nomevenement")
    private String name;

    @Column(name = "datedebut")
    private Date startDate;

    @Column(name = "datefin")
    private Date endDate;

    @Column(name = "prixpassunitaire")
    private Float price;
}
