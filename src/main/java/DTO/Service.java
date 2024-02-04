package DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ServiceId;
	private String ServiceName;
	private double ServiceCostPerDay;
	private double ServiveCostPerPerson;
	public int getServiceId() {
		return ServiceId;
	}
	public void setServiceId(int serviceId) {
		ServiceId = serviceId;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public double getServiceCostPerDay() {
		return ServiceCostPerDay;
	}
	public void setServiceCostPerDay(double serviceCostPerDay) {
		ServiceCostPerDay = serviceCostPerDay;
	}
	public double getServiveCostPerPerson() {
		return ServiveCostPerPerson;
	}
	public void setServiveCostPerPerson(double serviveCostPerPerson) {
		ServiveCostPerPerson = serviveCostPerPerson;
	}
	@Override
	public String toString() {
		return "Service [ServiceId=" + ServiceId + ", ServiceName=" + ServiceName + ", ServiceCostPerDay="
				+ ServiceCostPerDay + ", ServiveCostPerPerson=" + ServiveCostPerPerson + "]";
	}
}
