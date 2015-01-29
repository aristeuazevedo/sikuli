package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_Backup;
import utilidades.LSC_Software_Updates;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class Software_Updates_Test {

	LSC_Software_Updates sys;
	LSC_System system;
	
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Software Updates Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	
	public Software_Updates_Test(String idioma) {
		this.idioma = idioma;
		system = new LSC_System(idioma);
		sys = new LSC_Software_Updates(idioma);
	}
	
	public List<ResultExec> soft_updates_test(){
		listaResultados.add(resultado);
		
		resultado = new ResultExec("Software Updates Link");
		try {
			
			if(utilities.ExistVerify(system.SystemUns)){
				s.click(system.SystemUns);
			}
				
			else{
				s.click(system.SystemSel);
			}
						
			s.click(system.icn_softwareUpdate);
			
			s.click(sys.SU_Download_link);
			s.click(sys.SU_Screen_Descrip);
			s.click(sys.SU_Screen_Title);
			s.click(sys.SU_No_Lenovo_Software);
			
			
		
			s.wait(3.0);
			
			
					
			resultado.addMensagens("Passed");
			listaResultados.add(resultado);
			
		}catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		
		
		
		return listaResultados;
	}
	
	
}
