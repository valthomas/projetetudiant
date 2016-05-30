package com.etu.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Controller;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Module;
import com.etu.Entities.Session;
import com.etu.Metier.InterMetierSession;

@SuppressWarnings("serial")
@Controller
@ManagedBean(name="sessionbean")
@RequestScoped
public class SessionBean implements Serializable{
	
	private InterMetierSession metiersession;
	
	//attributs necesaires
	
	private Session s = new Session();
	private List<Session> tabses = new ArrayList<Session>();
	private Long idSession;
	private Long idEtudiant;
	private Long idModule;
	private List<Etudiant> tabetu = new ArrayList<Etudiant>();
	private List<Module> tabmod = new ArrayList<Module>();
	
	
	//getters setters
	
	public Session getS() {
		return s;
	}
	public void setS(Session s) {
		this.s = s;
	}
	public List<Session> getTabses() {
		return tabses;
	}
	public void setTabses(List<Session> tabses) {
		this.tabses = tabses;
	}
	public Long getIdSession() {
		return idSession;
	}
	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public Long getIdModule() {
		return idModule;
	}
	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}
	public List<Etudiant> getTabetu() {
		return tabetu;
	}
	public void setTabetu(List<Etudiant> tabetu) {
		this.tabetu = tabetu;
	}
	public List<Module> getTabmod() {
		return tabmod;
	}
	public void setTabmod(List<Module> tabmod) {
		this.tabmod = tabmod;
	}
	public void setMetiersession(InterMetierSession metiersession) {
		this.metiersession = metiersession;
	}
	
	//methodes
	
	public Session addses(){
		metiersession.addsession(s);
		return s;
	}
	
	public void supses(){
		metiersession.deletesession(idSession);
	}
	
	public Session modifses(){
		metiersession.updatesession(s);
		return s;
	}
	
	public Session getses(){
		Session s = metiersession.getsession(idSession);
		return s;
	}
	
	public List<Session> listses(){
		List<Session> tabses = metiersession.getlistsession();
		return tabses;
	}
	
	public void addetuses(){
		metiersession.addetutosess(idEtudiant, idSession);
	}
	
	public void supetuses(){
		metiersession.deleteetutosess(idEtudiant, idSession);
	}
	
	public List<Etudiant> listetuses(){
		List<Etudiant> tabetu = metiersession.getlistetusess(idSession);
		return tabetu;
	}
	
	public void addmodses(){
		metiersession.addmodtosess(idModule, idSession);
	}
	
	public void supmodses(){
		metiersession.deletemodtosess(idModule, idSession);
	}
	
	public List<Module> listmodses(){
		List<Module> tabmod = metiersession.getlistemodsess(idSession);
		return tabmod;
	}

}
