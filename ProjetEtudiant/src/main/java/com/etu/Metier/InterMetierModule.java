package com.etu.Metier;

/*Auteur: Valérian THOMAS
 *date: 26/05/2016
 *Projet : ProjetEtudiant
 *Package:com.etu.Metier
 *Interface:InterMetierModule
 *version:1
 *association: ImplMetierModule
 * */

import java.util.List;

import com.etu.Entities.Module;

public interface InterMetierModule {
	
	public Module addmodule(Module m);
	public void deletemodule(Long idModule);
	public Module updatemodule(Module m);
	public Module getmodule(Long idModule);
	public List<Module> getlistmodule();

}
