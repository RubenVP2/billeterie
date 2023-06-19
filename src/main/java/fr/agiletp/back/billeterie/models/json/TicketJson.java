package fr.agiletp.back.billeterie.models.json;

import java.util.Date;

public class TicketJson {
    
    private Integer id;
    private Date date;
    private String lastName;
    private String firstName;
    private Boolean isMultiPass;

    public TicketJson() {
    }

    public TicketJson(Integer id,Date date, String lastName, String firstName, Boolean isMultiPass) {
        this.id = id;
        this.date = date;
        this.lastName = lastName;
        this.firstName = firstName;
        this.isMultiPass = isMultiPass;
    }

    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Boolean getIsMultiPass() {
        return isMultiPass;
    }

    public void setIsMultiPass(Boolean isMultiPass) {
        this.isMultiPass = isMultiPass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
