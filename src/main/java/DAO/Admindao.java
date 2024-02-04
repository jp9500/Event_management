package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.Admin;

public class Admindao 
{
	public EntityManager getem()
	{
		EntityManagerFactory  emf= Persistence.createEntityManagerFactory("jp");
		return emf.createEntityManager();
	}
	public Admin saveAdmin(Admin a)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(a);
		et.commit();
		
		return a;
	}
	
	public Admin findAdmin(int id)
	{
		EntityManager em=getem();
		
		Admin a=em.find(Admin.class, id);
		if(a != null)
		{
			return a;
		}
		else {
			return null;
		}
	}
	
	public Admin deleteAdmin(int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		Admin a=em.find(Admin.class, id);
		if(a != null)
		{
			et.begin();
			em.remove(a);
			et.commit();
			return a;
		}
		else {
			return null;
		}
	}
	public Admin updateAdmin(Admin a,int id)
	{
		EntityManager em=getem();
		EntityTransaction et=em.getTransaction();
		
		Admin a1=em.find(Admin.class, id);
		if(a1 != null)
		{
			a.setAdminid(id);
			et.begin();
			em.merge(a);
			et.commit();
		
		return a;
		}else{
			return null;
		}
	}
}
