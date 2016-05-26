package com.etu.Metier;

import java.util.List;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Module;
import com.etu.Entities.Session;

/*Auteur: Valérian THOMAS
 *date: 26/05/2016
 *Projet : ProjetEtudiant
 *Package:com.etu.Metier
 *Interface:InterMetierSession
 *version:1
 *association: ImplMetierSession
 * */

public interface InterMetierSession {
	
	public Session addsession(Session s);
	public void deletesession(Long idSession);
	public Session updatesession(Session s);
	public Session getsession(Long idSession);
	public List<Session> getlistsession();
	public void addetutosess(Long idEtudiant, Long idSession);
	public void deleteetutosess(Long idEtudiant, Long idSession);
	public List<Etudiant> getlistetusess(Long idSession);
	public void addmodtosess(Long idModule, Long idSession);
	public void deletemodtosess(Long idModule, Long idSession);
	public List<Module> getlistemodsess(Long idSession);

}
