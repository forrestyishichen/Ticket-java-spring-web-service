package hello;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Plane {

    private int capacity;
    private String model;
    private String manufacturer;
    private int yearOfManufacture;

    public Plane(){

    }

    public Plane(int capacity, String model,
                 String manufacturer, int yearOfManufacture){
        this.capacity = capacity;
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
    }

    @JsonView(Views.Public.class)
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @JsonView(Views.Public.class)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @JsonView(Views.Public.class)
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    @JsonView(Views.Public.class)
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
}