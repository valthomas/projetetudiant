package com.etu.Service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Examen;
import com.etu.Metier.InterMetierExamen;

@WebService
public class ExamenSoap {

	@Autowired
	private InterMetierExamen metierExamen;
	
	@WebMethod
	public Examen addExamen(){
		Examen e = new Examen();
		return metierExamen.addExamen(e);
	};
	
	@WebMethod
	public Examen updateExamen(@WebParam Long idExamen){
		return metierExamen.updateExamen(idExamen);
	};
	
	@WebMethod
	public void delExamen(@WebParam Long idExamen){
		metierExamen.delExamen(idExamen);
	};
	@WebMethod
	public Examen getExamen(Long idExamen){
		return metierExamen.getExamen(idExamen);
	};
	@WebMethod
	public List<Examen> getListExamen(){
		return metierExamen.getListExamen();
	};
	@WebMethod
	public void addEtudiantToExam(@WebParam Long idEtudiant, @WebParam Long idExamen){
		metierExamen.addEtudiantToExam(idEtudiant, idExamen);
	};
	@WebMethod
	public List<Etudiant> getListEtudiant_Examen(@WebParam Long idExamen){
		return metierExamen.getListEtudiant_Examen(idExamen);
	};
}
