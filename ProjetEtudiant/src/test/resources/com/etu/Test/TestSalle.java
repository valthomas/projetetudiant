package com.etu.Test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etu.Entities.Salle;
import com.etu.Metier.InterMetierSalle;

public class TestSalle {
		
	private static InterMetierSalle metierSalle;
	public static ClassPathXmlApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context= new ClassPathXmlApplicationContext("app.xml");
		metierSalle = (InterMetierSalle)  context.getBean("metierSalle");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddSalle() {
		Salle s=new Salle("avenue des reves","chez Aghiles",10);
		metierSalle.addSalle(s);
		assertNotNull(metierSalle.addSalle(s));
	}

	@Test
	public void testSetSalle() {
		Salle salle=new Salle("avenue des belles","chez Sienna",10);
		String adresseSalle= "boulevard des airs";
		Integer capacite= 4;
		String nomSalle= "chez bob";
		metierSalle.setSalle(salle, adresseSalle, capacite, nomSalle);
		assertEquals("boulevard des airs", salle.getAdresseSalle());
	}

	@Test
	public void testDeleteSalle() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSalleToSession() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSalleToSession() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllSalle() {
		fail("Not yet implemented");
	}

}
