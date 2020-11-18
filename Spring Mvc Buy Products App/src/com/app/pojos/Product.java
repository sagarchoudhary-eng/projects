package com.app.pojos;
//name=pen&category=stationary&price=50.5&qty=3&creation_date=2020/10/25"

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="products_tbl")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="p_id")
	private Integer productId;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String category;
	private double price;
	@Column(name="creation_date")
	private LocalDate creationDate;
	private int quantity;
	public Product() {
		System.out.println("in product constr");
	}
	public Product(String name, String category, double price, LocalDate creationDate, int quantity) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.creationDate = creationDate;
		this.quantity = quantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", creationDate=" + creationDate + ", quantity=" + quantity + "]";
	}
	

}
