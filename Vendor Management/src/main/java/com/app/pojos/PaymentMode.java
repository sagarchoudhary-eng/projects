package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * PaymentMode : type(Enum : CREDIT_CARD,DEBIT_CARD,NETBANKING), 
 * amount (double) , paymentDate (LocalDate)
 */
@Embeddable
public class PaymentMode {
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private PaymentType type;
	private double amount;
	@Column(name="payment_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	public PaymentMode() {
		// TODO Auto-generated constructor stub
	}
	public PaymentMode(PaymentType type, double amount, LocalDate paymentDate) {
		super();
		this.type = type;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	public PaymentType getType() {
		return type;
	}
	public void setType(PaymentType type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "PaymentMode [type=" + type + ", amount=" + amount + ", paymentDate=" + paymentDate + "]";
	}
	
	
}
