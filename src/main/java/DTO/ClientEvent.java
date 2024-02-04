package DTO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ClientEvent 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ClientEventId;
	private int ClientEventNoofPeople;
	private LocalDate startdate;
	private int ClientEventnoofDays;
	private String ClientEventLocation;
	private double ClientEventCost;
	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;
	@OneToMany(cascade = CascadeType.ALL)
	private  List<ClientService> cs;
	private  EventType et;
	
	
	public int getClientEventId() {
		return ClientEventId;
	}
	public void setClientEventId(int clientEventId) {
		ClientEventId = clientEventId;
	}
	public int getClientEventNoofPeople() {
		return ClientEventNoofPeople;
	}
	public void setClientEventNoofPeople(int clientEventNoofPeople) {
		ClientEventNoofPeople = clientEventNoofPeople;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public int getClientEventnoofDays() {
		return ClientEventnoofDays;
	}
	public void setClientEventnoofDays(int clientEventnoofDays) {
		ClientEventnoofDays = clientEventnoofDays;
	}
	public String getClientEventLocation() {
		return ClientEventLocation;
	}
	public void setClientEventLocation(String clientEventLocation) {
		ClientEventLocation = clientEventLocation;
	}
	public double getClientEventCost() {
		return ClientEventCost;
	}
	public void setClientEventCost(double clientEventCost) {
		ClientEventCost = clientEventCost;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<ClientService> getCs() {
		return cs;
	}
	public void setCs(List<ClientService> cs) {
		this.cs = cs;
	}
	public EventType getEt() {
		return et;
	}
	public void setEt(EventType et) {
		this.et = et;
	}
	@Override
	public String toString() {
		return "ClientEvent [ClientEventId=" + ClientEventId + ", ClientEventNoofPeople=" + ClientEventNoofPeople
				+ ", startdate=" + startdate + ", ClientEventnoofDays=" + ClientEventnoofDays + ", ClientEventLocation="
				+ ClientEventLocation + ", ClientEventCost=" + ClientEventCost + ", cs=" + cs
				+ ", et=" + et + "]";
	}

	

}
