package com.etu.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.etu.Entities.Module;

public class ImplDaoModule implements InterDaoModule{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Module addmodule(Module m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletemodule(Long idModule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Module updatemodule(Long idModule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module getmodule(Long idModule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Module> getlistmodule() {
		// TODO Auto-generated method stub
		return null;
	}

}
