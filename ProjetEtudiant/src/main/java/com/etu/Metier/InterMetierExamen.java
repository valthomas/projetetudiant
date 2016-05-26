package com.etu.Metier;

import java.util.List;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Examen;

public interface InterMetierExamen {

	public Examen addExamen(Examen e);
	public Examen updateExamen(Long idExamen);
	public void delExamen(Long idExamen);
	public Examen getExamen (Long idExamen);
	public List<Examen> getListExamen ();
	public void addEtudiantToExam(Long idEtudiant, Long idExamen);
	public List<Etudiant> getListEtudiant_Examen(Long idExamen);
}
