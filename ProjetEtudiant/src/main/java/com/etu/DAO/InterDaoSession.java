package com.etu.DAO;

/*Auteur: Valérian THOMAS
 *date: 25/05/2016
 *Projet : ProjetEtudiant
 *Package:com.etu.DAO
 *Interface:InterDaoSession
 *version:1
 *association: ImplDaoSession
 * */

import java.util.List;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Module;
import com.etu.Entities.Session;

public interface InterDaoSession {
	
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
