package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class LSC_environment_preparation {
	
	LSC_System sys;
	
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Backup Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	
	public LSC_environment_preparation(String idioma) {
		this.idioma = idioma;
		sys = new LSC_System(idioma);
		
		welcomescreen();
		anonimous_message();
		
	}
		 
	
	public void welcomescreen() {
		s.wait(10.0);
		try {
			if(s.exists(sys.LSC_welcomeScreen)!=null){
			
			s.hover(sys.LSC_welcomeScreen);
			
			s.click(sys.alwaysshowWlcomeScreen);
				
			s.click(sys.LSC_welcomeExit);
			}
			
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		
	}
	
	public void anonimous_message(){
		s.wait(5.0);
		try {
			if(s.exists(sys.anonimous_message)!=null){
						
			s.hover(sys.anonimous_message);
			
			s.click(sys.anonimous_yes);
			}
			
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		
	}
	
	public void settings_preparation(){
		
		resultado = new ResultExec("Alert Exist");				
		s.wait(10.0);
				
		//selecionar a tab home
		utilities.SelectTab("home", s, sys);
			
		
		if(utilities.ExistVerify(sys.icn_warningBig)){
			resultado.addMensagens("OK Alert");
			listaResultados.add(resultado);
			//return false;
		}
		
		
	}
	
	public void dashboad_preparation(){
		
	}
	
	
}
