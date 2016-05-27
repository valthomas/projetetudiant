package com.etu.DAO;

import java.util.List;

import com.etu.Entities.Salle;
import com.etu.Entities.Session;

public interface InterDaoSalle {

	
	/** methode sauvegardant la salle. Elle prend en argument l'id de la salle**/
	public Salle addSalle(Salle salle);
	/** methode modifer la salle. Elle prend en argument l'id de la salle**/
	public Salle setSalle(Salle salle,String adresseSalle, Integer capacite,String nomSalle);
	/** methode modifer la salle. Elle prend en argument l'id de la salle**/
	public Salle DeleteSalle(Long idSalle);
	public Salle getSalle(Long idSalle);
	public Salle addSalleToSession(Long idSalle, Long idSession);
	public Salle deleteSalleToSession(Long idSalle, Long idSession);
	public List<Salle> getAllSalle();
	
}
