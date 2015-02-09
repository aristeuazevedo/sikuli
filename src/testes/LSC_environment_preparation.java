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
	
	public void settings_preparation(){
		
		resultado = new ResultExec("Alert Exist");				
		s.wait(10.0);
		
		if(utilities.ExistVerify(sys.icn_OkBig)){
			resultado.addMensagens("OK Alert");
			listaResultados.add(resultado);
			//return false;
		} else if (utilities.ExistVerify(sys.icn_errorBig)){
			resultado.addMensagens("Error Alert");
			listaResultados.add(resultado);
		} else if (utilities.ExistVerify(sys.icn_warningBig)){
			resultado.addMensagens("Warning Alert");
			listaResultados.add(resultado);
		}
		//return true;
		
		
	}
	
	public void dashboad_preparation(){
		
	}
	
	
}
