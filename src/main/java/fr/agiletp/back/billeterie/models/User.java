package fr.agiletp.back.billeterie.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nom_utilisateur", nullable = false)
    private String nomUtilisateur;

    @Column(name = "prenom_utilisateur", nullable = false)
    private String prenomUtilisateur;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "isAdmin")
    private Boolean isAdmin;

    public User() {
    }

    public User(String nomUtilisateur, String prenomUtilisateur, String password, String email, Boolean isAdmin) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return nomUtilisateur;
    }

    public void setLastName(String lastName) {
        this.nomUtilisateur = lastName;
    }

    public String getFirstName() {
        return prenomUtilisateur;
    }

    public void setFirstName(String firstName) {
        this.prenomUtilisateur = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

}
