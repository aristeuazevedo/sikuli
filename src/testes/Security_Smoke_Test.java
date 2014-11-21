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

@SuppressWarnings("unused")
public class Security_Smoke_Test {
	
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	
	String idioma = "";
	
	LSC_Security sys;
	
	ResultExec resultado = new ResultExec("Smoke Test Security");
	
	Screen s = new Screen();

	public Security_Smoke_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_Security(idioma);
	}
	
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
			resultado.addMensagens(e.toString());
		}
		listaResultados.add(resultado);
	}

	//TODO Verificação do Titulo do LSC
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
			listaResultados.add(resultado);
	}
	
	//TODO Verifica a aba System não selecionada
	public void tabUnselected(){
		try {
			resultado = new ResultExec("Tab Security Unselected");
			s.wait(2.0);
			s.click(sys.SecurityUns);
			s.wait(2.0);
			resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			resultado.addMensagens(e.toString());
			e.printStackTrace();
		}
		listaResultados.add(resultado);
}

	//TODO Verifica a aba System selecionada
	public void tabSelected(){
		try {
			resultado = new ResultExec("Tab Security Selected");
			s.wait(2.0);
			s.click(sys.SecuritySel);
			s.wait(2.0);
			resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			resultado.addMensagens(e.toString());
			e.printStackTrace();
		}
			listaResultados.add(resultado);
		}	
	
	}




