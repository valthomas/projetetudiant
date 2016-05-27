package com.etu.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etu.Entities.Salle;
import com.etu.Entities.Session;
import com.etu.Metier.InterMetierSalle;
import com.etu.Metier.InterMetierSession;

public class TestSalle {
		
	private static InterMetierSalle metierSalle;
	
	private static InterMetierSession metiersession;
	public static ClassPathXmlApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context= new ClassPathXmlApplicationContext("app.xml");
		metierSalle = (InterMetierSalle)  context.getBean("metierSalle");
		metiersession= (InterMetierSession)  context.getBean("metiersession");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddSalle() {
		Salle s=new Salle("avenue des reves","chez Aghiles",10);
		metierSalle.addSalle(s);
		Salle s1=new Salle("avenue des reves","chez John",15);
		metierSalle.addSalle(s1);
		assertNotNull(metierSalle.getAllSalle());
	}

	@Test
	public void testSetSalle() {
		Salle salle=new Salle("avenue des belles","chez Sienna",10);
		metierSalle.addSalle(salle);
		String adresseSalle= "boulevard des airs";
		Integer capacite= 4;
		String nomSalle= "chez bob";
		metierSalle.setSalle(salle, adresseSalle, capacite, nomSalle);
		assertEquals("boulevard des airs", salle.getAdresseSalle());
	}

	@Test
	public void testDeleteSalle() {
		metierSalle.DeleteSalle(2L);
		assertNull(metierSalle.getSalle(2L));
	}

	@Test
	public void testGetSalle() {
		Salle s=metierSalle.getSalle(3L);
		String st=s.getAdresseSalle();
		assertEquals("avenue des reves",st);
	}
	@Test
	public void testAddSalleToSession() {
		Salle salle=new Salle("avenue des betes","chez lola",4);
		Session s= new Session("java J2E", new Date(), new Date());
		metierSalle.addSalle(salle);
		metiersession.addsession(s);
		metierSalle.addSalleToSession(salle.getIdSalle(), s.getIdSession());
		assertNotNull(s.getSalle());
	}

	@Test
	public void testDeleteSalleToSession() {
		Salle salle=new Salle("avenue des gens","chez tibault",4);
		Session s= new Session("java J2E", new Date(), new Date());
		metierSalle.addSalle(salle);
		metiersession.addsession(s);
		metierSalle.deleteSalleToSession(salle.getIdSalle(), s.getIdSession());
		assertNull(s.getSalle());
	}

	@Test
	public void testGetAllSalle() {
		List<Salle> list=new ArrayList<Salle>();
		list=metierSalle.getAllSalle();
		assertNotNull(list);
	}
}
	