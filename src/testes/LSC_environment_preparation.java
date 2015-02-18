package testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_Settings;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;


/**
 * Class used to prepare the LSC to run the tests 
 * @author	Aristeu Azevedo
 * @param 	sys			It has the paths to the files and images
 * @param	idioma		Language select to be executed
 * @param	resultado	Messages and names of the executed tests
 * @param	s			Parameter used by Sikuli to monitor the screen
 * @param	utilities	instance which has some common methods 
 */
public class LSC_environment_preparation {
	
	LSC_Settings sys;
	
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	/**
	 * Main method, it invoke others methods to prepare the LSC to be tested 
	 */
	public LSC_environment_preparation(String idioma) {
		this.idioma = idioma;
		sys = new LSC_Settings(idioma);
		
		welcomescreen();
		s.wait(2.0);
		anonimous_message();
		s.wait(2.0);
		settings_preparation();
	}
		 
	/**
	 * Method to verify if the welcome screen is on and disable it  
	 */
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
	
	/**
	 * Method to verify if the anonymous screen is on and disable it  
	 */
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
	
	/**
	 * Method to verify if the alerts is disable, if them are disabled this
	 * method invoke the AlertEnabled to turn them on 
	 */
	public void settings_preparation(){
		
		resultado = new ResultExec("Alert Exist");				
		s.wait(10.0);
				
		//selecionar a tab home
		utilities.SelectTab("home", s, sys);
		try {
			s.click(sys.alert_button);
		} catch (FindFailed e) {
			
			e.printStackTrace();
		}
		if(s.exists(sys.alerts_turned_off)!=null){
			
			AlertEnable();
			
			//resultado.addMensagens("OK Alert");
			//listaResultados.add(resultado);
			//return false;
		}
		
		
	}
	
	/**
	 * This Method turn on all the alerts at settings screen
	 */
	public void	AlertEnable(){
		
		try{	
			//
			//resultado = new ResultExec("Button 'Settings'");				
			s.wait(sys.btn_Settings, 50.0);
				
			s.click(sys.btn_Settings, 200);
			
			//resultado.addMensagens("Passed");
			//listaResultados.add(resultado);
			
			s.wait(5.0);
			//resultado = new ResultExec("Disable settings");	
			s.click(sys.enableAlerts_settings);
			s.click(sys.save_settings);
			s.click(sys.ok_button);
			//resultado.addMensagens("Passed");
			//listaResultados.add(resultado);
			
		} catch (FindFailed e) {	
			e.printStackTrace();
		}
	}
	
	public static void UAC_nevernotify(){
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("cmd /c start \"\" \"cmds/uac.lnk");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
