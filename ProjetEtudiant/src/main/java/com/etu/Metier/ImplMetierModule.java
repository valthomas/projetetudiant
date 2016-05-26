package com.etu.Metier;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.etu.DAO.InterDaoModule;
import com.etu.Entities.Module;

@Transactional
public class ImplMetierModule implements InterMetierModule{
	
	private final Logger LOG=Logger.getLogger("ImplMetierModule");
	private InterDaoModule daomodule;
	
	//setter
	public void setDaomodule(InterDaoModule daomodule) {
		this.daomodule = daomodule;
		LOG.info("*****************************dao module injected*****************************");
	}

	@Override
	public Module addmodule(Module m) {
		// TODO Auto-generated method stub
		return daomodule.addmodule(m);
	}

	@Override
	public void deletemodule(Long idModule) {
		// TODO Auto-generated method stub
		daomodule.deletemodule(idModule);
		
	}

	@Override
	public Module updatemodule(Module m) {
		// TODO Auto-generated method stub
		return daomodule.updatemodule(m);
	}

	@Override
	public Module getmodule(Long idModule) {
		// TODO Auto-generated method stub
		return daomodule.getmodule(idModule);
	}

	@Override
	public List<Module> getlistmodule() {
		// TODO Auto-generated method stub
		return daomodule.getlistmodule();
	}

}
