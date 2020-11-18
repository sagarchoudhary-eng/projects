package pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Embeddable //value type : composite value type (User defined type) : mandatory
public class AdharCard {
	@Column(length = 20,unique = true,name="card_num")
	private String cardNumber;//UID
	@Column(name="created_on")
	private LocalDate creationDate;
	@Column(length = 20)
	private String location;
	public AdharCard() {
		// TODO Auto-generated constructor stub
	}
	public AdharCard(String cardNumber, LocalDate creationDate, String location) {
		super();
		this.cardNumber = cardNumber;
		this.creationDate = creationDate;
		this.location = location;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "AdharCard [cardNumber=" + cardNumber + ", creationDate=" + creationDate + ", location=" + location
				+ "]";
	}
	
	
}
