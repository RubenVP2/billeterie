package fr.agiletp.back.billeterie.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="billet", schema = "public")
public class Ticket {
    
    @Id
    @Column(name = "idbillet")
    private Integer id;

    @Column(name = "nom")
    private String lastName;

    @Column(name = "prenom")
    private String firstName;

    
}
