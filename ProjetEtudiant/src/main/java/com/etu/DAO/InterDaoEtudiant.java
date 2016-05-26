package com.etu.DAO;

import java.util.List;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Examen;

public interface InterDaoEtudiant {

	public Etudiant addEtudiant(Etudiant e);
	public Etudiant updateEtudiant(Long idEtudiant);
	public void delEtudiant(Long idEtudiant);
	public Etudiant getEtudiant(Long idEtudiant);
	public List<Etudiant> getListEtudiant();
	
}
