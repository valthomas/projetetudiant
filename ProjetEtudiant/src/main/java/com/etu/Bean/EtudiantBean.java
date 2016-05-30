package com.etu.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.etu.Entities.Etudiant;
import com.etu.Metier.InterMetierEtudiant;

@Controller
@ManagedBean(name="etudiantBean")
@RequestScoped
public class EtudiantBean {

	//couplage faible:
	@Autowired
	private InterMetierEtudiant metier;
	
	//Logger:	
	private Logger Log = Logger.getLogger("Implmentation");
	
	//Attributs :
	private Etudiant e = new Etudiant();
	private List<Etudiant> listEtudiant = new ArrayList<Etudiant>();
	private Long idEtudiant;

	
	//Getters et Setters:
	public Etudiant getE() {
		return e;
	}
	public void setE(Etudiant e) {
		this.e = e;
	}
	public List<Etudiant> getListEtudiant() {
		return listEtudiant;
	}
	public void setListEtudiant(List<Etudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	//setter de l'interface metier pour l'injection de dépendance:

	public void setMetier(InterMetierEtudiant metier) {
		this.metier = metier;
	}
	
	//définition des méthodes:
	
	public void saveEtudiant(){
		e.setIdEtudiant(null);
		metier.addEtudiant(e);
	}
	
	public void updateEtudiant(){
		metier.updateEtudiant(idEtudiant);
	}
	
	public void delEtudiant(){
		metier.delEtudiant(idEtudiant);
	}
	public Etudiant getEtudiant(){
		return metier.getEtudiant(idEtudiant);
	}
	public List<Etudiant> getListEtu(){
		listEtudiant = metier.getListEtudiant();
		return listEtudiant;
	};
	//constructeurs par défaut:
	public EtudiantBean() {
		super();
	}
	
}
