package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import DTO.ClientService;

public class ClientServicedao 
{
	public EntityManager getem()
	{
		EntityManagerFactory  emf= Persistence.createEntityManagerFactory("jp");
		return emf.createEntityManager();
	}
	public ClientService saveClientService(ClientService cs)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(cs);
		et.commit();
		
		return cs;
	}
	
	public ClientService findClientService(int id)
	{
		EntityManager em=getem();
		
		ClientService cs=em.find(ClientService.class, id);
		if(cs != null)
		{
			return cs;
		}
		else {
			return null;
		}
	}
	
	public ClientService deleteClientService(int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		ClientService cs=em.find(ClientService.class, id);
		if(cs != null)
		{
			et.begin();
			em.remove(cs);
			et.commit();
			return cs;
		}
		else {
			return null;
		}
	}
	public ClientService updateClientService(ClientService cs,int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		ClientService cs1=em.find(ClientService.class, id);
		if(cs1 != null)
		{
			cs.setClientServiceId(id);
			et.begin();
			em.merge(cs);
			et.commit();
		
		return cs;
		}else{
			return null;
		}
	}

}
