package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_Settings;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class AlertTests {
	
	LSC_Settings sys;
	String idioma = "";
	ResultExec resultado = new ResultExec("Alert tests");
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	Screen s = new Screen();
	Utilidades utilidades = new Utilidades();
	
	public AlertTests(String idioma) {
		super();
		this.idioma = idioma;
		sys = new LSC_Settings(idioma);
		
		}
	
	public List<ResultExec> verify_Test(){
		
		listaResultados.add(resultado);
		resultado = new ResultExec("Button click Settings");
		
		s.wait(10.0);
		
		titleLSC();
		
		SelectTabHome();
				
		if(AlertExist()){
			AlertDisable();
		}
		else{
			AlertDisable();
			AlertDisable();
		}
		    		
		//fazer rotina de habiliar na settings e verificar alerta
		s.wait(4.0);
		if(AlertIconEnable(sys.memory_settings))
			AlertDisable();
		
		if(AlertIconEnable(sys.storageDeveices_settings))
			AlertDisable();
		
		if(AlertIconEnable(sys.hardwareScan_settings))
			AlertDisable();		
		
		if(AlertIconEnable(sys.softwareUpdates_settings))
			AlertDisable();
		
		if(AlertIconEnable(sys.battery_settings))
			AlertDisable();
		
		if(AlertIconEnable(sys.recoveryMedia_settings))
			AlertDisable();
				
		if(AlertIconEnable(sys.backup_settings))
			AlertDisable();
		
		if(AlertIconEnable(sys.deviceManager_settings))
			AlertDisable();
				
		if(AlertIconEnable(sys.warranty_settings))
			AlertDisable();
		
		if(AlertIconEnable(sys.virusProtection_settings))
			AlertDisable();
		
		if(AlertIconEnable(sys.firewall_settings))
			AlertDisable();
		
		if(AlertIconEnable(sys.productRegistration_settings))
			AlertDisable();
		
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
			
		}catch (FindFailed e) {	
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		listaResultados.add(resultado);
			
	}

	public Boolean Alert_Exist(){
			
		resultado = new ResultExec("Alert Exist");				
		s.wait(10.0);
		try{
			s.click(sys.icn_OkBig);
			resultado.addMensagens("OK Alert");
			listaResultados.add(resultado);
			return false;
			
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
	return true;
	}
	
	public Boolean AlertExist(){
		
		resultado = new ResultExec("Alert Exist");				
		s.wait(10.0);
		
		if(utilidades.ExistVerify(sys.icn_OkBig)){
			resultado.addMensagens("OK Alert");
			listaResultados.add(resultado);
			return false;
		} else if (utilidades.ExistVerify(sys.icn_errorBig)){
			resultado.addMensagens("Error Alert");
			listaResultados.add(resultado);
		} else if (utilidades.ExistVerify(sys.icn_warningBig)){
			resultado.addMensagens("Warning Alert");
			listaResultados.add(resultado);
		}
		return true;
		/*
		try{
			s.click(sys.icn_OkBig);
			
			return false;
			
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
	return true;*/
	}
	
	public void	AlertDisable(){
		
		try{	
			//
			//resultado = new ResultExec("Button 'Settings'");				
			s.wait(sys.btn_Settings, 50.0);
				
			s.click(sys.btn_Settings, 200);
			
			//resultado.addMensagens("Passed");
			//listaResultados.add(resultado);
			
			//
			s.wait(5.0);
			resultado = new ResultExec("Disable settings");	
			s.click(sys.enableAlerts_settings);
			s.click(sys.save_settings);
			s.click(sys.ok_button);
			resultado.addMensagens("Passed");
			listaResultados.add(resultado);
			
		} catch (FindFailed e) {	
			e.printStackTrace();
		}
	}
	
	public Boolean AlertIconEnable(String icone){
		String nome_icone;
		
		nome_icone = utilidades.redefineNomeIcone(icone);
		
		try{	
			resultado = new ResultExec("Verify "+nome_icone+" Alert");				
					
			s.click(sys.btn_Settings, 700);
			
			s.click(icone);
			
			s.click(sys.save_settings);
			
			s.click(sys.ok_button);
			
			resultado.addMensagens("Passed");
			listaResultados.add(resultado);
			
			AlertExist();
			
			return true;
			
		} catch (FindFailed e) {	
			e.printStackTrace();
		}
		return false;
	}
	

	
}
