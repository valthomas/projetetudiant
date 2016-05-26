package com.etu.Metier;

import java.util.List;

import com.etu.Entities.Materiel;

public interface InterMetierMateriel {

	public Materiel addMateriel(Materiel mat);
	public Materiel setMateriel(Long idMat,String nomMateriel, String etatMateriel);
	public Materiel deleteMateriel(Long idMat); 
	public Materiel getMateriel(Long idMateriel);
	public List<Materiel> getAllMateriel();
	public Materiel addMaterielToEtudiant(Long idMateriel, Long idEtudiant);
	public List<Materiel> getAllMaterielOfOneEtudiant(Long idEtudiant);
}
