package main;
import gui.Teste;
import testes.*;
import utilidades.ResultExec;

public class MainExec {

	public static void main(String[] args) {

		ResultExec resultado = new ResultExec("");

		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		TesteUm t1 = new TesteUm();
		
		Teste t = new Teste();
		String s = ""; // recebe a linguagem selecionada na janela
		String idioma = "";

		t.setVisible(true);

		while (t.isShowing() == true) {
			s = t.selecao;

		}

		idioma = escolheIdioma(s);
		System.out.print(idioma);
		System_Smoke_Test SystemTeste = new System_Smoke_Test(idioma);

		// resultado = t1.teste(idioma);
		resultado = SystemTeste.Smoke();
		System.out.print(resultado.getNomeTeste());

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

}
