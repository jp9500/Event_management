package DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ClientId;
	private String ClientName;
	private long ClientContact;
	private String ClientMail;
	@OneToMany(cascade = CascadeType.ALL)
	private  List<ClientEvent> ce;
	public int getClientId() {
		return ClientId;
	}
	public void setClientId(int clientId) {
		ClientId = clientId;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public long getClientContact() {
		return ClientContact;
	}
	public void setClientContact(long clientContact) {
		ClientContact = clientContact;
	}
	public String getClientMail() {
		return ClientMail;
	}
	public void setClientMail(String clientMail) {
		ClientMail = clientMail;
	}
	public List<ClientEvent> getCe() {
		return ce;
	}
	public void setCe(List<ClientEvent> ce) {
		this.ce = ce;
	}
	@Override
	public String toString() {
		return "Client [ClientId=" + ClientId + ", ClientName=" + ClientName + ", ClientContact=" + ClientContact
				+ ", ClientMail=" + ClientMail + ", ce=" + ce + "]";
	}
	
	
	
	
}
