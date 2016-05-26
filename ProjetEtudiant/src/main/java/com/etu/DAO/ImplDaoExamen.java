package com.etu.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Examen;

public class ImplDaoExamen implements InterDaoExamen {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Examen addExamen(Examen e) {
		// TODO Auto-generated method stub
		em.persist(e);
		return e;
	}

	@Override
	public Examen updateExamen(Long idExamen) {
		// TODO Auto-generated method stub
		
		Examen e = em.find(Examen.class, idExamen);
		em.merge(e);
		return e;
	}

	@Override
	public void delExamen(Long idExamen) {
		// TODO Auto-generated method stub
		Examen e = em.find(Examen.class, idExamen);
		em.remove(e);
	}

	@Override
	public Examen getExamen(Long idExamen) {
		// TODO Auto-generated method stub
		Examen e = em.find(Examen.class, idExamen);
		return e;
	}

	@Override
	public List<Examen> getListExamen() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Examen");
		return query.getResultList();
	}

	@Override
	public void addEtudiantToExam(Long idEtudiant, Long idExamen) {
		// TODO Auto-generated method stub
		Examen exa = em.find(Examen.class, idExamen);
		Etudiant etu = em.find(Etudiant.class, idEtudiant);
		
	etu.getExamen().add(exa);
	exa.setEtudiant(etu);
		/*em.merge(etu);
		em.merge(exa);*/
		
		
	}

	@Override
	public List<Etudiant> getListEtudiant_Examen(Long idExamen) {
		// TODO Auto-generated method stub
		
		Query req = em.createQuery("select e.etudiant from Examen e");
		return req.getResultList();
	}

}
