package com.etu.Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etu.Entities.Etudiant;
import com.etu.Metier.InterMetierEtudiant;

public class TestEtudiant {

	private static ClassPathXmlApplicationContext context;
	private static InterMetierEtudiant metierEtudiant;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metierEtudiant = (InterMetierEtudiant) context.getBean("metierEtudiant");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	Etudiant e1 = new Etudiant("Mfoulou", "Tatiana", new Date(), "06.47.47.47.47", "tatiana@yahoo", "quelque part à Paris", "Math");
	Etudiant e2 = new Etudiant("Milou", "Tintin", new Date(), "06.48.48.48.48", "tintinmilou@yahoo", "quelque part à Bruxelle", "Litterature");
	Etudiant e3 = new Etudiant("Perte", "Detemps", new Date(), "06.00.47.00.47", "perte2temps@yahoo", "quelque part à Marseille", "Musique");
	Etudiant e4 = new Etudiant("Castle", "serie", new Date(), "06.14.69.14.49", "CastleSere@yahoo", "quelque part à NewYork", "Math");
	Etudiant e5 = new Etudiant("Mfoulou", "Tatiana", new Date(), "06.47.47.47.47", "tatiana@yahoo", "quelque part à Paris", "Math");
	
	@Test
	public final void testAddEtudiant() {
		metierEtudiant.addEtudiant(e1);
		metierEtudiant.addEtudiant(e2);
		metierEtudiant.addEtudiant(e3);
		metierEtudiant.addEtudiant(e4);
		metierEtudiant.addEtudiant(e5);
		assertNotNull(e3.getIdEtudiant());
	}

	@Test
	public final void testUpdateEtudiant() {
		fail("Not yet implemented");
	}

	@Test
	public final void testDelEtudiant() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetEtudiant() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetListEtudiant() {
		fail("Not yet implemented");
	}

}
