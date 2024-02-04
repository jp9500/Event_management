package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.Service;

public class Servicedao 
{
	public EntityManager getem()
	{
		EntityManagerFactory  emf= Persistence.createEntityManagerFactory("jp");
		return emf.createEntityManager();
	}
	public Service saveService(Service s)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
		
		return s;
	}
	
	public Service findService(int id)
	{
		EntityManager em=getem();
		
		Service s=em.find(Service.class, id);
		if(s != null)
		{
			return s;
		}
		else {
			return null;
		}
	}
	
	public Service deleteService(int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		Service s=em.find(Service.class, id);
		if(s != null)
		{
			et.begin();
			em.remove(s);
			et.commit();
			return s;
		}
		else {
			return null;
		}
	}
	public Service updateService(Service s,int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		Service s1=em.find(Service.class, id);
		if(s1 != null)
		{
			s.setServiceId(id);
			et.begin();
			em.merge(s);
			et.commit();
		
		return s;
		}else{
			return null;
		}
	}

}
