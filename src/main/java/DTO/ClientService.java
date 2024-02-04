package DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClientService 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ClientServiceId;
	private String ClientServiceNAme;
	private double ClientServiceCostPerPerson;
	private int ClientServiceNoOfdays;
	private double ClientServiceCost;
	public int getClientServiceId() {
		return ClientServiceId;
	}
	public void setClientServiceId(int clientServiceId) {
		ClientServiceId = clientServiceId;
	}
	public String getClientServiceNAme() {
		return ClientServiceNAme;
	}
	public void setClientServiceNAme(String clientServiceNAme) {
		ClientServiceNAme = clientServiceNAme;
	}
	public double getClientServiceCostPerPerson() {
		return ClientServiceCostPerPerson;
	}
	public void setClientServiceCostPerPerson(double clientServiceCostPerPerson) {
		ClientServiceCostPerPerson = clientServiceCostPerPerson;
	}
	public int getClientServiceNoOfdays() {
		return ClientServiceNoOfdays;
	}
	public void setClientServiceNoOfdays(int clientServiceNoOfdays) {
		ClientServiceNoOfdays = clientServiceNoOfdays;
	}
	public double getClientServiceCost() {
		return ClientServiceCost;
	}
	public void setClientServiceCost(double clientServiceCost) {
		ClientServiceCost = clientServiceCost;
	}
	@Override
	public String toString() {
		return "ClientService [ClientServiceId=" + ClientServiceId + ", ClientServiceNAme=" + ClientServiceNAme
				+ ", ClientServiceCostPerPerson=" + ClientServiceCostPerPerson + ", ClientServiceNoOfdays="
				+ ClientServiceNoOfdays + ", ClientServiceCost=" + ClientServiceCost + "]";
	}
	
	

}
