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
@Table(name = "achat", schema = "public")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idachat")
    private Integer id;

    @Column(name = "dateachat")
    private Date date;

    @Column(name = "prixtotal")
    private Float totalPrice;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private User user;

    public Purchase() {
    }

    public Purchase(Date date, Float totalPrice, User user) {
        this.date = date;
        this.totalPrice = totalPrice;
        this.user = user;
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

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
