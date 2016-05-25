package com.etu.Entities;

/*Auteur: Valérian THOMAS
 *date: 25/05/2016
 *Projet : ProjetEtudiant
 *Package:com.etu.Entities
 *Class:Salle
 *version:1
 *association: Session (One to Many)
 * */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
public class Salle implements Serializable{
	
	//association avec Session
	@OneToMany(mappedBy="salle")
	private List<Session> listesessions = new ArrayList<Session>();
	
	public List<Session> getListesessions() {
		return listesessions;
	}
	public void setListesessions(List<Session> listesessions) {
		this.listesessions = listesessions;
	}	
		
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSalle;
	@NotEmpty
	private String adresseSalle;
	@NotEmpty
	private String nomSalle;
	@NotNull
	private Integer capaciteSalle;
	
	
	//getters setters
	
	public Long getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(Long idSalle) {
		this.idSalle = idSalle;
	}
	public String getAdresseSalle() {
		return adresseSalle;
	}
	public void setAdresseSalle(String adresseSalle) {
		this.adresseSalle = adresseSalle;
	}
	public String getNomSalle() {
		return nomSalle;
	}
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	public Integer getCapaciteSalle() {
		return capaciteSalle;
	}
	public void setCapaciteSalle(Integer capaciteSalle) {
		this.capaciteSalle = capaciteSalle;
	}
	
	
	//constructeurs
	
	public Salle(String adresseSalle, String nomSalle, Integer capaciteSalle) {
		super();
		this.adresseSalle = adresseSalle;
		this.nomSalle = nomSalle;
		this.capaciteSalle = capaciteSalle;
	}
	
	public Salle() {
		super();
	}
	
}
