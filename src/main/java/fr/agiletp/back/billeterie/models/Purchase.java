package fr.agiletp.back.billeterie.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="achat", schema = "public")
public class Purchase {

    @Id
    @Column(name = "idachat")
    private Integer id;

    @Column(name = "dateachat")
    private Date date;

    @Column(name = "prixtotal")
    private Float totalPrice;
    
}
