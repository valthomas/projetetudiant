package com.etu.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/*Auteur: Valérian THOMAS
 *date: 25/05/2016
 *Projet : ProjetEtudiant
 *Package:com.etu.Entities
 *Class:Module
 *version:1
 * */

@SuppressWarnings("serial")
@Entity
public class Module implements Serializable{
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idModule;
	@NotEmpty
	private String nomModule;
	@NotNull
	private Integer dureeModule;
	@NotEmpty
	private String descriptionModule;
	
	//getters setters
	
	public Long getIdModule() {
		return idModule;
	}
	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}
	public String getNomModule() {
		return nomModule;
	}
	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}
	public Integer getDureeModule() {
		return dureeModule;
	}
	public void setDureeModule(Integer dureeModule) {
		this.dureeModule = dureeModule;
	}
	public String getDescriptionModule() {
		return descriptionModule;
	}
	public void setDescriptionModule(String descriptionModule) {
		this.descriptionModule = descriptionModule;
	}
	
	//constructeurs
	
	public Module(String nomModule, Integer dureeModule,
			String descriptionModule) {
		super();
		this.nomModule = nomModule;
		this.dureeModule = dureeModule;
		this.descriptionModule = descriptionModule;
	}
	
	
	public Module() {
		super();
	}

}
