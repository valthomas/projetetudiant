package com.etu.Entities;
/*
AUTEUR: Mfoulou Lory
NOM DU PROJET: ProjetEtudiant
DATE: 25/05/2016
CLASSE: Examen
VERSION: 1
REF UML:3
SPRINT:
REF_USER STORIES:
ASSOSSIATION: OnetoMany (Etudiant)
*/
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Examen implements Serializable {

	
	// ----------- ATTRIBUTS: -----------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idExamen;
	@NotEmpty
	private String nomExamen;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateExamen;
	@NotNull
	private Double noteExamen;
	
	
	
	// ----------- ASSOCIATION: -----------
	@ManyToOne
	@JoinColumn(name="ID_etudiant")
	private Etudiant etudiant;
	
	
	// ----------- GETTERS/SETTERS: -----------
	public Long getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}
	public String getNomExamen() {
		return nomExamen;
	}
	public void setNomExamen(String nomExamen) {
		this.nomExamen = nomExamen;
	}
	public Date getDateExamen() {
		return dateExamen;
	}
	public void setDateExamen(Date dateExamen) {
		this.dateExamen = dateExamen;
	}
	public Double getNoteExamen() {
		return noteExamen;
	}
	public void setNoteExamen(Double noteExamen) {
		this.noteExamen = noteExamen;
	}
	
	

	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	// ----------- CONSTRUCTEURS: -----------
	public Examen(String nomExamen, Date dateExamen, Double noteExamen) {
		super();
		this.nomExamen = nomExamen;
		this.dateExamen = dateExamen;
		this.noteExamen = noteExamen;
	}
	public Examen() {
		super();
	}
	
	
}
