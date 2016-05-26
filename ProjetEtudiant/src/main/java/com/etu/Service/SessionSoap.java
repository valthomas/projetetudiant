package com.etu.Service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Module;
import com.etu.Entities.Session;
import com.etu.Metier.InterMetierSession;

@WebService
public class SessionSoap {
	
	@Autowired
	private InterMetierSession metiersession;
	
	@WebMethod
	public Session addses(){
		Session s = new Session();
		return metiersession.addsession(s);
	}
	
	@WebMethod
	public void supses(@WebParam Long idSession){
		metiersession.deletesession(idSession);
	}
	
	@WebMethod
	public Session modifses(){
		Session s = new Session();
		return metiersession.updatesession(s);
	}
	
	@WebMethod
	public Session getses(@WebParam Long idSession){
		return metiersession.getsession(idSession);
	}
	
	@WebMethod
	public List<Session> listses(){
		return metiersession.getlistsession();
	}
	
	@WebMethod
	public void addetuses(@WebParam Long idEtudiant, @WebParam Long idSession){
		metiersession.addetutosess(idEtudiant, idSession);
	}
	
	@WebMethod
	public void supetuses(@WebParam Long idEtudiant, @WebParam Long idSession){
		metiersession.deleteetutosess(idEtudiant, idSession);
	}
	
	@WebMethod
	public List<Etudiant> listetuses(@WebParam Long idSession){
		return metiersession.getlistetusess(idSession);
	}
	
	@WebMethod
	public void addmodses(@WebParam Long idModule, @WebParam Long idSession){
		metiersession.addmodtosess(idModule, idSession);
	}
	
	@WebMethod
	public void supmodses(@WebParam Long idModule, @WebParam Long idSession){
		metiersession.deletemodtosess(idModule, idSession);
	}
	
	@WebMethod
	public List<Module> listmodses(@WebParam Long idSession){
		return metiersession.getlistemodsess(idSession);
	}
	
}
