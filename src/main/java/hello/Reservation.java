package hello;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @Column(name = "number")
    private String reservationNumber;

    @ManyToOne(targetEntity=Passenger.class, cascade=CascadeType.DETACH)
    private Passenger passenger;

    @Column(name = "price")
    private double price;

    @ManyToMany(targetEntity=Flight.class)
    @JoinTable(
            name = "RETOFL",
            joinColumns = {@JoinColumn(name = "reservationnumber", referencedColumnName = "number")},
            inverseJoinColumns = {@JoinColumn(name = "flightnumber", referencedColumnName = "flightnumber")}
    )
    private List<Flight> flights = new LinkedList<>();

    public Reservation(){
    }

    public Reservation(int price, Passenger passenger, List<Flight> flights){
        this.price = price;
        this.passenger = passenger;
        this.flights = flights;
    }

    @PrePersist
    public void setUniqueReservationNumber(){
        this.reservationNumber = UUID.randomUUID().toString();
    }

    @JsonView(Views.Public.class)
    public String getReservationNumber() {
        return reservationNumber;
    }
    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    @JsonView(Views.Private2.class)
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @JsonView(Views.Public.class)
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonView(Views.Public.class)
    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
