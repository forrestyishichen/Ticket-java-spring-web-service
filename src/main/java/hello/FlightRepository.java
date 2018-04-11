package hello;

import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    public Flight findByFlightnumber(String flightNumber);
}
