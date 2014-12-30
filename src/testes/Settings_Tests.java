
package testes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_Settings;
import utilidades.LSC_Support;
import utilidades.ListaResult;
import utilidades.ResultExec;

/**
 * Classe usada para executar os testes de settings
 * Seleciona os checks de todas as opções do "Enable Alerts"
 * Verifica a opção "Welcome Screen" - o check não pode estar ativo antes de teste
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
	
	/**
	 * Método que seleciona os checks, salva as alterações 
	 * e verifica se ao termino possui alertas de "Warning" ou "Error"
	 */

	public List<ResultExec> Select_allchecks(){
		
		listaResultados.add(resultado);
		resultado = new ResultExec("(Settings) - Select all check options");
		listaResultados.add(resultado);
		
		s.wait(3.0);
		
		try {
			resultado = new ResultExec("Button click Settings");
			s.wait(sys.btn_Settings, 50.0);
						
			s.click(sys.btn_Settings);
			
			s.click(sys.enableAlerts_settings);
									
			s.wait(3.0);
				
			
		} catch (FindFailed e) {
			resultado.addMensagens(sys.ImageError);
			e.printStackTrace();
		}
		listaResultados.add(resultado);
		
		titleLSC();
		
		s.wait(5.0);
		
		evaluateTest(sys.memory_settings,"Memory");
		
		evaluateTest(sys.storageDeveices_settings,"Storage Devices");
		
		evaluateTest(sys.hardwareScan_settings,"Harware Scan");
		
		evaluateTest(sys.softwareUpdates_settings,"Software Updates");
		
		evaluateTest(sys.battery_settings,"Battery");
		
		evaluateTest(sys.recoveryMedia_settings,"Recovery Media");
		
		evaluateTest(sys.backup_settings,"Backup");
		
		evaluateTest(sys.deviceManager_settings, "Device Manager");
		
		evaluateTest(sys.warranty_settings,"Warranty");
		
		evaluateTest(sys.virusProtection_settings,"Virus Protection");
		
		evaluateTest(sys.firewall_settings,"Firewall");
		
		evaluateTest(sys.productRegistration_settings,"Product Registration");
		
		
		try {
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
				resultado.addMensagens("Has Warning status");
				s.click(sys.icn_warningBig);		
				}
		
		} catch (FindFailed e) {
			resultado.addMensagens(sys.ImageError);
			e.printStackTrace();
			
		}
		listaResultados.add(resultado);
		return listaResultados;
	}
	
	/**
	 * Recebe o icone e seu nome, para clicar e adicionar a mensagem
	 * no resultado de seu teste
	 */
	public void evaluateTest(String icone, String testName)
	{
		try {
			//s.wait(3.0);
			resultado = new ResultExec(testName+" option");
			s.click(icone,200);
			resultado.addMensagens("Enable "+testName+" ('Passed')");
		} catch (FindFailed e) {
			resultado.addMensagens(sys.ImageError);
			e.printStackTrace();
		}
		listaResultados.add(resultado);
	}

	/**
	 * Metodo para verificar o titulo do LSC
	 * O mouse encontra o título para que a janela continue sendo o foco,
	 * assim nenhuma pop-up ou textos na tela irão atrapalhar a execução
	 */
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
	
	/**
	 * Seleciona a opção Notification Área e salva a alteração
	 * O teste apenas verifica se a opção existe e se salva corretamente
	 */
	public List<ResultExec> notificationArea(){
		
		resultado = new ResultExec("(Settings) - Show LSC window");
	
		try {
			
			s.wait(sys.btn_Settings, 50.0);
						
			s.click(sys.btn_Settings);
			
			s.wait(2.0);
			s.click(sys.LSC_Windows_notification);
									
			s.wait(2.0);
			
			s.wait(1.0);
			s.click(sys.save_settings);
	
			s.wait(2.0);
			s.click(sys.ok_button);
				
			resultado.addMensagens("Passed");
			
		} catch (FindFailed e) {
			resultado.addMensagens(sys.ImageError);
		}
		listaResultados.add(resultado);
		
		return listaResultados;

	}
	
	/**
	 * Teste que seleciona a opção "Alwas show Welcome Screen"
	 * O teste seleciona a opção, salva as alterações na tela settings
	 * fecha o LSC, o reabre e verifica se welcome screen aparece.
	 */
	public List<ResultExec> welcomeScreen(){
		
		resultado = new ResultExec("(Settings) - Welcome Screen");
		try {
			
			s.wait(sys.btn_Settings, 50.0);
						
			s.click(sys.btn_Settings);
			
			s.wait(5.0);
			s.click(sys.welcomeScreen_settings);			
			s.wait(2.0);
			
			s.wait(1.0);
			s.click(sys.save_settings);
	
			s.wait(2.0);
			s.click(sys.ok_button);
				
			s.wait(2.0);
			s.click(sys.LSC_exit);
			
			s.wait(25.0);
			initializeLSC(idioma);
			
			s.wait(sys.alwaysshowWlcomeScreen,20.0);
			s.click(sys.alwaysshowWlcomeScreen,200);
			
			s.click(sys.LSC_welcomeExit,200);
			
			
			resultado.addMensagens("Passed");
			
		} catch (FindFailed e) {
			resultado.addMensagens(sys.ImageError);
			e.printStackTrace();
		}
		listaResultados.add(resultado);
		
		return listaResultados;

	}
	
	public void initializeLSC(String idioma){
		ResultExec resultado = new ResultExec("Reopening LSC - Settings test"); 
		
		try {
			resultado = new ResultExec("LSC initialization");							
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
			resultado.addMensagens("Passed");
		}catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		listaResultados.add(resultado);
		}
	
}
