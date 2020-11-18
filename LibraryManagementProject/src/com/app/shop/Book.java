package com.app.shop;

import java.time.LocalDate;
import java.util.Scanner;

import com.app.shop.Author;

public class Book {
	private String title;
	private Author authors;
	private int price;
	private LocalDate publishDate;
	private int quantity;
	private int rating;
	private Category genre ;

	public Book(String title,int price, LocalDate publishDate, int quantity, int rating,Category genre) {
		super();
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
		this.quantity = quantity;
		this.rating = rating;
		this.genre = genre ;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", publishDate=" + publishDate
				+ ", quantity=" + quantity + ", rating=" + rating + "author"+authors+"Category "+genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthors() {
		return authors;
	}

	public void setAuthors(Author authors) {
		this.authors = authors;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
