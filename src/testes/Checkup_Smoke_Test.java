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
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;


/**
 * Classe usada para executar os testes da aba de Checkup
 * Entra em todos os icones disponíveis ()
 * @author	Aristeu Azevedo
 * @param 	sys 	Possui os caminhos para os arquivos e imagens
 * @param	idioma	Idioma selecionado para realizar os testes
 * @param	resultado	Mensagens e nomes dos testes executados
 * @param	s		Parametro utilizado pelo Sikuli focar a tela a ser testada
 */
public class Checkup_Smoke_Test {
	
	LSC_CheckUP sys;
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Smoke Test Check Up");
	Screen s = new Screen();
	
	/**
	 * Construtor para criar os testes com o idioma selecionado
	 * @param	idioma	Idioma selecionado para realizar os testes
	 * @param	sys		Instancia o LSC_Checkup que armazena os caminhos das
	 * imagens que serão usadas nos testes.
	 */
	public Checkup_Smoke_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_CheckUP(idioma);
	}
	
	/**
	 * Metodo principal chamado para executar os testes de verificação dos icones
	 */
	public List<ResultExec> Smoke()
	{	
		
		listaResultados.add(resultado);
		titleLSC();
		
		tabUnselected();

		tabSelected();	
		VerificaTela(sys.icn_hwScan);
			
			
		tabSelected();
		VerificaTela(sys.icn_deviceManager);
			
		tabSelected();
		VerificaTela(sys.icn_snapshot);
			
				
		
		return listaResultados;
	}
	
	/**
	 * Metodo para verificar se o icone clicado corresponde a tela aberta 
	 * pela aplicacao. Adicionao resultado na variavel "resultado".
	 * @param	icone	Icone que sera analisado	
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
	 * Metodo para verificar o titulo do LSC
	 * O mouse encontra o título para que a janela continue sendo o foco,
	 * assim nenhuma pop-up ou textos na tela irão atrapalhar a execução
	 */
	public void VerificaTela(String icone)
	{
		try {
			s.click(sys.LSC_Title);
			resultado = new ResultExec(Utilidades.nomeIcone(icone));
			s.wait(icone,10.0);
			s.click(icone);
							
			if(icone == sys.icn_snapshot){
				s.wait(sys.icn_save,40.0);
				s.click(sys.icn_save);
				listaResultados.add(resultado);
			}
		
			
			else {
				s.click(sys.LSC_Title);
				s.wait(icone, 10.0);
				s.click(icone);
				resultado.addMensagens("Passed");
			}
			
			resultado.addMensagens("Passed");
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
		
	}
	
	/**
	 * Metodo para clicar na aba de Security (nao selecionada)
	 * Utilizado para dar foco na aba Security
	 */
	public void tabUnselected(){
				try {
					resultado = new ResultExec("Tab Checkup Unselected");
					s.wait(2.0);
					s.click(sys.CheckupUns);
					s.wait(2.0);
					resultado.addMensagens("Passed");
				} catch (FindFailed e) {
					resultado.addMensagens(e.toString());
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
				resultado = new ResultExec("Tab Checkup Selected");
				s.wait(2.0);
				s.click(sys.CheckupSel);
				s.wait(2.0);
				resultado.addMensagens("Passed");
			} catch (FindFailed e) {
				resultado.addMensagens(e.toString());
				e.printStackTrace();
			}
			listaResultados.add(resultado);
	}
}
