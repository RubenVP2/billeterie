package fr.agiletp.back.billeterie.models.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PurchaseJson {

    private Integer idEvent;

    @SerializedName(value = "user")
    private String emailUser;

    @SerializedName(value = "prixTotal")
    private Float totalPrice;

    @SerializedName(value = "billet")
    private List<TicketJson> ticketsList;
    
    public PurchaseJson() {
    }

    public PurchaseJson(Integer idEvent, String emailUser, Float totalPrice, List<TicketJson> ticketsList) {
        this.idEvent = idEvent;
        this.emailUser = emailUser;
        this.totalPrice = totalPrice;
        this.ticketsList = ticketsList;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<TicketJson> getTicketsList() {
        return ticketsList;
    }

    public void setTicketsList(List<TicketJson> ticketsList) {
        this.ticketsList = ticketsList;
    }

    
}
