package hello;

import org.springframework.data.repository.CrudRepository;

public interface ReToFlRepository extends CrudRepository<ReToFl, String> {
    ReToFl deleteByReservationNumber(String reservationnum);
    ReToFl deleteByFlightNumber(String flightnum);
}