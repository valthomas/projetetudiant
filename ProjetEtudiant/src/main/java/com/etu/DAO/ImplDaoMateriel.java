package com.etu.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Materiel;

public class ImplDaoMateriel implements InterDaoMateriel{

	@PersistenceContext
	private EntityManager em;
	
	Logger log= Logger.getLogger(ImplDaoMateriel.class);
	
	@Override
	public Materiel addMateriel(Materiel mat) {
		em.persist(mat);
		log.info(mat.getNomMateriel()+" a ete enregistre");
		return mat;
	}

	@Override
	public Materiel setMateriel(Long idMat, String nomMateriel,
			String etatMateriel) {
		Materiel mat = em.find(Materiel.class,idMat);
		mat.setEtatsMateriel(etatMateriel);
		mat.setNomMateriel(nomMateriel);
		em.merge(mat);
		log.info(mat.getNomMateriel()+" a ete modifie");
		return mat;
	}

	@Override
	public Materiel deleteMateriel(Long idMat) {
		Materiel mat = em.find(Materiel.class,idMat);
		em.remove(mat);
		log.info(mat.getNomMateriel()+" a ete supprime");
		return mat;
	}

	@Override
	public Materiel getMateriel(Long idMateriel) {
		Materiel mat = em.find(Materiel.class,idMateriel);
		log.info(mat.getNomMateriel()+" a ete recuperer");
		return mat;
	}

	@Override
	public List<Materiel> getAllMateriel() {
		Query query= em.createQuery("select m from Materiel m");
		return query.getResultList();
	}

	@Override
	public Materiel addMaterielToEtudiant(Long idMateriel, Long idEtudiant) {
		Materiel mat = em.find(Materiel.class,idMateriel);
		Etudiant e= em.find(Etudiant.class, idEtudiant);
		e.getMateriel().add(mat);
		em.merge(e);
		log.info(mat.getNomMateriel()+" a ete ajoute a l etudiant");
		return mat;
	}

	@Override
	public List<Materiel> getAllMaterielOfOneEtudiant(Long idEtudiant) {
		Etudiant e= em.find(Etudiant.class, idEtudiant);
		List<Materiel> list=e.getMateriel();
		return list;
	}

}
