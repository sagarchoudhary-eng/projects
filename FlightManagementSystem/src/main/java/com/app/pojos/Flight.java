package com.app.pojos;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    private String flightName;
   
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   @Temporal(TemporalType.DATE)
    private Date departureDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;

    private String departureTime;

    private String arrivalTime;

    private double flightCharge;

    private String fromCity;
    
    private String toCity;
    
    @OneToMany(mappedBy = "flight",cascade = CascadeType.ALL)
    List<Passenger> passengers = new ArrayList<>();

    public Flight() {
    }

	public Flight(String flightName, Date departureDate, Date arrivalDate, String fromCity, String toCity) {
		super();
		this.flightName = flightName;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
	}

	

    public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getFlightCharge() {
        return flightCharge;
    }

    public void setFlightCharge(double flightCharge) {
        this.flightCharge = flightCharge;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
    
    public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setTo(String toCity) {
		this.toCity = toCity;
	}
	
	public void savePass(Passenger p) {
		
		this.passengers.add(p);
		p.setFlight(this);
		
	}
}