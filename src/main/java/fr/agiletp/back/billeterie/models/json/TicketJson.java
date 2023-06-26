package fr.agiletp.back.billeterie.models.json;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class TicketJson {
    
    private Integer id;
    private String date;
    
    @SerializedName(value = "name")
    private String lastName;

    @SerializedName(value = "prenom")
    private String firstName;

    @SerializedName(value = "isMultipass")
    private Boolean isMultiPass;

    public TicketJson() {
    }

    public TicketJson(Integer id,String date, String lastName, String firstName, Boolean isMultiPass) {
        this.id = id;
        this.date = date;
        this.lastName = lastName;
        this.firstName = firstName;
        this.isMultiPass = isMultiPass;
    }

    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public Date dateStringToJavaDate() throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        return dateFormat.parse(this.date);
    }
}
