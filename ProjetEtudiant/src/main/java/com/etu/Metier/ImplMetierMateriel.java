package com.etu.Metier;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.etu.DAO.InterDaoMateriel;
import com.etu.Entities.Materiel;

@Transactional
public class ImplMetierMateriel implements InterMetierMateriel{

	private InterDaoMateriel daoMateriel;

	Logger log= Logger.getLogger(ImplMetierMateriel.class);
	/** setter realisant injection de la dependance  **/
	
	public void setDaoMateriel(InterDaoMateriel daoMateriel) {
		this.daoMateriel = daoMateriel;
		log.info("daoMateriel injected");
	}
	
	
	
	/** methode **/
	@Override
	public Materiel addMateriel(Materiel mat) {
		// TODO Auto-generated method stub
		return daoMateriel.addMateriel(mat);
	}

	

	@Override
	public Materiel setMateriel(Long idMat, String nomMateriel,
			String etatMateriel) {
		// TODO Auto-generated method stub
		return daoMateriel.setMateriel(idMat, nomMateriel, etatMateriel);
	}

	@Override
	public Materiel deleteMateriel(Long idMat) {
		// TODO Auto-generated method stub
		return daoMateriel.deleteMateriel(idMat);
	}

	@Override
	public Materiel getMateriel(Long idMateriel) {
		// TODO Auto-generated method stub
		return daoMateriel.getMateriel(idMateriel);
	}

	@Override
	public List<Materiel> getAllMateriel() {
		// TODO Auto-generated method stub
		return daoMateriel.getAllMateriel();
	}

	@Override
	public Materiel addMaterielToEtudiant(Long idMateriel, Long idEtudiant) {
		// TODO Auto-generated method stub
		return daoMateriel.addMaterielToEtudiant(idMateriel, idEtudiant);
	}

	@Override
	public List<Materiel> getAllMaterielOfOneEtudiant(Long idEtudiant) {
		// TODO Auto-generated method stub
		return daoMateriel.getAllMaterielOfOneEtudiant(idEtudiant);
	}
	
}
