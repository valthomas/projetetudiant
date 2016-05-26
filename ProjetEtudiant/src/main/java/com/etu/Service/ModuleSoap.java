package com.etu.Service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.etu.Entities.Module;
import com.etu.Metier.InterMetierModule;

@WebService
public class ModuleSoap {
	
	@Autowired
	private InterMetierModule metiermodule;
	
	@WebMethod
	public Module addmod(){
		Module m = new Module();
		return metiermodule.addmodule(m);
	}
	
	@WebMethod
	public void supmod(@WebParam Long idModule){
		metiermodule.deletemodule(idModule);
	}
	
	@WebMethod
	public Module modifmod(){
		Module m = new Module();
		return metiermodule.updatemodule(m);
	}
	
	@WebMethod
	public Module getmod(@WebParam Long idModule){
		return metiermodule.getmodule(idModule);
	}
	
	@WebMethod
	public List<Module> listmod(){
		return metiermodule.getlistmodule();
	}

}
