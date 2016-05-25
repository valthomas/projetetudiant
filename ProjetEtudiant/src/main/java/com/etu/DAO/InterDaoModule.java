package com.etu.DAO;

import java.util.List;

import com.etu.Entities.Module;

/*Auteur: Valérian THOMAS
 *date: 25/05/2016
 *Projet : ProjetEtudiant
 *Package:com.etu.DAO
 *Interface:InterDaoModule
 *version:1
 *association: ImplDaoModule
 * */

public interface InterDaoModule {
	
	public Module addmodule(Module m);
	public void deletemodule(Long idModule);
	public Module updatemodule(Long idModule);
	public Module getmodule(Long idModule);
	public List<Module> getlistmodule();

}
