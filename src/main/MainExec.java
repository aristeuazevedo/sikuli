package main;

import java.io.File;

import gui.Teste;
import testes.*;
import utilidades.ListaResult;
import utilidades.ResultExec;
import utilidades.TestsParameters;
import utilidades.Utilidades;
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
				
	
		
		Teste t = new Teste();
			
		//chama a tela de seleção de idiomas
		t.setVisible(true);
		//verifica se a tela de seleção ainda está ativa
		while (t.isShowing() == true) {
			testParam.setIdioma(t.selecao);
		}
		
		testParam.setMachineName("maquina 1");
		testParam.setData(Utilidades.horaData());
		testParam.setShortIdioma(escolheIdioma(testParam.getIdioma()));
		
		//objeto que carrega as informações da execução
		lista = new ListaResult(testParam.getMachineName(), testParam.getData(), testParam.getShortIdioma());
						
		lista.addResultado(initializeLSC(testParam.getShortIdioma()));
		
		//Executa o teste
		testParam.setSystemSmoke(true);
		testParam.setCheckupSmoke(true);
		testParam.setSecuritySmoke(true);
		testParam.setSupportSmoke(true);
		
		selectSmokeTests();
		
		Utilidades.grava(lista);
		
	}

	/**
	 * Metodo para retornar a linguagem selecionada, a string retornada e usada para formar o caminho das imagens 
	 */
	public static String escolheIdioma(String s) {
		
		switch (s) {

		case "Danish (da-DK)":
			return "da_DK";
			
		case "Dutch (nl-NL)":
			return "nl_NL";

		case "English (en-US)":
			return "en_US";

		case "Finish (fi-FI)":
			return "fi_FI";

		case "French (fr-FR)":
			return "fr_FR";

		case "German (de-DE)":
			return "de_DE";

		case "Italian (it-IT)":
			return "it_IT";
		
		case "Japanese (ja-JP)":
			return "ja_JP";

		case "Korean (ko-KR)":
			return "ko_KR";

		case "Norwegian (nb-NO)":
			return "nb_NO";

		case "Polish (pl-PL)":
			return "pl_PL";
			
		case "Portuguese (pt-PT)":
			return "pt_PT";

		case "Portuguese (pt-BR)":
			return "pt_BR";

		case "Russian (ru-RU)":
			return "ru_RU";

		case "Simplified Chinese (zh-CN)":
			return "zh_CN";

		case "Spanish (es-ES)":
			return "es_ES";

		case "Swedish (sv-SE)":
			return "sv_SE";

		case "Traditional Chinese (zh-TW)":
			return "zh_TW";
		}

		return "";
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
