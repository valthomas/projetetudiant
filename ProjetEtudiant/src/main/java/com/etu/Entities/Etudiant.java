package com.etu.Entities;
/*
AUTEUR: Mfoulou Lory
NOM DU PROJET: ProjetEtudiant
DATE: 25/05/2016
CLASSE: Etudiant
VERSION: 1
REF UML:1
SPRINT:
REF_USER STORIES:
ASSOSSIATION: ManytoOne (Examen)/ManytoOne (Materiel)/ManytoOne (Session)
*/
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Etudiant implements Serializable{

	// ----------- ATTRIBUTS: -----------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEtudiant;
	@NotEmpty
	private String nomEtudiant;
	@NotEmpty
	private String prenomEtudiant;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceEtudiant;
	private String telEtudiant;	
	private String mailEtudiant;
	private String adresseEtudiant;
	private String specialiteEtudian;

	
	// ----------- ASSOCIATION: -----------
	@OneToMany(mappedBy="etudiant", fetch=FetchType.EAGER)
	private List<Examen> examen;
	
	@OneToMany
	private List<Materiel> Materiel;
	
	@ManyToOne
	@JoinColumn(name="ID_Session")
	private Session session;
	
	// ----------- GETTERS/SETTERS: -----------
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}
	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}
	public Date getDateNaissanceEtudiant() {
		return dateNaissanceEtudiant;
	}
	public void setDateNaissanceEtudiant(Date dateNaissanceEtudiant) {
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}
	public String getTelEtudiant() {
		return telEtudiant;
	}
	public void setTelEtudiant(String telEtudiant) {
		this.telEtudiant = telEtudiant;
	}
	public String getMailEtudiant() {
		return mailEtudiant;
	}
	public void setMailEtudiant(String mailEtudiant) {
		this.mailEtudiant = mailEtudiant;
	}
	public String getAdresseEtudiant() {
		return adresseEtudiant;
	}
	public void setAdresseEtudiant(String adresseEtudiant) {
		this.adresseEtudiant = adresseEtudiant;
	}
	public String getSpecialiteEtudian() {
		return specialiteEtudian;
	}
	public void setSpecialiteEtudian(String specialiteEtudian) {
		this.specialiteEtudian = specialiteEtudian;
	}
	public List<Examen> getExamen() {
		return examen;
	}
	public void setExamen(List<Examen> examen) {
		this.examen = examen;
	}
	public List<Materiel> getMateriel() {
		return Materiel;
	}
	public void setMateriel(List<Materiel> materiel) {
		Materiel = materiel;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	// ----------- CONSTRUCTEURS: -----------
	       
	public Etudiant(String nomEtudiant, String prenomEtudiant,
			Date dateNaissanceEtudiant, String telEtudiant,
			String mailEtudiant, String adresseEtudiant,
			String specialiteEtudian) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
		this.telEtudiant = telEtudiant;
		this.mailEtudiant = mailEtudiant;
		this.adresseEtudiant = adresseEtudiant;
		this.specialiteEtudian = specialiteEtudian;
	}
	
	public Etudiant() {
		super();
	}	
	
}
