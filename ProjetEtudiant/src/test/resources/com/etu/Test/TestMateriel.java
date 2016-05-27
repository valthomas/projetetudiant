package com.etu.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.primefaces.component.log.Log;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Materiel;
import com.etu.Entities.Salle;
import com.etu.Metier.InterMetierEtudiant;
import com.etu.Metier.InterMetierMateriel;

public class TestMateriel {

	private static InterMetierMateriel metierMateriel;
	private static InterMetierEtudiant metierEtudiant;
	public static ClassPathXmlApplicationContext context;
	static Logger log= Logger.getLogger(TestMateriel.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context= new ClassPathXmlApplicationContext("app.xml");
		metierMateriel = (InterMetierMateriel)  context.getBean("metierMateriel");
		metierEtudiant = (InterMetierEtudiant)  context.getBean("metierEtudiant");
		log.info("debut testSalle");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
		log.info("fin testSalle");
	}
	
	Materiel materiel1=new Materiel("table","bon etat");
	Materiel materiel2=new Materiel("tableau","bon etat");
	
	@Test
	public void testAddMateriel() {
		Materiel s=new Materiel("bureau","bon etat");
		metierMateriel.addMateriel(s);
		Materiel s1=new Materiel("crayon","bon etat");
		metierMateriel.addMateriel(s1);
		assertNotNull(metierMateriel.getAllMateriel());
	}

	@Test
	public void testSetMateriel() {
		Materiel s=metierMateriel.getMateriel(2L);
		metierMateriel.setMateriel(2L, "ordinateur", "excellent");
		assertEquals("ordinateur",s.getNomMateriel());
	}

	@Test
	public void testDeleteMateriel() {
		//metierMateriel.deleteMateriel(1L);
		assertNull(metierMateriel.getMateriel(1L));
	}

	@Test
	public void testGetMateriel() {
		Materiel mat= metierMateriel.getMateriel(2L);
		assertEquals("ordinateur", mat.getNomMateriel());
	}

	@Test
	public void testGetAllMateriel() {
		List<Materiel> list= new ArrayList<Materiel>();
		list=metierMateriel.getAllMateriel();
		assertNotNull(list);
	}

	@Test
	public void testAddMaterielToEtudiant() {
		Materiel mat=new Materiel("regle", "excellent");
		Etudiant etu= metierEtudiant.getEtudiant(1L);
		metierMateriel.addMateriel(mat);
		metierMateriel.addMaterielToEtudiant(5L, 1L);
		assertNotNull(etu.getMateriel());
	}

	@Test
	public void testGetAllMaterielOfOneEtudiant() {
		Etudiant e= metierEtudiant.getEtudiant(1L);
		//metierMateriel.addMaterielToEtudiant(4L, 1L);
		List<Materiel> list= new ArrayList<Materiel>();
		list= metierMateriel.getAllMaterielOfOneEtudiant(1L);
		log.info("affichage de la liste du materiel de l'etudiant d'id" +1L);
		assertNotNull(list);
	}

}
