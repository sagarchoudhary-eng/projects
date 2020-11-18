package com.app.pojos;

//Vendor : one , parent , inverse(non owning=> no physical FK col. here)
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendors_tab")
public class Vendor {
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // def strategy = AUTO => native to DB NOw it will auto
														// increment
	private Integer id;
	@Column(length = 30)
	private String name="abc";
	@Column(length = 20, unique = true)
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	@Column(name = "reg_amount", columnDefinition = "double(8,1)")
	private double regAmount;
	// NO temporal annotation should be supplied
	@Column(name = "reg_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate regDate;
	@Enumerated(EnumType.STRING)
	private Role role;
		// one to many
	// mappedBy : required in uni or bi dir or both ? : only in bi dir assocition
	// where ? inverse side
	// what should be the value of mappedBy attribute : name of the asso. property
	// as it apears on the owning side.
	// In order to propagate changes(save/update/delete) from parent (vendor)---->
	// child(bank account)
	// add cascade element in the annotation
	@OneToMany(mappedBy = "acctOwner", cascade = CascadeType.ALL)
	private List<BankAccount> accts = new ArrayList<>();
	//bi-dir one to one mapping between entities : Vendor : inverse side of the asso.
	@OneToOne(mappedBy = "currentVendor",cascade = CascadeType.ALL)
	private Location vendorLocation;
	//uni dir , one-one association between entity(vendor) & value type (composite value type) : embeddable
	@Embedded //OPTIONAL : only for understanding
	private PaymentMode mode;
	//add one -to -many , uni dir asso between Vendor(entity) n collection of basic(built-in) value type
	@ElementCollection /* (fetch = FetchType.EAGER) */ //mandatory , o.w : MappingException
	@CollectionTable(name="phone_numbers",
	joinColumns = @JoinColumn(name="vendor_id")) //optional BUT reco.
	@Column(name="phone_no",length = 10,unique = true)
	private List<String> phoneNumbers=new ArrayList<>();

	// def constr
	public Vendor() {
		// TODO Auto-generated constructor stub
	}

	public Vendor(String name, String email, String password, double regAmount, LocalDate regDate, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	// all getters n setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<BankAccount> getAccts() {
		return accts;
	}

	public void setAccts(List<BankAccount> accts) {
		this.accts = accts;
	}
	

	
	public Location getVendorLocation() {
		return vendorLocation;
	}

	public void setVendorLocation(Location vendorLocation) {
		this.vendorLocation = vendorLocation;
	}
	

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}
	

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	// add helper method to add bank acct ref in Vendor n link vendor ref in bank
	// account
	public void addAccount(BankAccount a) {
		accts.add(a);// linking vendor ---> acct
		a.setAcctOwner(this);// linking acct--> vendor

	}

	// add helper method to remove bank acct ref in Vendor n link vendor ref in bank
	// account
	public void removeAccount(BankAccount a) {
		accts.remove(a);// linking vendor ---> acct
		a.setAcctOwner(null);// linking acct--> vendor

	}
	//add helper method for adding location details in Vendor n vendor details in location
	public void addLocation(Location loc)
	{
		//parent --> child
		this.setVendorLocation(loc);
		//child ---> parent
		loc.setCurrentVendor(this);
	}
	//add helper method for removing location details in Vendor n vendor details in location
		public void removeLocation(Location loc)
		{
			this.setVendorLocation(null);
			loc.setCurrentVendor(null);
		}
	

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", regAmount="
				+ regAmount + ", regDate=" + regDate + ", role=" + role + "]";
	}

}
