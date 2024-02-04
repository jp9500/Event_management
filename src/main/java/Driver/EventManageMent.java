package Driver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DAO.Admindao;
import DAO.ClientEventDao;
import DAO.ClientServicedao;
import DAO.Clientdao;
import DAO.Servicedao;
import DTO.Admin;
import DTO.Client;
import DTO.ClientEvent;
import DTO.ClientService;
import DTO.EventType;
import DTO.Service;

public class EventManageMent 
{
	Admindao ad=new Admindao();
	Clientdao cd=new Clientdao();
	Servicedao sd=new Servicedao();
	ClientEventDao ced=new ClientEventDao();
	ClientServicedao csd = new ClientServicedao();
	
	public static void main(String[] args) 
	{
		EventManageMent em =new EventManageMent();
		System.out.println(em.removeEventService());
	}
	
	public Admin saveAdmin() {
		Admin a = new Admin();
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter the name");
		a.setAdminName(sc1.next());
		System.out.println("Enter the Admin Email");
		a.setAdminEmail(sc1.next());
		System.out.println("Enter the Admin Password");
		a.setAdminPass(sc1.next());
		System.out.println("Enter the Contact Number");
		a.setAdminContact(sc1.nextLong());
		sc1.close();
		
		return ad.saveAdmin(a);
	}
	
	public Admin AdminLogin(){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the email");
		String email=sc.next();
		System.out.println("enter the Password");
		String pass=sc.next();
		
		EntityManager em=ad.getem();
		Query query =em.createQuery("select a from Admin a where a.AdminEmail=?1");
		query.setParameter(1, email);
		
		Admin exAdmin=(Admin) query.getSingleResult();
		if(exAdmin != null) {
			if(exAdmin.getAdminPass().equals(pass)) {
				return exAdmin;
			}
			return null;
		}return null;
	}
	
	public Service saveService() {
		Admin exAdmin = AdminLogin();
		if(exAdmin != null) {
			Service s= new Service();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the service name");
			s.setServiceName(sc.next());
			System.out.println("enter the service cost per person");
			s.setServiveCostPerPerson(sc.nextDouble());
			System.out.println("enter the service cost per day");
			s.setServiceCostPerDay(sc.nextDouble());
			
			Service savedService=sd.saveService(s);
			exAdmin.getServices().add(savedService);
			ad.updateAdmin(exAdmin, exAdmin.getAdminid());
			
			return s;
		}return null;
	}
	
	public List<Service> getAllServices(){
		System.out.println("enter admin credentials to proceed");
		Admin exadmin=AdminLogin();
		if(exadmin!=null) {
			EntityManager em=ad.getem();
			Query query =em.createQuery("select a from Service a");
			List<Service>services=query.getResultList();
			return services;
		}
		return null;
	}
	
	public String updateService() {
		Scanner sc=new Scanner(System.in);
		List<Service> service=getAllServices();
		for(Service s: service) {
			System.out.println("service id   "+"Service name  "+"cost_per_person   "+"cost_per_day   ");
			System.out.println("      "+s.getServiceId()+"       "+s.getServiceName()+"        "+s.getServiveCostPerPerson()+"     "+s.getServiceCostPerDay());
			
		}
		System.out.println("choose service id from above to update");
		System.out.println("enter id from above data");
		int id=sc.nextInt();
		Service tobeupdated=sd.findService(id);
		System.out.println("enter Updated cost per person");
		double cost_per_person=sc.nextDouble();
		System.out.println("enter cost per day");
		double cost_per_Day=sc.nextDouble();
		tobeupdated.setServiceCostPerDay(cost_per_Day);
		tobeupdated.setServiveCostPerPerson(cost_per_person);
		Service updated=sd.updateService(tobeupdated, id);
		if(updated!=null) {
			return "service update Succees";
		}
		else {
			return "invalid service id";
		}
	}
	
	public Service deleteService() {
		Admin exadmin=AdminLogin();
		Scanner sc=new Scanner(System.in);
		
		if(exadmin!=null) {
			
			List<Service> service=getAllServices();
			for(Service s: service) {
				System.out.println("service id   "+"Service name  "+"cost_per_person   "+"cost_per_day   ");
				System.out.println("      "+s.getServiceId()+"       "+s.getServiceName()+"        "+s.getServiveCostPerPerson()+"     "+s.getServiceCostPerDay());
				
			}
			System.out.println(" choose service id from above to Delete ");
			
			System.out.println("enter id from above data");
			int id=sc.nextInt();
			
			List<Service>newlist=new ArrayList<Service>();
			for(Service s: service) {
				if(s.getServiceId()!=id) {
					newlist.add(s);
				}
			}
			
		
			exadmin.setServices(newlist);
			ad.updateAdmin(exadmin, exadmin.getAdminid());
     	 sd.deleteService(id);
		
		}
		return null;
		}
	
	public Client saveClient() {
		Client client=new Client();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter client name");
		client.setClientName(sc.next());
		
		System.out.println("enter client mail");
		client.setClientMail(sc.next());
	
		
		System.out.println("enter client Contact");
	    client.setClientContact(sc.nextLong());
		
		 return cd.saveClient(client);
	}
	
	public Client clientLogin() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter client mail");
		String clientMail=sc.next();
		
		Query query=Persistence.createEntityManagerFactory("jp").createEntityManager().createQuery("select a from Client a where ClientMail=?1");
		query.setParameter(1, clientMail);
		
		Client exclient=(Client)query.getSingleResult();
		
		if(exclient!=null) {
			if(exclient.getClientMail().equals(clientMail)) {
				return  exclient;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public ClientEvent clientCreateEvent() {
		
		Client exClient=clientLogin();
		if(exClient != null) 
		{
		ClientEvent clientevent=new ClientEvent();
		
		System.out.println("choose the event");
		EventType et[]=EventType.values();
		int i=1;
		for(EventType et2 : et) {
			System.out.println((i++)+" . "+et2);
		}
		
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		if(x==1) {
			clientevent.setEt(EventType.Marriage);
		}
		else if(x==2) {
			clientevent.setEt(EventType.Engagement);
		}
		else if(x==3) {
			clientevent.setEt(EventType.Birthday);
		}
		else if(x==4) {
			clientevent.setEt(EventType.Anniversary);
		}
		else if(x==5) {
			clientevent.setEt(EventType.Babyshower);
		}
		else if(x==6) {
			clientevent.setEt(EventType.Reunion);
		}
		else if(x==7) {
			clientevent.setEt(EventType.NamingCeremony);
		}
		else if(x==8) {
			clientevent.setEt(EventType.BachelorParty);
		}
		System.out.println("How many of them will come and attend the function ?");
		clientevent.setClientEventNoofPeople(sc.nextInt());
		System.out.println("Enter the year");
		int year = sc.nextInt();
		System.out.println("Enter the month");
		int mon = sc.nextInt();
		System.out.println("Enter the date");
		int day = sc.nextInt();
	    clientevent.setStartdate(LocalDate.of(year, mon, day));
		System.out.println("Tell how many days  will the function take ?");
		clientevent.setClientEventnoofDays(sc.nextInt());
		System.out.println("Tell me location where the function will be start ?");
		clientevent.setClientEventLocation(sc.next());
		System.out.println("Tell me the budget you estimated for this function ?");
		clientevent.setClientEventCost(sc.nextDouble());
		
		ClientEvent sce=ced.saveClientEvent(clientevent);
		clientevent.setClient(exClient);
		exClient.getCe().add(sce);
		cd.updateClient(exClient, exClient.getClientId());
		
		List<Service> services =getAllServices();
		for(Service s : services) {
			System.out.println("Service id : "+s.getServiceId()+"\nService Name : "+s.getServiceName()+
			"\nServiceCostPerPerson : "+s.getServiveCostPerPerson()+"\nServiceCostPerDay : "+s.getServiceCostPerDay());
			System.out.println();
		}
		System.out.println("how many services you want");
		int noServices=sc.nextInt();
		List<ClientService> listServices = new ArrayList<ClientService>();
		for(int j=1;j<=noServices;j++) 
		{
			System.out.println("Enter id for Service "+j+":");
			int id=sc.nextInt();
			Service ser=sd.findService(id);
			ClientService cs=new ClientService();
			cs.setClientServiceNAme(ser.getServiceName());
			cs.setClientServiceCostPerPerson(ser.getServiveCostPerPerson());
			cs.setClientServiceNoOfdays(clientevent.getClientEventnoofDays());
			cs.setClientServiceCost(ser.getServiceCostPerDay());
			double TotalCostofAllPeople=clientevent.getClientEventNoofPeople()*ser.getServiveCostPerPerson();
			double totalCostofAllDays=clientevent.getClientEventnoofDays()*ser.getServiceCostPerDay();
			cs.setClientServiceCost(TotalCostofAllPeople + totalCostofAllDays);
			listServices.add(cs);
			csd.saveClientService(cs);
			double ClientEventCost=clientevent.getClientEventCost()+cs.getClientServiceCost();
			clientevent.setCs(listServices);
			
			clientevent.setClientEventCost(ClientEventCost);
			ced.updateClientEvent(clientevent, clientevent.getClientEventId());
		}
		return clientevent;
		}else {
		return null;
		}
	}

	public ClientService removeEventService()
	{
		Client client =clientLogin();
		if(client != null)
		{
			EntityManager em=ad.getem();
			Query query = em.createQuery("select ce from ClientEvent ce");
			List<ClientEvent> clientEvents = (List<ClientEvent>) query.getResultList();
			for(ClientEvent ce : clientEvents)
			{
				System.out.println(ce.getClient());
				if(ce.getClient().getClientId() == client.getClientId())
				{
					List<ClientService> clientServices = (List<ClientService>) ce.getCs();
					System.out.println("ServiceId 		"+" 	ServiceName");
					for(ClientService cs : clientServices)
					{
						System.out.println(" 		"+cs.getClientServiceId()+"			"+cs.getClientServiceNAme());
					}
					Scanner sc=new Scanner(System.in);
					int id = sc.nextInt();
					for(ClientService cs : clientServices)
					{
						if(cs.getClientServiceId() == id)
						{
							clientServices.remove(cs);
							ce.setCs(clientServices);
							
							double clientEventCost=0;
							for(ClientService csr : clientServices) {
								clientEventCost += csr.getClientServiceCost();
							}
							ce.setClientEventCost(clientEventCost);
							ced.updateClientEvent(ce, ce.getClientEventId());
							
							ClientService deleted =csd.deleteClientService(cs.getClientServiceId());
							if(deleted != null)
							{
								System.out.println("service removed successfully..!");
							}
							else
								System.out.println("service removed failed..!");
							return deleted;
						}
					}
				}
			}
		}
		return null;
	}
}