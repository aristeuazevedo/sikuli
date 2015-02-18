package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_Backup;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class Backup_Test {
	LSC_Backup sys;
	LSC_System system;
	
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Backup Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
		
	public Backup_Test(String idioma) {
		this.idioma = idioma;
		system = new LSC_System(idioma);
		sys = new LSC_Backup(idioma);
	}

	public List<ResultExec> backup_test(){
		listaResultados.add(resultado);
		
		titleLSC();
		
		getStorage();
		
		anotherTool();
		
		return listaResultados;
		
	}
	
	public void getStorage(){
		
		resultado = new ResultExec("Get Storage");
		
		try {
			if(utilities.ExistVerify(sys.SystemUns)){
				s.click(sys.SystemUns);
			}
				
			else{
				s.click(sys.SystemSel);
			}
			
			titleLSC();
			
			s.click(system.icn_backup);
			
			s.click(sys.getStorage);
			
			s.click(sys.shopnow);

			s.wait(5.0);
			
			exitShopNow();
			
			resultado.addMensagens("Passed");
			
		}catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		listaResultados.add(resultado);
		
	}
	
	public void anotherTool(){
		
		resultado = new ResultExec("Another Tool");
		
		try {
			
			titleLSC();
			
			s.click(sys.anothertool);
			
			s.hover(sys.anothertoolcheck);

			s.wait(3.0);
			
			resultado.addMensagens("Passed");
												
		}catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		listaResultados.add(resultado);
		
	}
	
	public void lenovoTips(){
		
	}
	
	
	public void exitShopNow(){

		try {					
			Runtime.getRuntime().exec("taskkill.exe /IM iexplore.exe /F"); 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void titleLSC(){
		
		try {
			//resultado = new ResultExec("LSC Title verification");		
			s.wait(sys.LSC_Title,30.0);
			s.click(sys.LSC_Title);
			//resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		//listaResultados.add(resultado);
	}
}
