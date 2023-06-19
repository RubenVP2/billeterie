package fr.agiletp.back.billeterie.models.json;

import java.util.List;

import fr.agiletp.back.billeterie.models.Event;

public class DetailsEvent {
    
   private Integer id;
    private String name;
    private String location;
    private Float multiPassPrice;
    private String imagePath;
    private List<DateEventJson> datesEvent;
    
    public DetailsEvent() {
    }

    public DetailsEvent(Integer id, String name, String location, Float multiPassPrice, String imagePath,
            List<DateEventJson> datesEvent) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.multiPassPrice = multiPassPrice;
        this.imagePath = imagePath;
        this.datesEvent = datesEvent;
    }

    public DetailsEvent(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.location = event.getLocation();
        this.multiPassPrice = event.getMultipassPrice();
        this.imagePath = event.getImagePath();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getMultiPassPrice() {
        return multiPassPrice;
    }

    public void setMultiPassPrice(Float multiPassPrice) {
        this.multiPassPrice = multiPassPrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<DateEventJson> getDatesEvent() {
        return datesEvent;
    }

    public void setDatesEvent(List<DateEventJson> datesEvent) {
        this.datesEvent = datesEvent;
    }

    

    

    
}
