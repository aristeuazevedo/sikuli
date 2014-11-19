package main;

import java.io.File;

import gui.TestSelection;
import testes.*;
import utilidades.*;

public class MainExec {
	
	static ResultExec resultado = new ResultExec("");
	static TestsParameters testParam = new TestsParameters();
	static System_Smoke_Test SystemTest ;
	static Security_Module_Test SecurityTest ;
	static Checkup_Smoke_Test CheckupTest ;
	static Support_Smoke_Test SupportTest ;
	
	static ListaResult lista;
	
	
	public static void main(String[] args) {
				
	
		
		//Teste t = new Teste();
		TestSelection window = new TestSelection();
			
		//chama a tela de seleção de idiomas
		window.setVisible(true);
		//verifica se a tela de seleção ainda está ativa
		while (window.isShowing() == true) {
			testParam = window.testParam;
		}
		
		//testParam.setMachineName("maquina 1");
		testParam.setData(Utilidades.horaData());
		
		//objeto que carrega as informações da execução
		lista = new ListaResult(testParam.getMachineName(), testParam.getData(), testParam.getShortIdioma());
		lista.setNomeMaquina(testParam.getMachineName());				
		lista.addResultado(initializeLSC(testParam.getShortIdioma()));
				
		selectSmokeTests();
		
		Utilidades.grava(lista);
		
	}
	
	/**
	 * Chama o bat do LSC com o idioma previamente selecionado
	 */
	public static ResultExec initializeLSC(String idioma){
			
		try {
			resultado = new ResultExec("LSC initialization");							
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
			resultado.addMensagens("Passed");
		}catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
			return resultado;
			
		}	

	public static void selectSmokeTests()
	{
		if (testParam.isSystemSmoke()) {
			System_Smoke_Test SystemTest = new System_Smoke_Test(
					testParam.getShortIdioma());
			for (ResultExec result : SystemTest.Smoke()) {
				lista.addResultado(result);
			}
		}
		
		if (testParam.isSecuritySmoke()) {
			Security_Module_Test SecurityTest = new Security_Module_Test(
					testParam.getShortIdioma());
			for (ResultExec result : SecurityTest.Smoke()) {
				lista.addResultado(result);
			}
		}
		
		
		if (testParam.isCheckupSmoke()) {
			Checkup_Smoke_Test CheckupTest = new Checkup_Smoke_Test(
					testParam.getShortIdioma());
			for (ResultExec result : CheckupTest.Smoke()) {
				lista.addResultado(result);
			}
		}
		
		
		if (testParam.supportSmoke) {
			Support_Smoke_Test SupportTest = new Support_Smoke_Test(
					testParam.getShortIdioma());
			for (ResultExec result : SupportTest.Smoke()) {
				lista.addResultado(result);
			}
		}
		
	}
	
	
}
