package com.etu.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.etu.Entities.Module;

public class ImplDaoModule implements InterDaoModule{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Module addmodule(Module m) {
		// TODO Auto-generated method stub
		em.persist(m);
		return m;
	}

	@Override
	public void deletemodule(Long idModule) {
		// TODO Auto-generated method stub
		Module m = em.find(Module.class,idModule);
		em.remove(m);
		
	}

	@Override
	public Module updatemodule(Module m) {
		// TODO Auto-generated method stub
		em.merge(m);
		return m;
	}

	@Override
	public Module getmodule(Long idModule) {
		// TODO Auto-generated method stub
		Module m = em.find(Module.class,idModule);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getlistmodule() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Module m");
		return query.getResultList();
	}

}
