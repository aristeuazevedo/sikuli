package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.Screen;

import utilidades.LSC_Backup;
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

	}
	
	public void welcomescreen(){
		
	}
	
	public void settings_preparation(){
		
		resultado = new ResultExec("Alert Exist");				
		s.wait(10.0);
				
		//selecionar a tab home
		utilities.SelectTab("home", s, sys);
			
		
		if(utilities.ExistVerify(sys.icn_OkBig)){
			resultado.addMensagens("OK Alert");
			listaResultados.add(resultado);
			//return false;
		}
		
		
	}
	
	public void dashboad_preparation(){
		
	}
	
	
}
