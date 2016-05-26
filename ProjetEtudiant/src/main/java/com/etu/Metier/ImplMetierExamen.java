package com.etu.Metier;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.etu.DAO.InterDaoExamen;
import com.etu.Entities.Etudiant;
import com.etu.Entities.Examen;
@Transactional
public class ImplMetierExamen implements InterMetierExamen {

	private Logger log = Logger.getLogger("ImplMetierExamen");
	
	//Dao: déclaration + setter:
	private InterDaoExamen daoExamen;
	
	public void setDaoExamen(InterDaoExamen daoExamen) {
		this.daoExamen = daoExamen;
		log.info("dao Examen injecté");
	}

	@Override
	public Examen addExamen(Examen e) {
		// TODO Auto-generated method stub
		log.info("***********ajout d'un examen***************");
		return daoExamen.addExamen(e);
	}

	@Override
	public Examen updateExamen(Long idExamen) {
		// TODO Auto-generated method stub
		log.info("***********modifier un examen***************");
		return daoExamen.updateExamen(idExamen);
	}

	@Override
	public void delExamen(Long idExamen) {
		// TODO Auto-generated method stub
		daoExamen.delExamen(idExamen);
		log.info("***********examen supprimé***************");
	}

	@Override
	public Examen getExamen(Long idExamen) {
		// TODO Auto-generated method stub
		log.info("***********obtenir un examen***************");
		return daoExamen.getExamen(idExamen);
	}

	@Override
	public List<Examen> getListExamen() {
		// TODO Auto-generated method stub
		log.info("***********obtenir une liste d'examn***************");
		return daoExamen.getListExamen();
	}

	@Override
	public void addEtudiantToExam(Long idEtudiant, Long idExamen) {
		// TODO Auto-generated method stub
		daoExamen.addEtudiantToExam(idEtudiant, idExamen);
		log.info("***********ajout d'un etudiant à un examen***************");

	}

	@Override
	public List<Etudiant> getListEtudiant_Examen(Long idExamen) {
		// TODO Auto-generated method stub
		return daoExamen.getListEtudiant_Examen(idExamen);
	}

}
