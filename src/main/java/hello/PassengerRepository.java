package hello;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PassengerRepository extends CrudRepository<Passenger, Long> {
    public Passenger findById(String id);
    public Passenger findByPhone(String phone);
    public void deleteById(String id);
}
