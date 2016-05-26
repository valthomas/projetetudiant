package com.etu.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.etu.Entities.Salle;
import com.etu.Entities.Session;

public class ImplDaoSalle implements  InterDaoSalle{

	@PersistenceContext
	private EntityManager em;
	
	Logger log= Logger.getLogger(ImplDaoSalle.class);
	
	@Override
	public Salle addSalle(Salle salle) {
		em.persist(salle);
		log.info(salle.getNomSalle()+" a ete enregistre");
		return salle;
	}

	@Override
	public Salle setSalle(Salle salle,String adresseSalle, Integer capacite,String nomSalle) {
		salle.setAdresseSalle(adresseSalle);
		salle.setCapaciteSalle(capacite);
		salle.setNomSalle(nomSalle);
		em.merge(salle);
		log.info(salle.getNomSalle()+" a ete modifie");
		return salle;
	}

	@Override
	public Salle DeleteSalle(Long idSalle) {
		Salle s= em.find(Salle.class,idSalle);
		em.remove(s);
		log.info(s.getNomSalle()+" a ete supprime");
		return s;
	}

	@Override
	public Salle addSalleToSession(Long idSalle, Long idSession) {
		Salle s= em.find(Salle.class,idSalle);
		Session session= em.find(Session.class,idSession);
		s.getListesessions().add(session);
		em.merge(s);
		em.merge(session);
		log.info(s.getNomSalle()+" a ete ajoute a session");
		return s;
	}

	@Override
	public Salle deleteSalleToSession(Long idSalle, Long idSession) {
		Salle s= em.find(Salle.class,idSalle);
		Session session= em.find(Session.class,idSession);
		session.setSalle(null);
		em.remove(s);
		em.merge(session);
		log.info(s.getNomSalle()+" a ete supprimer de session");
		return s;
	}

	@Override
	public List<Salle> getAllSalle() {
		Query query= em.createQuery("select s from Salle s");
		return query.getResultList();
	}

	
}
