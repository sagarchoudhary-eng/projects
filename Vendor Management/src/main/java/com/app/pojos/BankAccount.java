package com.app.pojos;
import javax.persistence.*;

//BankAccount : many side, child , owning(since it will contain FK column)
@Entity
@Table(name ="bank_accounts")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acct_id")
	private Integer acctId;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private AcType type;
	private double balance;
	//many to one 
	@ManyToOne
	@JoinColumn(name="vendor_id") //To replace hibenrate generated FK col name by our own
	private Vendor acctOwner;
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	public BankAccount(AcType type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}
	//all setters n getters
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	public AcType getType() {
		return type;
	}
	public void setType(AcType type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Vendor getAcctOwner() {
		return acctOwner;
	}
	public void setAcctOwner(Vendor acctOwner) {
		this.acctOwner = acctOwner;
	}
	@Override
	public String toString() {
		return "BankAccount [acctId=" + acctId + ", type=" + type + ", balance=" + balance + "]";
	}
	
}
