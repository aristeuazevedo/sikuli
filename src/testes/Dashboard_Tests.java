package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_CheckUP;
import utilidades.LSC_Dashboard;
import utilidades.LSC_Security;
import utilidades.LSC_Support;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class Dashboard_Tests {

	LSC_Dashboard sys;
	LSC_System system;
	LSC_Security security;
	LSC_Support support;
	LSC_CheckUP checkup;
	String idioma = "";
	ResultExec resultado = new ResultExec("Dashboard Tests");
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	Screen s = new Screen();
	Utilidades utilidades = new Utilidades();
	
	public Dashboard_Tests(String idioma) {
		super();
		this.idioma = idioma;
		sys = new LSC_Dashboard(idioma); 
		system = new LSC_System(idioma);
		security = new LSC_Security(idioma);
		support = new LSC_Support(idioma);
		checkup = new LSC_CheckUP(idioma);
		}
	
public List<ResultExec> verify_Test(){
		
		listaResultados.add(resultado);
		
		
		titleLSC();
		
		openDashScreen();
		
		allIconClicks();
					
		return listaResultados;
	}

public void SelectTabHome()
{
	resultado = new ResultExec("Home tab");
	try{
			s.click(sys.HomeSel, 200);
			resultado.addMensagens("Tab Selected Passed");
	} catch (FindFailed e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		try{
		s.click(sys.HomeUns, 200);
		resultado.addMensagens("Tab Unselected Passed");
		} catch (FindFailed e1) {
			e1.printStackTrace();
		}
	}
	listaResultados.add(resultado);
	
	try{
		resultado = new ResultExec("Alert Button");
		s.click(sys.alert_button);
		resultado.addMensagens("Passed");
		listaResultados.add(resultado);
	}catch (FindFailed e) {	
		e.printStackTrace();
	}
	listaResultados.add(resultado);
		
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

public void openDashScreen(){

	try{	
		resultado = new ResultExec("Dashboard open Screen");				
				
		s.click(sys.dashboard_button, 700);
		
		s.click(sys.system_dashboard, 700);
		
		s.click(sys.security_dashboard, 700);
		
		s.click(sys.checkup_dashboard, 700);
		
		resultado.addMensagens("Passed");
		listaResultados.add(resultado);
		
	} catch (FindFailed e) {	
		e.printStackTrace();
	}
	
}

public void allIconClicks(){
	try{	
		resultado = new ResultExec("All Icons Verify");				
				
		s.click(sys.dashboard_button, 1000);
		s.doubleClick(sys.LSC_Title);
		
		//s.click(system.icn_hardDrive);
		s.click(system.icn_memory);			
					
		resultado.addMensagens("Passed");
		listaResultados.add(resultado);
		
	} catch (FindFailed e) {	
		e.printStackTrace();
	}
}

public void verifyButton(){
	try{	
		resultado = new ResultExec("Verify Buttons");				
				
		s.click(sys.dashboard_button, 700);
		
		s.click(sys.system_dashboard, 700);
		
		s.click(sys.security_dashboard, 700);
		
		s.click(sys.checkup_dashboard, 700);
		
		resultado.addMensagens("Passed");
		listaResultados.add(resultado);
		
	} catch (FindFailed e) {	
		e.printStackTrace();
	}
}
	


}



