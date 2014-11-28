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
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

/**
 * Classe usada para executar os testes da aba de Security
 * Entra em todos os icones disponíveis ()
 * @author	Aristeu Azevedo
 * @param 	sys 	Possui os caminhos para os arquivos e imagens
 * @param	idioma	Idioma selecionado para realizar os testes
 * @param	resultado	Mensagens e nomes dos testes executados
 * @param	s		Parametro utilizado pelo Sikuli focar a tela a ser testada
 */
public class Security_Smoke_Test {
	
	LSC_Security sys;
	String idioma = "";
	ResultExec resultado = new ResultExec("Smoke Test Security");
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	Screen s = new Screen();

	/**
	 * Construtor para criar os testes com o idioma selecionado
	 * @param	idioma	Idioma selecionado para realizar os testes
	 * @param	sys		Instancia o LSC_Security que armazena os caminhos das
	 * imagens que serão usadas nos testes.
	 */
	public Security_Smoke_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_Security(idioma);
	}
	
	/**
	 * Metodo principal chamado para executar os testes de verificação dos icones
	 */
	public List<ResultExec> Smoke() {
		
		listaResultados.add(resultado);	
		titleLSC();
			
		tabUnselected();
			
		VerificaTela(sys.icn_virusProtection);
			
		tabSelected();
		VerificaTela(sys.icn_password);
			
		tabSelected();
		VerificaTela(sys.icn_firewall);
			
		tabSelected();
		VerificaTela(sys.icn_internet);
			
		tabSelected();
		VerificaTela(sys.icn_fingerprint);
											
					
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
			s.click(sys.LSC_Title);
			resultado = new ResultExec(Utilidades.nomeIcone(icone));
			s.wait(icone,10.0);
			s.click(icone);
			
			s.click(sys.LSC_Title);
			s.wait(icone, 10);
			s.click(icone);
			
			resultado.addMensagens("Passed");
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
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
			listaResultados.add(resultado);
	}
	
	/**
	 * Metodo para clicar na aba de Security (nao selecionada)
	 * Utilizado para dar foco na aba Security
	 */
	public void tabUnselected(){
		try {
			resultado = new ResultExec("Tab Security Unselected");
			s.wait(2.0);
			s.click(sys.SecurityUns);
			s.wait(2.0);
			resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			resultado.addMensagens(sys.ImageError);
			e.printStackTrace();
		}
		listaResultados.add(resultado);
}

	/**
	 * Metodo para clicar na aba de Security (selecionada)
	 * Utilizado para dar foco na aba Security
	 */
	public void tabSelected(){
		try {
			resultado = new ResultExec("Tab Security Selected");
			s.wait(2.0);
			s.click(sys.SecuritySel);
			s.wait(2.0);
			resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			resultado.addMensagens(sys.ImageError);
			e.printStackTrace();
		}
			listaResultados.add(resultado);
		}	
	
	}




