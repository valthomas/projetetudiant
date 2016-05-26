package com.etu.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.etu.Entities.Etudiant;
@Transactional
public class ImplDaoEtudiant implements InterDaoEtudiant {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Etudiant addEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		em.persist(e);
		return e;
	}

	@Override
	public Etudiant updateEtudiant(Long idEtudiant) {
		// TODO Auto-generated method stub
		Etudiant e = em.find(Etudiant.class, idEtudiant);
		em.merge(e);
		return e;
	}

	@Override
	public void delEtudiant(Long idEtudiant) {
		// TODO Auto-generated method stub
		Etudiant e = em.find(Etudiant.class, idEtudiant);
		em.remove(e);
	}

	@Override
	public Etudiant getEtudiant(Long idEtudiant) {
		// TODO Auto-generated method stub
		Etudiant e = em.find(Etudiant.class, idEtudiant);
		return e;
	}

	@Override
	public List<Etudiant> getListEtudiant() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Etudiant");
		return query.getResultList();
	}

}
