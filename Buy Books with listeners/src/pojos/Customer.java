package pojos;
//id | deposit_amt | email          | name    | password | reg_date   | role

import java.sql.Date;

public class Customer {
	private int custId;
	private double depositAmount;
	private String email, name, password;
	private Date regDate;
	private String role;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(int custId, double depositAmount, String email, String name, String password, Date regDate,
			String role) {
		super();
		this.custId = custId;
		this.depositAmount = depositAmount;
		this.email = email;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
		this.role = role;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", depositAmount=" + depositAmount + ", email=" + email + ", name=" + name
				+ ", password=" + password + ", regDate=" + regDate + ", role=" + role + "]";
	}
	
	
}
