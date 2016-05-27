package com.etu.Service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.etu.Entities.Materiel;
import com.etu.Entities.Salle;
import com.etu.Metier.InterMetierSalle;

@WebService
public class SalleSoap {

	@Autowired
	private InterMetierSalle metierSalle;
	

	/** methode **/
	@WebMethod
	public Salle addSalle(@WebParam Salle salle) {
		// TODO Auto-generated method stub
		return metierSalle.addSalle(salle);
	}

	@WebMethod
	public Salle setSalle(@WebParam Salle salle, @WebParam String adresseSalle,@WebParam  Integer capacite,@WebParam String nomSalle) {
		// TODO Auto-generated method stub
		return metierSalle.setSalle(salle, adresseSalle, capacite, nomSalle);
	}

	@WebMethod
	public Salle DeleteSalle(@WebParam Long idSalle) {
		// TODO Auto-generated method stub
		return metierSalle.DeleteSalle(idSalle);
	}

	@WebMethod
	public Salle addSalleToSession(@WebParam Long idSalle,@WebParam  Long idSession) {
		// TODO Auto-generated method stub
		return metierSalle.addSalleToSession(idSalle, idSession);
	}

	@WebMethod
	public Salle deleteSalleToSession(@WebParam Long idSalle,@WebParam Long idSession) {
		// TODO Auto-generated method stub
		return metierSalle.deleteSalleToSession(idSalle, idSession);
	}

	@WebMethod
	public List<Salle> getAllSalle() {
		// TODO Auto-generated method stub
		return metierSalle.getAllSalle();
	}

	@WebMethod
	public Salle getSalle(@WebParam Long idSalle) {
		// TODO Auto-generated method stub
		return metierSalle.getSalle(idSalle);
	}
	
}
