package com.etu.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Controller;

import com.etu.Entities.Module;
import com.etu.Metier.InterMetierModule;

@Controller
@ManagedBean(name="modulebean")
@RequestScoped
public class ModuleBean {
	
	private InterMetierModule metiermodule;
	
	//attributs necessaires
	private Module m = new Module();
	private Long idModule;
	private List<Module> tab = new ArrayList<Module>();
	
	
	//getters setters
	public void setMetiermodule(InterMetierModule metiermodule) {
		this.metiermodule = metiermodule;
	}
	public Module getM() {
		return m;
	}
	public void setM(Module m) {
		this.m = m;
	}
	public Long getIdModule() {
		return idModule;
	}
	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}
	public List<Module> getTab() {
		return tab;
	}
	public void setTab(List<Module> tab) {
		this.tab = tab;
	}
	
	//constructeur
	public ModuleBean() {
		super();
	}
	
	//methodes
	public Module addmod(){
		metiermodule.addmodule(m);
		return m;
	}
	
	public void supmod(){
		metiermodule.deletemodule(idModule);
	}
	
	public Module modifmod(){
		metiermodule.updatemodule(m);
		return m;
	}
	
	public Module getmod(){
		Module m = metiermodule.getmodule(idModule);
		return m;
	}
	
	public List<Module> listmod(){
		tab = metiermodule.getlistmodule();
		return tab;
	}

}
