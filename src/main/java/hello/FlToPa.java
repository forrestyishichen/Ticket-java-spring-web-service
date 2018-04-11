package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FLTOPA")
public class FlToPa {
    @Id
    @Column(name = "flightnumber")
    private String flightNumber;

    @Column(name = "id")
    private String id;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPassengerId() {
        return id;
    }

    public void setPassengerId(String id) {
        this.id = id;
    }
}
