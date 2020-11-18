package com.app.pojos;

import java.time.LocalDate;

public class Product {
	private Integer id;
	private String name;
	private double price;
	private LocalDate expDate;
	private Product() {
		System.out.println("in product const");
	}
	public Product(Integer id, String name, double price, LocalDate expDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.expDate = expDate;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", expDate=" + expDate + "]";
	}
	
	
}
