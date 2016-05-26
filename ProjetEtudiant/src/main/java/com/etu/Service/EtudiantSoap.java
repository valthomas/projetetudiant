package com.etu.Service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.etu.Entities.Etudiant;
import com.etu.Metier.InterMetierEtudiant;

@WebService
public class EtudiantSoap {

	@Autowired
	private InterMetierEtudiant metierEtudiant;
	
	@WebMethod
	public Etudiant addEtudiant(){
		Etudiant e = new Etudiant();
		return metierEtudiant.addEtudiant(e);
	}
	
	@WebMethod
	public Etudiant getEtudiant(@WebParam Long idEtudiant){
		return metierEtudiant.getEtudiant(idEtudiant);
	}
	
	@WebMethod
	public Etudiant updateEtudiant(@WebParam Long idEtudiant){
		return metierEtudiant.updateEtudiant(idEtudiant);
	};
	@WebMethod
	public void delEtudiant(@WebParam Long idEtudiant){
		metierEtudiant.delEtudiant(idEtudiant);
	};
	
	@WebMethod
	public List<Etudiant> getListEtudiant(){
		return metierEtudiant.getListEtudiant();
	};
	
	
}
