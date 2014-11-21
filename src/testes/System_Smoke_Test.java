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

import utilidades.LSC_Main;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;


/**
 * Classe usada para executar os testes da aba de System
 * Entra em todos os icones disponíveis ()
 * @author	Aristeu Azevedo
 * @param 	sys 	Possui os caminhos para os arquivos e imagens
 * @param	idioma	Idioma selecionado para realizar os testes
 * @param	resultado	Mensagens e nomes dos testes executados
 * @param	s		Parametro utilizado pelo Sikuli focar a tela a ser testada
 */
public class System_Smoke_Test {
	
	LSC_System sys;
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Smoke Test System");
	Screen s = new Screen();
	
	/**
	 * Construtor para criar os testes com o idioma selecionado
	 * @param	idioma	Idioma selecionado para realizar os testes
	 * @param	sys		Instancia o LSC_Support que armazena os caminhos das
	 * imagens que serão usadas nos testes.
	 */
	public System_Smoke_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_System(idioma);
	}
	
	/**
	 * Metodo principal chamado para executar os testesde verificação dos icones
	 */
	public List<ResultExec> Smoke()
	{
		listaResultados.add(resultado);
		titleLSC();
		
		tabUnselected();
						
		VerificaTela(sys.icn_hardDrive);
						
		tabSelected();
		VerificaTela(sys.icn_memory);
			
		tabSelected();
		VerificaTela(sys.icn_backup);
			
		tabSelected();
		VerificaTela(sys.icn_backup);
		
		tabSelected();
		VerificaTela(sys.icn_recoveryMedia);
		
		tabSelected();
		VerificaTela(sys.icn_softwareUpdate);
			
		tabSelected();
		VerificaTela(sys.icn_battery);
		
		tabSelected();
		VerificaTela(sys.icn_systemInfo);
			
		tabSelected();
		VerificaTela(sys.icn_filePrinter);
			
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
			
			//verifica se a tela é a correta
			if(icone == sys.icn_systemInfo ){
				
				s.wait(sys.icn_save,60.0);
				s.click(sys.icn_save);

			}
			else if(icone == sys.icn_filePrinter){
				//s.wait(3.0);
			}
			else if(icone == sys.icn_recoveryMedia) {
				
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
			else
			{
				s.click(sys.LSC_Title);
				s.wait(icone, 10);
				s.click(icone);
			}
			resultado.addMensagens("Passed");
			
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
				//resultado = new ResultExec("LSC Title verification");		
				s.wait(sys.LSC_Title,30.0);
				s.click(sys.LSC_Title);
				//resultado.addMensagens("Passed");
			} catch (FindFailed e) {
				e.printStackTrace();
				resultado.addMensagens(e.toString());
			}
			//listaResultados.add(resultado);
	}

	/**
	 * Metodo para clicar na aba de Support (nao selecionada)
	 * Utilizado para dar foco na aba Support
	 */
	public void tabUnselected(){
				try {
					resultado = new ResultExec("Tab System Unselected");
					s.wait(2.0);
					s.click(sys.SystemUns);
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
			resultado = new ResultExec("Tab System Selected");
			s.wait(2.0);
			s.click(sys.SystemSel);
			s.wait(2.0);
			resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			resultado.addMensagens(e.toString());
			e.printStackTrace();
		}
		listaResultados.add(resultado);
	}
	
}
