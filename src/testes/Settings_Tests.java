
package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_Settings;
import utilidades.LSC_Support;
import utilidades.ResultExec;

/**
 * Classe usada para executar os testes da aba de Support
 * Entra em todos os icones disponíveis ()
 * @author	Aristeu Azevedo
 * @param 	sys 	Possui os caminhos para os arquivos e imagens
 * @param	idioma	Idioma selecionado para realizar os testes
 * @param	resultado	Mensagens e nomes dos testes executados
 * @param	s		Parametro utilizado pelo Sikuli focar a tela a ser testada
 */

public class Settings_Tests {

	
	LSC_Settings sys;
	String idioma = "";
	ResultExec resultado = new ResultExec("Settings test");
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	Screen s = new Screen();
	
	public Settings_Tests(String idioma) {
		super();
		this.idioma = idioma;
		sys = new LSC_Settings(idioma);
		
		}
	
	
	public List<ResultExec> Select_allchecks(){
		listaResultados.add(resultado);
		
		resultado = new ResultExec("(Settings) - Select all check options");	
		
		try {
			
			s.wait(sys.btn_Settings, 50.0);
			
			s.click(sys.btn_Settings);
			s.wait(3.0);
			
			if(s.exists(sys.enable_alert_checked) != null){
				s.wait(1.0);
				s.click(sys.enable_alert_checked);
			}
			
				s.wait(1.0);
				s.click(sys.memory_settings);
				s.wait(1.0);
				s.click(sys.storageDeveices_settings);
				s.wait(1.0);
				s.click(sys.hardwareScan_settings);
				s.wait(1.0);
				s.click(sys.softwareUpdates_settings);
				s.wait(1.0);
				s.click(sys.battery_settings);
				
				s.wait(1.0);
				if(s.exists(sys.recoveryMedia_settings) != null){
				s.click(sys.recoveryMedia_settings);
				
				resultado.addMensagens("Has Recovery Media");
				}
				
				s.wait(1.0);
				s.click(sys.backup_settings);
				s.wait(1.0);
				s.click(sys.deviceManager_settings);
				s.wait(1.0);
				s.click(sys.warranty_settings);
				s.wait(1.0);
				s.click(sys.virusProtection_settings);
				s.wait(1.0);
				s.click(sys.firewall_settings);
				s.wait(1.0);
				s.click(sys.productRegistration_settings);
				
				s.wait(1.0);
				s.click(sys.save_settings);
				
				s.wait(2.0);
				s.click(sys.ok_button);
				
				s.wait(2.0);
				
				
				if(s.exists(sys.icn_errorBig) != null){
					s.click(sys.icn_errorBig);
					resultado.addMensagens("Has Error status");
				}
				
				
				if(s.exists(sys.icn_warningBig) != null){
					s.click(sys.icn_warningBig);
					resultado.addMensagens("Has Warning status");
				}
				
				resultado.addMensagens("Passed");
				listaResultados.add(resultado);
				
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaResultados;
	}
	
	public List<ResultExec> clickTest(){
		
		listaResultados.add(resultado);
		
		resultado = new ResultExec("(Settings) - Select all check options");
		
		try {
			s.wait(sys.btn_Settings, 50.0);
			s.click(sys.btn_Settings);
			s.wait(2.0);
			s.click(sys.anounimous_usage_settings);
			s.wait(2.0);
			s.click(sys.backup_settings);
			s.wait(2.0);
			s.click(sys.battery_settings);
			s.wait(2.0);
			s.click(sys.deviceManager_settings);
			s.wait(2.0);
			s.click(sys.firewall_settings);
			s.wait(2.0);
			s.click(sys.hardwareScan_settings);
			s.wait(2.0);
			s.click(sys.LSC_Windows_notification);
			s.wait(2.0);
			s.click(sys.memory_settings);
			s.wait(2.0);
			s.click(sys.productRegistration_settings);
			s.wait(2.0);
			s.click(sys.recoveryMedia_settings);
			s.wait(2.0);
			s.click(sys.softwareUpdates_settings);
			s.wait(2.0);
			s.click(sys.storageDeveices_settings);
			s.wait(2.0);
			s.click(sys.virusProtection_settings);
			s.wait(2.0);
			s.click(sys.warranty_settings);
			s.wait(2.0);
			s.click(sys.welcomeScreen_settings);
			s.wait(2.0);
			s.click(sys.save_settings);
			s.wait(2.0);
			s.click(sys.ok_button);
			s.wait(2.0);
			s.click(sys.btn_Settings);
			s.wait(2.0);
			s.click(sys.cancel_settings);
			
			
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaResultados;

	}
	
	
}
