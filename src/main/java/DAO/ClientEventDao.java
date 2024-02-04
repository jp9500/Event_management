package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.ClientEvent;

public class ClientEventDao {
	
	public EntityManager getem()
	{
		EntityManagerFactory  emf= Persistence.createEntityManagerFactory("jp");
		return emf.createEntityManager();
	}
	public ClientEvent saveClientEvent(ClientEvent ce)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(ce);
		et.commit();
		
		return ce;
	}
	
	public ClientEvent findClientEvent(int id)
	{
		EntityManager em=getem();
		
		ClientEvent ce=em.find(ClientEvent.class, id);
		if(ce != null)
		{
			return ce;
		}
		else {
			return null;
		}
	}
	
	public ClientEvent deleteClientEvent(int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		ClientEvent ce=em.find(ClientEvent.class, id);
		if(ce != null)
		{
			et.begin();
			em.remove(ce);
			et.commit();
			return ce;
		}
		else {
			return null;
		}
	}
	public ClientEvent updateClientEvent(ClientEvent ce,int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		ClientEvent ce1=em.find(ClientEvent.class, id);
		if(ce1 != null)
		{
			ce.setClientEventId(id);
			et.begin();
			em.merge(ce);
			et.commit();
		
		return ce;
		}else{
			return null;
		}
	}
}
