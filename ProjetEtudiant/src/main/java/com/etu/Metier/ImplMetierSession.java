package com.etu.Metier;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.etu.DAO.InterDaoSession;
import com.etu.Entities.Etudiant;
import com.etu.Entities.Module;
import com.etu.Entities.Session;

@Transactional
public class ImplMetierSession implements InterMetierSession{
	
	private final Logger LOG=Logger.getLogger("ImplMetierSession");
	private InterDaoSession daosession;
	
	//setter
	public void setDaosession(InterDaoSession daosession) {
		this.daosession = daosession;
		LOG.info("*****************************dao session injected*****************************");
	}

	@Override
	public Session addsession(Session s) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode ajouter*****************************");
		return daosession.addsession(s);
	}

	

	@Override
	public void deletesession(Long idSession) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode supprimer*****************************");
		daosession.deletesession(idSession);
	}

	@Override
	public Session updatesession(Session s) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode modifier*****************************");
		return daosession.updatesession(s);
	}

	@Override
	public Session getsession(Long idSession) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode obtenir objet*****************************");
		return daosession.getsession(idSession);
	}

	@Override
	public List<Session> getlistsession() {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode lister*****************************");
		return daosession.getlistsession();
	}

	@Override
	public void addetutosess(Long idEtudiant, Long idSession) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode ajouter etudiant*****************************");
		daosession.addetutosess(idEtudiant, idSession);
	}

	@Override
	public void deleteetutosess(Long idEtudiant, Long idSession) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode supprimer etudiant*****************************");
		daosession.deleteetutosess(idEtudiant, idSession);
	}

	@Override
	public List<Etudiant> getlistetusess(Long idSession) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode lister etudiants*****************************");
		return daosession.getlistetusess(idSession);
	}

	@Override
	public void addmodtosess(Long idModule, Long idSession) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode ajouter module*****************************");
		daosession.addmodtosess(idModule, idSession);
	}

	@Override
	public void deletemodtosess(Long idModule, Long idSession) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode supprimer module*****************************");
		daosession.deletemodtosess(idModule, idSession);
	}

	@Override
	public List<Module> getlistemodsess(Long idSession) {
		// TODO Auto-generated method stub
		LOG.info("*****************************methode lister module*****************************");
		return daosession.getlistemodsess(idSession);
	}

}
