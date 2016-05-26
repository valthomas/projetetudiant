package com.etu.Test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Examen;
import com.etu.Metier.InterMetierExamen;

public class TestExamen {

	private static ClassPathXmlApplicationContext context;
	private static InterMetierExamen metierExamen;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metierExamen = (InterMetierExamen) context.getBean("metierExamen");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	Examen e1 = new Examen("Math", new Date(), 10.0);
	Examen e2 = new Examen("Physique", new Date(), 10.0);
	Examen e3 = new Examen("Chimie", new Date(), 10.0);
	Examen e4 = new Examen("Anglais", new Date(), 10.0);
	Examen e5 = new Examen("Politique", new Date(), 10.0);
	
	@Test
	public final void testAddExamen() {
		metierExamen.addExamen(e1);
		metierExamen.addExamen(e2);
		metierExamen.addExamen(e3);
		metierExamen.addExamen(e4);
		metierExamen.addExamen(e5);
		
		assertNotNull(e1.getIdExamen());
	}

	@Test
	public final void testUpdateExamen() {
		Examen e6 = new Examen("Science", new Date(), 25.8);
		metierExamen.addExamen(e6);
		Long idd = e6.getIdExamen();
		e6.setNoteExamen(5.8);
		metierExamen.updateExamen(idd);
		assertTrue(e6.getNoteExamen().equals(5.8));
	}

	@Test
	public final void testDelExamen() {
		metierExamen.delExamen(5L);
		assertNull(e5.getIdExamen());
	}

	@Test
	public final void testGetExamen() {
		assertNotNull(metierExamen.getExamen(1L).getIdExamen());
	}

	@Test
	public final void testGetListExamen() {
		List<Examen> le = metierExamen.getListExamen();
		assertTrue(le.size()>0);
	}

	@Test
	public final void testAddEtudiantToExam() {

	metierExamen.addEtudiantToExam(1L,1L);
	
	assertNotNull(metierExamen.getExamen(1L).getEtudiant().getIdEtudiant());
	}

	@Test
	public final void testGetListEtudiant_Examen() {
		List<Etudiant> lp = metierExamen.getListEtudiant_Examen(1L);
		assertTrue(lp.size()>0);
	}

}
