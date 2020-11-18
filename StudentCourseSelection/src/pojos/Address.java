package pojos;
import javax.persistence.*;
@Entity
@Table(name="address_tbl")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="adr_id")
	private Integer addressId;
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;
	@Column(length = 20)
	private String country;
	@Column(length = 10,unique = true)
	private String phoneNo;
	//one to one bi dir mapping : owning side (FK : refs PK of students table)
	@OneToOne //mandatory
	@JoinColumn(name="stud_id")
	private Student student;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(String city, String state, String country, String phoneNo) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", phoneNo=" + phoneNo + "]";
	}
	
	

}
