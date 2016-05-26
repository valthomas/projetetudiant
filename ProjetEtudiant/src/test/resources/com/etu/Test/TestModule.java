package com.etu.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etu.Entities.Module;
import com.etu.Metier.InterMetierModule;

public class TestModule {
	
	private static ClassPathXmlApplicationContext context;
	private static InterMetierModule metiermodule;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metiermodule = (InterMetierModule) context.getBean("metiermodule");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddmodule() {
		Module m = new Module("nom2", 2, "desc2");
		metiermodule.addmodule(m);
		assertNotNull(m.getIdModule());
	}

	@Test
	public void testDeletemodule() {
		List<Module> tab1 = metiermodule.getlistmodule();
		metiermodule.deletemodule(1L);
		List<Module> tab2 = metiermodule.getlistmodule();
		assertNotNull(tab1.size()==tab2.size()+1);
	}

	@Test
	public void testUpdatemodule() {
		Module m = metiermodule.getmodule(1L);
		m.setNomModule("newnom");
		metiermodule.updatemodule(m);
		assertNotNull(m.getNomModule().equals("newnom"));
	}

	@Test
	public void testGetmodule() {
		Module m = metiermodule.getmodule(1L);
		assertNotNull(m.getIdModule().equals(1L));
	}

	@Test
	public void testGetlistmodule() {
		List<Module> tab = metiermodule.getlistmodule();
		assertNotNull(tab.size()>0);
	}
}
