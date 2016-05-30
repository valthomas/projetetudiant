package com.etu.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Examen;
import com.etu.Metier.InterMetierExamen;

@Controller
@ManagedBean(name="examenBean")
@RequestScoped
public class ExamenBean {

	//Couplage faible
	@Autowired
	private InterMetierExamen metier;
	
	//Logger:
	private Logger log=Logger.getLogger("Implementation");
	
	//Attributs:
	private Examen e = new Examen();
	private List<Examen> listExamen = new ArrayList<Examen>();
	private Long idExamen;
	private Long idEtudiant;

	
	//Getters et Setters:
	public Examen getE() {
		return e;
	}
	public void setE(Examen e) {
		this.e = e;
	}
	public List<Examen> getListExamen() {
		return listExamen;
	}
	public void setListExamen(List<Examen> listExamen) {
		this.listExamen = listExamen;
	}
	public Long getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}


	//setter iterface:
	public void setMetier(InterMetierExamen metier) {
		this.metier = metier;
	}

	//methodes
	public void saveExamen(){
		e.setIdExamen(null);
		metier.addExamen(e);
	}
		
	public void updateExamen(){
		metier.updateExamen(idExamen);
	}
	
	public void delExamen(){
		metier.delExamen(idExamen);
	}
	
	public Examen getExamen(){
		return metier.getExamen(idExamen);
	}
	
	public List<Examen> getListExam(){
		return metier.getListExamen();
	}
	
	public void addEtudiantToExam(){
		metier.addEtudiantToExam(idEtudiant, idExamen);
	}
	public List<Etudiant> getListEtudiant_Examen(){
		return metier.getListEtudiant_Examen(idExamen);
	}
	
	//constructeurs par défaut:
	public ExamenBean() {
		super();
	}
	
	
	
	
}
