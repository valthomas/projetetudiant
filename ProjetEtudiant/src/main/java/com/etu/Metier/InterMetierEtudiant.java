package com.etu.Metier;

import java.util.List;

import com.etu.Entities.Etudiant;

public interface InterMetierEtudiant {
	public Etudiant addEtudiant(Etudiant e);
	public Etudiant updateEtudiant(Long idEtudiant);
	public void delEtudiant(Long idEtudiant);
	public Etudiant getEtudiant(Long idEtudiant);
	public List<Etudiant> getListEtudiant();
}
