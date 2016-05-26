package com.etu.Entities;
/*
AUTEUR: Mfoulou Lory
NOM DU PROJET: ProjetEtudiant
DATE: 25/05/2016
CLASSE: Materiel
VERSION: 1
REF UML:4
SPRINT:
REF_USER STORIES:
ASSOSSIATION: OnetoMany (Etudiant)unidirectionnel
*/
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Materiel implements Serializable {
	
	// ----------- ATTRIBUTS: -----------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMateriel;
	@NotEmpty
	private String nomMateriel;
	@NotEmpty
	private String etatsMateriel;

		
	// ----------- ASSOCIATION: -----------
//unidirection
	// ----------- GETTERS/SETTERS: -----------
	
	public Long getIdMateriel() {
		return idMateriel;
	}
	public void setIdMateriel(Long idMateriel) {
		this.idMateriel = idMateriel;
	}
	public String getNomMateriel() {
		return nomMateriel;
	}
	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}
	public String getEtatsMateriel() {
		return etatsMateriel;
	}
	public void setEtatsMateriel(String etatsMateriel) {
		this.etatsMateriel = etatsMateriel;
	}
	
	// ----------- CONSTRUCTEURS: -----------
	public Materiel(String nomMateriel, String etatsMateriel) {
		super();
		this.nomMateriel = nomMateriel;
		this.etatsMateriel = etatsMateriel;
	}
	public Materiel() {
		super();
	}

}
