package fr.agiletp.back.billeterie.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="utilisateur", schema = "public")
public class User {

    @Id
    @Column(name = "idutilisateur")
    private Integer id;

    @Column(name = "nomutilisateur")
    private String lastName;

    @Column(name = "prenomutilisateur")
    private String firstName;

    @Column(name = "motdepasse")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "isadmin")
    private Boolean isAdmin;

    public User() {
    }

    public User(String nomUtilisateur, String prenomUtilisateur, String password, String email, Boolean isAdmin) {
        this.lastName = nomUtilisateur;
        this.firstName = prenomUtilisateur;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public int getId() {
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
