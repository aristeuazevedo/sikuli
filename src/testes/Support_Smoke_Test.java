package testes;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

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

public class Support_Smoke_Test {
	String idioma = "";
	
	LSC_Support sys;
	
	ResultExec resultado = new ResultExec(" Test Support");
	
	Screen s = new Screen();
	public Support_Smoke_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_Support(idioma);
	}
	
	public void Smoke() {
		try {
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
			
			System.out.print(sys.LSC_Title);
			
			s.wait(sys.LSC_Title,30.0);
			s.click(sys.LSC_Title);
			
			s.wait(2.0);
			s.click(sys.SupportUns);
			s.wait(2.0);
			VerificaTela(sys.onlinesupportIcon);
			
			s.wait(2.0);
			s.click(sys.SupportSel);
			s.wait(2.0);
			VerificaTela(sys.supportModule_WarrantyIcon);
						
			s.wait(2.0);
			s.click(sys.SupportSel);
			s.wait(2.0);
			VerificaTela(sys.icn_configHistory);
			
			
								
			} catch (IOException e) {
			
			System.out.println("Imagem não encontrada");
			e.printStackTrace();
			}catch (Exception e) {
			
			e.printStackTrace();
			resultado.addMensagens(e.toString());
			}				
		
	}

	
	public void VerificaTela(String icone)
	{
		try {
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
			
			
			
				
		} catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
		
	}
}
