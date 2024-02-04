package DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Adminid;
	private String AdminName;
	private String AdminEmail;
	private String AdminPass;
	private long AdminContact;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Service> services;

	public int getAdminid() {
		return Adminid;
	}

	public void setAdminid(int adminid) {
		Adminid = adminid;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getAdminEmail() {
		return AdminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		AdminEmail = adminEmail;
	}

	public String getAdminPass() {
		return AdminPass;
	}

	public void setAdminPass(String adminPass) {
		AdminPass = adminPass;
	}

	public long getAdminContact() {
		return AdminContact;
	}

	public void setAdminContact(long adminContact) {
		AdminContact = adminContact;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Admin [Adminid=" + Adminid + ", AdminName=" + AdminName + ", AdminEmail=" + AdminEmail + ", AdminPass="
				+ AdminPass + ", AdminContact=" + AdminContact + ", services=" + services + "]";
	}
	
	

}
