package fr.agiletp.back.billeterie.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="billetmultipass", schema = "public")
public class MultiPass {
    
    @Id
    @Column(name = "idbilletmultipass")
    private Integer id;

    @Column(name = "nom")
    private String lastName;

    @Column(name = "prenom")
    private String firstName;
}
