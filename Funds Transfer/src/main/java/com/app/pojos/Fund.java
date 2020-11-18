package com.app.pojos;

//Fund (debt/equity/hybrid) : POJO
//id,name, company , desc , type, quantity, publishDate .
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
@Entity
@Table(name="funds_tbl")
@JsonPropertyOrder(alphabetic = true)//json properties during de serialization will be as per alphabetic order
//@JsonPropertyOrder(value = {"id","name","price"})
public class Fund {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20,unique = true)
	private String name;
	@Column(length = 20)
	private String company;
	@Column(length = 50,name = "fund_desc")
	@JsonProperty("f_desc")
	private String desc;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private FundType type;
	private double price;
	private int quantity;
	@Column(name="pub_date")
//	@JsonFormat(pattern = "d-M-yyyy")
	private LocalDate publishDate;

	public Fund() {
		// TODO Auto-generated constructor stub
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public FundType getType() {
		return type;
	}

	public void setType(FundType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Fund [id=" + id + ", name=" + name + ", company=" + company + ", desc=" + desc + ", type=" + type
				+ ", price=" + price + ", quantity=" + quantity + ", publishDate=" + publishDate + "]";
	}

}
