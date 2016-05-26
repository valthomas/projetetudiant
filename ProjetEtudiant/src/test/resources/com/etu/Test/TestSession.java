package com.etu.Test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etu.Entities.Etudiant;
import com.etu.Entities.Module;
import com.etu.Entities.Session;
import com.etu.Metier.InterMetierSession;

public class TestSession {
	
	private static ClassPathXmlApplicationContext context;
	private static InterMetierSession metiersession;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metiersession=(InterMetierSession) context.getBean("metiersession");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddsession() {
		Session s = new Session("nom", new Date(), new Date());
		metiersession.addsession(s);
		assertNotNull(s.getIdSession());
	}

	@Test
	public void testDeletesession() {
		List<Session> tab1 = metiersession.getlistsession();
		metiersession.deletesession(1L);
		List<Session> tab2 = metiersession.getlistsession();
		assertNotNull(tab1.size()==tab2.size()+1);
	}

	@Test
	public void testUpdatesession() {
		Session s = metiersession.getsession(1L);
		s.setNomSession("newnom");
		metiersession.updatesession(s);
		assertNotNull(s.getNomSession().equals("newnom"));
	}

	@Test
	public void testGetsession() {
		Session s = metiersession.getsession(1L);
		assertNotNull(s.getIdSession().equals(1L));
	}

	@Test
	public void testGetlistsession() {
		List<Session> tab = metiersession.getlistsession();
		assertNotNull(tab.size()>0);
	}

	@Test
	public void testAddetutosess() {
		Session s = metiersession.getsession(1L);
		Etudiant e = new Etudiant("nom", "prenom", new Date(), "tel", "mail", "adresse", "spec");
		metiersession.addetutosess(1L, 1L);
		assertNotNull(s.getListeetudiants().size()>0);
	}

	@Test
	public void testDeleteetutosess() {
		Session s = metiersession.getsession(1L);
		List<Etudiant> tab1 = s.getListeetudiants();
		metiersession.deleteetutosess(1L, 1L);
		List<Etudiant> tab2 = s.getListeetudiants();
		assertNotNull(tab1.size()==tab2.size()+1);
	}

	@Test
	public void testGetlistetusess() {
		Session s = metiersession.getsession(1L);
		metiersession.getlistetusess(1L);
		assertNotNull(s.getListeetudiants().size()>0);
	}

	@Test
	public void testAddmodtosess() {
		Session s = metiersession.getsession(1L);
		metiersession.addmodtosess(1L, 1L);
		assertNotNull(s.getListemodules().size()>0);
	}

	@Test
	public void testDeletemodtosess() {
		Session s = metiersession.getsession(1L);
		List<Module> tab1 = s.getListemodules();
		metiersession.deletemodtosess(1L, 1L);
		List<Module> tab2 = s.getListemodules();
		assertNotNull(tab1.size()==tab2.size()+1);
		
	}

	@Test
	public void testGetlistemodsess() {
		Module m = new Module("nom", 5, "desc");
		Session s = metiersession.getsession(1L);
		metiersession.getlistemodsess(1L);
		assertNotNull(s.getListemodules().size()>0);
	}

}
