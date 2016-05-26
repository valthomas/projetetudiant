package com.etu.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Module;
import com.etu.Entities.Session;

public class ImplDaoSession implements InterDaoSession{

@PersistenceContext
private EntityManager em;

	@Override
	public Session addsession(Session s) {
		// TODO Auto-generated method stub
		em.persist(s);
		return s;
	}

	@Override
	public void deletesession(Long idSession) {
		// TODO Auto-generated method stub
		Session s = em.find(Session.class, idSession);
		em.remove(s);
		
	}

	@Override
	public Session updatesession(Session s) {
		// TODO Auto-generated method stub
		em.merge(s);
		return s;
	}

	@Override
	public Session getsession(Long idSession) {
		// TODO Auto-generated method stub
		Session s = em.find(Session.class, idSession);
		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> getlistsession() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Session s");
		return query.getResultList();
	}

	@Override
	public void addetutosess(Long idEtudiant, Long idSession) {
		// TODO Auto-generated method stub
		Session s = em.find(Session.class, idSession);
		Etudiant e = em.find(Etudiant.class, idEtudiant);
		s.getListeetudiants().add(e);
		
	}

	@Override
	public void deleteetutosess(Long idEtudiant, Long idSession) {
		// TODO Auto-generated method stub
		Session s = em.find(Session.class, idSession);
		Etudiant e = em.find(Etudiant.class, idEtudiant);
		s.getListeetudiants().remove(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getlistetusess(Long idSession) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select s.listeetudiants from Session s where s.idSession= :x");
		query.setParameter("x", idSession);
		return query.getResultList();
	}

	@Override
	public void addmodtosess(Long idModule, Long idSession) {
		// TODO Auto-generated method stub
		Module m = em.find(Module.class, idModule);
		Session s = em.find(Session.class, idSession);
		s.getListemodules().add(m);
		
	}

	@Override
	public void deletemodtosess(Long idModule, Long idSession) {
		// TODO Auto-generated method stub
		Session s = em.find(Session.class, idSession);
		Module m = em.find(Module.class, idModule);
		s.getListemodules().remove(m);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getlistemodsess(Long idSession) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select s.getListemodules from Session s where s.idSession= :x");
		query.setParameter("x", idSession);
		return query.getResultList();
	}

}
