package main;

import java.io.File;
import gui.Teste;
import testes.*;
import utilidades.ListaResult;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class MainExec {
	
	static ResultExec resultado = new ResultExec("");
	
	public static void main(String[] args) {
				
		@SuppressWarnings("unused")
		TesteUm t1 = new TesteUm();
		
		Teste t = new Teste();
		
		String nomeMaquina;
		String data;
				
		String s = ""; // recebe a linguagem selecionada na janela
		String idioma = "";
		
		
		//chama a tela de seleção de idiomas
		t.setVisible(true);
		
		//verifica se a tela de seleção ainda está ativa
		while (t.isShowing() == true) {
			s = t.selecao;
		}
		
		nomeMaquina = "maquina 1";
		data = Utilidades.horaData();
		idioma = escolheIdioma(s);
		
		//objeto que carrega as informações da execução
		ListaResult lista = new ListaResult(nomeMaquina, data, s);
						
		lista.addResultado(initializeLSC(idioma));
				
		//criando objeto dos testes
		System_Smoke_Test SystemTest = new System_Smoke_Test(idioma);
		Security_Module_Test SecurityTest = new Security_Module_Test(idioma);
		Checkup_Smoke_Test CheckupTest = new Checkup_Smoke_Test(idioma);
		Support_Smoke_Test SupportTest = new Support_Smoke_Test(idioma);
		
		//Executa o teste
			
		for (ResultExec result : SystemTest.Smoke() ) {
			lista.addResultado(result);
		}
		
		for (ResultExec result : SecurityTest.Smoke() ) {
			lista.addResultado(result);
		}
		
		for (ResultExec result : CheckupTest.Smoke() ) {
			lista.addResultado(result);
		}
		
		//SupportTest.Smoke();
				
		Utilidades.grava(lista);
		
	}

	public static String escolheIdioma(String s) {
		String idioma = "";
		switch (s) {

		case "Danish (da-DK)":
			idioma = "da_DK";
			break;

		case "Dutch ( nl-NL)":
			idioma = "nl_NL";
			break;

		case "English (en-US)":
			idioma = "en_US";
			break;

		case "Finish (fi-FI)":
			idioma = "fi_FI";
			break;

		case "French (fr-FR)":
			idioma = "fr_FR";
			break;

		case "German (de-DE)":
			idioma = "de_DE";
			break;

		case "Italian (it-IT)":
			idioma = "it_IT";
			break;

		case "Japanese (ja-JP)":
			idioma = "ja_JP";
			break;

		case "Korean (ko-KR)":
			idioma = "ko_KR";
			break;

		case "Norwegian (nb-NO)":
			idioma = "nb_NO";
			break;

		case "Polish (pl-PL)":
			idioma = "pl_PL";
			break;

		case "Portuguese (pt-PT)":
			idioma = "pt_PT";
			break;

		case "Portuguese (pt-BR)":
			idioma = "pt_BR";
			break;

		case "Russian (ru-RU)":
			idioma = "ru_RU";
			break;

		case "Simplified Chinese (zh-CN)":
			idioma = "zh_CN";
			break;

		case "Spanish (es-ES)":
			idioma = "es_ES";
			break;

		case "Swedish (sv-SE)":
			idioma = "sv_SE";
			break;

		case "Traditional Chinese (zh-TW)":
			idioma = "zh_TW";
			break;
		}

		return idioma;
	}

	//TODO Executa o LSC com o idioma previamente selecionado
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
}
