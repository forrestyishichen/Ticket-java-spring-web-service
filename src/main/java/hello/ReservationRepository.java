package hello;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Reservation findByReservationNumber(String number);
    public List<Reservation> findByPassenger(Passenger passenger);
}