package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_Settings;
import utilidades.ResultExec;

public class AlertTests {
	
	LSC_Settings sys;
	String idioma = "";
	ResultExec resultado = new ResultExec("Alert test");
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	Screen s = new Screen();
	
	public AlertTests(String idioma) {
		super();
		this.idioma = idioma;
		sys = new LSC_Settings(idioma);
		
		}
	
	public List<ResultExec> verify_Test(){
		
		resultado = new ResultExec("Button click Settings");
					
		titleLSC();
			
		SelectTabHome();
				
		AlertExist();
		    		
		try{	
			resultado = new ResultExec("Button 'Settings'");				
			s.wait(sys.btn_Settings, 50.0);
				
			s.click(sys.btn_Settings, 200);
			resultado.addMensagens("Passed");
			listaResultados.add(resultado);
		
		} catch (FindFailed e) {	
			e.printStackTrace();
		}
		
		
		
		return listaResultados;
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

	public Boolean AlertExist(){
			
		resultado = new ResultExec("Alert Exist");				
		s.wait(10.0);
		try{
			s.click(sys.icn_OkBig);
			resultado.addMensagens("OK Alert");
			listaResultados.add(resultado);
			return true;
			
			} catch (FindFailed e) {	
				
				e.printStackTrace();
				
				try{
					s.click(sys.icn_errorBig);
					resultado.addMensagens("Error Alert");
				}catch (FindFailed e1) {	
					e1.printStackTrace();
				}
				
				try{
					s.click(sys.icn_warningBig);
					resultado.addMensagens("Warning Alert");
				}catch (FindFailed e1) {	
					e1.printStackTrace();
				}
				
				listaResultados.add(resultado);
		}
			
	return false;
		
		
		
	}
	
}
