package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.Client;

public class Clientdao 
{
	public EntityManager getem()
	{
		EntityManagerFactory  emf= Persistence.createEntityManagerFactory("jp");
		return emf.createEntityManager();
	}
	public Client saveClient(Client c)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(c);
		et.commit();
		
		return c;
	}
	
	public Client findClient(int id)
	{
		EntityManager em=getem();
		
		Client c=em.find(Client.class, id);
		if(c != null)
		{
			return c;
		}
		else {
			return null;
		}
	}
	
	public Client deleteClient(int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		Client c=em.find(Client.class, id);
		if(c != null)
		{
			et.begin();
			em.remove(c);
			et.commit();
			return c;
		}
		else {
			return null;
		}
	}
	public Client updateClient(Client c,int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		Client c1=em.find(Client.class, id);
		if(c1 != null)
		{
			c.setClientId(id);
			et.begin();
			em.merge(c);
			et.commit();
		
		return c;
		}else{
			return null;
		}
	}
}
