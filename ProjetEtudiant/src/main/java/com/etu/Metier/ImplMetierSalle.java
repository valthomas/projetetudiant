package com.etu.Metier;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.etu.DAO.InterDaoSalle;
import com.etu.Entities.Salle;

@Transactional
public class ImplMetierSalle implements InterMetierSalle {

	private InterDaoSalle daoSalle;
	Logger log= Logger.getLogger(ImplMetierSalle.class);

	/** setter realisant injection de la dependance  **/
	public void setDaoSalle(InterDaoSalle daoSalle) {
		this.daoSalle = daoSalle;
		log.info("daoSalle injected");
	}

		/** methode **/
	@Override
	public Salle addSalle(Salle salle) {
		// TODO Auto-generated method stub
		return daoSalle.addSalle(salle);
	}

	@Override
	public Salle setSalle(Salle salle, String adresseSalle, Integer capacite,
			String nomSalle) {
		// TODO Auto-generated method stub
		return daoSalle.setSalle(salle, adresseSalle, capacite, nomSalle);
	}

	@Override
	public Salle DeleteSalle(Long idSalle) {
		// TODO Auto-generated method stub
		return daoSalle.DeleteSalle(idSalle);
	}

	@Override
	public Salle addSalleToSession(Long idSalle, Long idSession) {
		// TODO Auto-generated method stub
		return daoSalle.addSalleToSession(idSalle, idSession);
	}

	@Override
	public Salle deleteSalleToSession(Long idSalle, Long idSession) {
		// TODO Auto-generated method stub
		return daoSalle.deleteSalleToSession(idSalle, idSession);
	}

	@Override
	public List<Salle> getAllSalle() {
		// TODO Auto-generated method stub
		return daoSalle.getAllSalle();
	}
	
	
}
