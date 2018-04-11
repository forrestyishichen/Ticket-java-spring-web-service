package hello;

import javax.persistence.*;
import java.util.UUID;
import java.util.List;
import java.util.LinkedList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "PASSENGER")
public class Passenger {

	@Id
	@Column(name = "id", unique=true)
	private String id;

	@Column(name = "firstname", nullable = false)
	private String firstname;

	@Column(name = "lastname", nullable = false)
	private String lastname;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "phone", nullable = false, unique = true)
	private String phone;

//	@OneToMany(mappedBy = "passengers")
	@OneToMany(targetEntity=Reservation.class, cascade=CascadeType.ALL)
	private List<Reservation> reservations = new LinkedList<>();

//	@ManyToMany(mappedBy = "passengers")
	@ManyToMany(targetEntity=Flight.class, cascade=CascadeType.ALL)
	private List<Flight> flights = new LinkedList<>();

	@PrePersist
	public void setUniqueId() {
		this.id = UUID.randomUUID().toString();
	}

	public Passenger(){
	}

	public Passenger(String firstname, String lastname, int age, String gender,
				 String phone){
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}

	@JsonView(Views.Public.class)
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@JsonView(Views.Public.class)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@JsonView(Views.Public.class)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@JsonView(Views.Public.class)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@JsonView(Views.Public.class)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonView(Views.Public.class)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonView(Views.Public.class)
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@JsonView(Views.Public.class)
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
}

