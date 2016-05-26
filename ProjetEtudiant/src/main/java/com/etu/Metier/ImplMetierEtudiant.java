package com.etu.Metier;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.etu.DAO.InterDaoEtudiant;
import com.etu.Entities.Etudiant;
@Transactional
public class ImplMetierEtudiant implements InterMetierEtudiant {

	private Logger log=Logger.getLogger("ImplMetierExamen");
	
	//Dao: déclaration + setter:
	private InterDaoEtudiant daoEtudiant;

	public void setDaoEtudiant(InterDaoEtudiant daoEtudiant) {
		this.daoEtudiant = daoEtudiant;
		log.info("dao Etudiant injecté");
	}

	@Override
	public Etudiant addEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		log.info("***********ajout d'un etudiant***************");
		return daoEtudiant.addEtudiant(e);
	}

	@Override
	public Etudiant updateEtudiant(Long idEtudiant) {
		// TODO Auto-generated method stub
		log.info("***********modifier d'un etudiant***************");
		return daoEtudiant.updateEtudiant(idEtudiant);
	}

	@Override
	public void delEtudiant(Long idEtudiant) {
		// TODO Auto-generated method stub
		daoEtudiant.delEtudiant(idEtudiant);
		log.info("***********etudiant supprimé***************");
	}

	@Override
	public Etudiant getEtudiant(Long idEtudiant) {
		// TODO Auto-generated method stub
		log.info("***********obtenir un étudiant***************");
		return daoEtudiant.getEtudiant(idEtudiant);
	}

	@Override
	public List<Etudiant> getListEtudiant() {
		// TODO Auto-generated method stub
		log.info("***********obtenir une liste d'etudiant***************");
		return daoEtudiant.getListEtudiant();
	}

}
