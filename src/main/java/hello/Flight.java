package hello;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "FLIGHT")
public class Flight {

    @Id
    @Column(name = "flightnumber", unique = true)
    private String flightnumber;

    @Column(name = "price")
    private double price;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String to;

    @Column(name = "departuretime")
    private Date departuretime;

    @Column(name = "arrivaltime")
    private Date arrivaltime;

    @Column(name = "seatsleft")
    private int seatsleft;

    @Column(name = "description")
    private String description;

    @Embedded
    private Plane plane;

    @ManyToMany(targetEntity = Passenger.class)
    @JoinTable(
            name = "FLTOPA",
            joinColumns = {@JoinColumn(name = "flightnumber", referencedColumnName = "flightnumber")},
            inverseJoinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")}
    )
    private List<Passenger> passenger;

    public Flight() {
    }

    public Flight(String flightnumber, double price, String origin,
                  String to, Date departureTime, Date arrivalTime,
                  String description, List<Passenger> passenger, Plane plane) {
        this.flightnumber = flightnumber;
        this.price = price;
        this.origin = origin;
        this.to = to;
        this.departuretime = departureTime;
        this.arrivaltime = arrivalTime;
        this.description = description;
        this.plane = plane;
        this.seatsleft = plane.getCapacity();
        this.passenger = passenger;
    }

    @JsonView(Views.Public.class)
    public String getFlightnumberumber() {
        return flightnumber;
    }
    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    @JsonView(Views.Public.class)
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonView(Views.Public.class)
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonView(Views.Public.class)
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }

    @JsonView(Views.Public.class)
    public Date getDepartureTime() {
        return departuretime;
    }
    public void setDepartureTime(Date departuretime) {
        this.departuretime = departuretime;
    }

    @JsonView(Views.Public.class)
    public Date getArrivalTime() {
        return arrivaltime;
    }
    public void setArrivalTime(Date arrivalTime) {
        this.arrivaltime = arrivaltime;
    }

    @JsonView(Views.Public.class)
    public int getSeatsLeft() {
        return seatsleft;
    }
    public void setSeatsLeft(int seatsleft) {
        this.seatsleft = seatsleft;
    }

    @JsonView(Views.Public.class)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonView(Views.Public.class)
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @JsonView(Views.Private3.class)
    public List<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(List<Passenger> passenger) {
        this.passenger = passenger;
    }
}
