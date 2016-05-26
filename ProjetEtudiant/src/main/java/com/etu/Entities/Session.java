package com.etu.Entities;

/*Auteur: Valérian THOMAS
 *date: 25/05/2016
 *Projet : ProjetEtudiant
 *Package:com.etu.Entities
 *Class:Session
 *version:1
 *association: Etudiant (One to Many), Module (Many to Many), Salle (Many to One)
 * */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
public class Session implements Serializable{
	
	//association avec Etudiant
	@OneToMany(mappedBy="session", fetch=FetchType.EAGER)
	private List<Etudiant> listeetudiants = new ArrayList<Etudiant>();	
	
	public List<Etudiant> getListeetudiants() {
		return listeetudiants;
	}
	public void setListeetudiants(List<Etudiant> listeetudiants) {
		this.listeetudiants = listeetudiants;
	}

	//association avec Salle
	@ManyToOne
	@JoinColumn(name="idSalle")
	private Salle salle;
	
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	//association avec Module (unidirectionnel)
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="session_module")
	private List<Module> listemodules = new ArrayList<Module>();
	
	public List<Module> getListemodules() {
		return listemodules;
	}
	public void setListemodules(List<Module> listemodules) {
		this.listemodules = listemodules;
	}
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSession;
	@NotEmpty
	private String nomSession;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDebutSession;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateFinSession;
	
	
	//getters setters
	
	public Long getIdSession() {
		return idSession;
	}
	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}
	public String getNomSession() {
		return nomSession;
	}
	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}
	public Date getDateDebutSession() {
		return dateDebutSession;
	}
	public void setDateDebutSession(Date dateDebutSession) {
		this.dateDebutSession = dateDebutSession;
	}
	public Date getDateFinSession() {
		return dateFinSession;
	}
	public void setDateFinSession(Date dateFinSession) {
		this.dateFinSession = dateFinSession;
	}
	
	
	//constructeurs
	
	public Session(String nomSession, Date dateDebutSession, Date dateFinSession) {
		super();
		this.nomSession = nomSession;
		this.dateDebutSession = dateDebutSession;
		this.dateFinSession = dateFinSession;
	}
	
	public Session() {
		super();
	}
	
	

}
