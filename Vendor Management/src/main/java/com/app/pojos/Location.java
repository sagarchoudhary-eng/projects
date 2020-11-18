package com.app.pojos;
import javax.persistence.*;
@Entity
@Table(name="location_tbl")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="location_id")
	private Integer locationId;
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;
	@Column(length = 20)
	private String country;
	// one to one mapping between entities , location : owning side
	@OneToOne
	@JoinColumn(name="vendor_id")
	private Vendor currentVendor;

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public Location(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Vendor getCurrentVendor() {
		return currentVendor;
	}

	public void setCurrentVendor(Vendor currentVendor) {
		this.currentVendor = currentVendor;
	}
	
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", city=" + city + ", state=" + state + ", country=" + country
				+ "]";
	}
	

}
