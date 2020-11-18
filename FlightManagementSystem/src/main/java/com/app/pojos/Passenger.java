package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String phoneNumber;
	@NotBlank
	private String passportNumber;

	private String email;

	private String address;

	
	@OneToOne(mappedBy = "CurrPassanger",cascade = CascadeType.ALL)
	private Payment payment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pairline_id")
	private Flight flight;

	public Passenger() {
	}

	public Passenger(String firstName ,String phoneNumber, String passportNumber, String email,
			String address) {
		this.firstName = firstName;
		
		this.phoneNumber = phoneNumber;
		this.passportNumber = passportNumber;
		this.email = email;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + id + ", firstName=" + firstName + 
				 ", phoneNumber=" + phoneNumber + ", passportNumber=" + passportNumber + ", email=" + email
				+ ", address=" + address + "]";
	}
	

	public void savePayment(Payment p) {
		
		this.payment=p;
		p.setCurrPassanger(this);
		
	}

}
