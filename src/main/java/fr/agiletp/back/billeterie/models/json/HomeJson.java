package fr.agiletp.back.billeterie.models.json;

import java.sql.Date;

public class HomeJson {

    private Integer idEvent;
    private String nameEvent;
    private String locationEvent;
    private Float minimumPrice;
    private String imagePath;
    private Float multiPassPrice;
    private Date startDate;
    private Date endDate;

    public HomeJson(Integer idEvent, String nameEvent, String locationEvent, Float minimumPrice, String imagePath,
            Float multiPassPrice, Date startDate, Date endDate) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
        this.locationEvent = locationEvent;
        this.minimumPrice = minimumPrice;
        this.imagePath = imagePath;
        this.multiPassPrice = multiPassPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getLocationEvent() {
        return locationEvent;
    }

    public void setLocationEvent(String locationEvent) {
        this.locationEvent = locationEvent;
    }

    public Float getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Float minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Float getMultiPassPrice() {
        return multiPassPrice;
    }

    public void setMultiPassPrice(Float multiPassPrice) {
        this.multiPassPrice = multiPassPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    
    
}
