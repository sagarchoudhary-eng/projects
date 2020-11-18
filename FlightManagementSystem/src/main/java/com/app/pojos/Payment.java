package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer cardNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expDate;
	private String name;
	private int cvv;
	
	@OneToOne
	@JoinColumn(name = "pass_id")
	private Passenger CurrPassanger;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Integer cardNumber,String name, LocalDate expDate, int cvv) {
		super();
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cvv = cvv;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passenger getCurrPassanger() {
		return CurrPassanger;
	}

	public void setCurrPassanger(Passenger currPassanger) {
		CurrPassanger = currPassanger;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Payment [cardNumber=" + cardNumber + ", expDate=" + expDate + ", cvv=" + cvv + "]";
	}
	
	
}
