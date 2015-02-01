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

public class Support_Smoke_Test {
	String idioma = "";
	
	LSC_Support sys;
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Smoke Test Support");
	
	Screen s = new Screen();
	
	public Support_Smoke_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_Support(idioma);
	}
	
	public List<ResultExec> Smoke() {
	
			listaResultados.add(resultado);
			
			titleLSC();
			
			tabUnselected();
			
			VerificaTela(sys.onlinesupportIcon);
			
			tabSelected();
			VerificaTela(sys.supportModule_WarrantyIcon);
						
			tabSelected();
			VerificaTela(sys.icn_configHistory);
			
				
		return listaResultados;
	}

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
			}
			
			//Online Support
			else if(icone == sys.onlinesupportIcon) {
				//exceção da linguagem chines simpleficado
				if(idioma == "zh_CN"){
					
					s.wait(sys.selfHelp,20);
					
					s.click(sys.selfHelp);
					
					s.click(sys.onlineRepair);
					
					s.click(sys.icn_AskLenovo);
					
					s.click(sys.lenovoRobot);
					
					s.click(sys.expert);
					
					s.click(sys.moreInfo);
					
				}
				else {
					s.wait(sys.virtualAgente,20);
					s.click(sys.virtualAgente);
				}
			}
			
			else {
				s.wait(icone);
			}
			
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
		
	//TODO Verifica a aba System não selecionada
	public void tabUnselected(){
					try {
						resultado = new ResultExec("Tab Support Unselected");
						s.wait(2.0);
						s.click(sys.SupportUns);
						s.wait(2.0);
						resultado.addMensagens("Passed");
					} catch (FindFailed e) {
						resultado.addMensagens(e.toString());
						e.printStackTrace();
					}
					listaResultados.add(resultado);
		}
		
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