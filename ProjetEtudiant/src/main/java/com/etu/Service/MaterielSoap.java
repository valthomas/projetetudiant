package com.etu.Service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.etu.Entities.Materiel;
import com.etu.Metier.InterMetierMateriel;

@WebService
public class MaterielSoap {

	@Autowired
	private InterMetierMateriel metierMateriel;
	
	
	@WebMethod
	public Materiel addMateriel(Materiel mat) {
		// TODO Auto-generated method stub
		return metierMateriel.addMateriel(mat);
	}

	@WebMethod
	public Materiel setMateriel(@WebParam Long idMat, @WebParam String nomMateriel,
			@WebParam	String etatMateriel) {
		// TODO Auto-generated method stub
		return metierMateriel.setMateriel(idMat, nomMateriel, etatMateriel);
	}

	@WebMethod
	public Materiel deleteMateriel(@WebParam Long idMat) {
		// TODO Auto-generated method stub
		return metierMateriel.deleteMateriel(idMat);
	}

	@WebMethod
	public Materiel getMateriel(@WebParam Long idMateriel) {
		// TODO Auto-generated method stub
		return metierMateriel.getMateriel(idMateriel);
	}

	@WebMethod
	public List<Materiel> getAllMateriel() {
		// TODO Auto-generated method stub
		return metierMateriel.getAllMateriel();
	}

	@WebMethod
	public Materiel addMaterielToEtudiant(Long idMateriel, @WebParam Long idEtudiant) {
		// TODO Auto-generated method stub
		return metierMateriel.addMaterielToEtudiant(idMateriel, idEtudiant);
	}

	@WebMethod
	public List<Materiel> getAllMaterielOfOneEtudiant(@WebParam Long idEtudiant) {
		// TODO Auto-generated method stub
		return metierMateriel.getAllMaterielOfOneEtudiant(idEtudiant);
	}
	
}
