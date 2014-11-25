package testes;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.script.*;

import utilidades.LSC_CheckUP;
import utilidades.LSC_Main;
import utilidades.LSC_Security;
import utilidades.LSC_Support;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

/**
 * Classe usada para executar os testes da aba de Support
 * Entra em todos os icones disponíveis ()
 * @author	Aristeu Azevedo
 * @param 	sys 	Possui os caminhos para os arquivos e imagens
 * @param	idioma	Idioma selecionado para realizar os testes
 * @param	resultado	Mensagens e nomes dos testes executados
 * @param	s		Parametro utilizado pelo Sikuli focar a tela a ser testada
 */
public class Support_Smoke_Test {

	LSC_Support sys;
	String idioma = "";
	ResultExec resultado = new ResultExec("Smoke Test Support");
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	Screen s = new Screen();
	
	/**
	 * Construtor para criar os testes com o idioma selecionado
	 * @param	idioma	Idioma selecionado para realizar os testes
	 * @param	sys		Instancia o LSC_Support que armazena os caminhos das
	 * imagens que serão usadas nos testes.
	 */
	public Support_Smoke_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_Support(idioma);
	}
	
	/**
	 * Metodo principal chamado para executar os testes de verificação dos icones
	 */
	public List<ResultExec> Smoke() {
	
			listaResultados.add(resultado);
			
			titleLSC();
			
			tabUnselected();
			
			VerificaTela(sys.onlinesupportIcon);
			
			tabSelected();
			VerificaTela(sys.supportModule_WarrantyIcon);
						
			tabSelected();
			VerificaTela(sys.icn_configHistory);
			
			if(idioma != "zh_CN" && idioma != "zh_TW"){
				tabSelected();
				VerificaTela(sys.icn_ProductRegistration);
			}
				
		return listaResultados;
	}

	/**
	 * Metodo para verificar se o icone clicado corresponde a tela aberta 
	 * pela aplicacao. Adicionao resultado na variavel "resultado".
	 * @param	icone	Icone que sera analisado	
	 */
	public void VerificaTela(String icone)
	{
		try {
			resultado = new ResultExec(Utilidades.nomeIcone(icone));
			s.click(sys.LSC_Title);
			s.wait(icone,10.0);
			s.click(icone);
			
			
			//Configuration History verifica se tem o icone azul de informação
			if(icone == sys.icn_configHistory) {
				s.wait(sys.icn_info, 20);
				s.click(sys.icn_info);
				resultado.addMensagens("Passed");
				//voltar para o lsc comum, pois no configHistory não possui abas laterais
				s.click(sys.btn_back);
				
				
			}
			//Product Registragion
			else if(icone == sys.icn_ProductRegistration) {
				
				if(s.exists(sys.icn_warning) != null)
				{
					s.click(sys.icn_warning);
					resultado.addMensagens("Icon warning (Passed)");
				}
				if(s.exists(sys.icn_aborted) != null)
				{
					s.click(sys.icn_aborted);
					resultado.addMensagens("Icon aborted (Passed)");
				}
				
												
				//voltar para o lsc comum, pois no configHistory não possui abas laterais
				s.click(sys.btn_back);
				
			}
			
			//Online Support
			else if(icone == sys.onlinesupportIcon) {
				//exceção da linguagem chines simpleficado
				if(idioma == "zh_CN"){
					
					s.wait(sys.selfHelp,20);
					
					s.click(sys.selfHelp);
					resultado.addMensagens("Self Help Icon (Passed)");
					
					s.click(sys.onlineRepair);
					resultado.addMensagens("Online Repair Icon (Passed)");
					
					s.click(sys.icn_AskLenovo);
					resultado.addMensagens("Ask Lenovo Icon (Passed)");
					
					s.click(sys.lenovoRobot);
					resultado.addMensagens("Lenovo Robot Icon (Passed)");
					
					s.click(sys.expert);
					resultado.addMensagens("Expert Online Icon (Passed)");
					
					s.click(sys.moreInfo);
					resultado.addMensagens("More Information Icon (Passed)");
				}
				else {
					s.wait(sys.lenovoSupport,20);
					s.click(sys.lenovoSupport);
					resultado.addMensagens("Lenovo Support Icon (Passed)");
					
					
					s.wait(sys.virtualAgente,20);
					s.click(sys.virtualAgente);
					resultado.addMensagens("Virtual Agente Icon (Passed)");
					
					s.wait(sys.lenovoForum,20);
					s.click(sys.lenovoForum);
					resultado.addMensagens("Lenovo Forum Icon (Passed)");
					
					
				}
				
			}
			
			else {
				s.wait(icone,10.0);
				s.click(icone);
				resultado.addMensagens("Passed");
			}
								
		} catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
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
					resultado = new ResultExec("LSC Title verification");		
					s.wait(sys.LSC_Title,30.0);
					s.click(sys.LSC_Title);
					resultado.addMensagens("Passed");
				} catch (FindFailed e) {
					e.printStackTrace();
					resultado.addMensagens(e.toString());
				}
				listaResultados.add(resultado);
		}
		
	/**
	 * Metodo para clicar na aba de Support (nao selecionada)
	 * Utilizado para dar foco na aba Support
	 */
	public void tabUnselected(){
					try {
						resultado = new ResultExec("Tab Support Unselected");
						s.wait(3.0);
						s.click(sys.SupportUns);
						s.wait(2.0);
						resultado.addMensagens("Passed");
					} catch (FindFailed e) {
						resultado.addMensagens(e.toString());
						e.printStackTrace();
					}
					listaResultados.add(resultado);
		}
		
	/**
	 * Metodo para clicar na aba de Suporte (selecionada)
	 * Utilizado para dar foco na aba Support
	 */
	public void tabSelected(){
			try {
				resultado = new ResultExec("Tab Support Selected");
				s.wait(2.0);
				s.click(sys.SupportSel);
				s.wait(2.0);
				resultado.addMensagens("Passed");
			} catch (FindFailed e) {
				resultado.addMensagens(e.toString());
				e.printStackTrace();
			}
			listaResultados.add(resultado);
		}
	

}