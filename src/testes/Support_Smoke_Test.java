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
	
	ResultExec resultado = new ResultExec(" Test System");
	
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
			VerificaTela(sys.onlinesupportIcon);
			
			s.wait(2.0);
			s.click(sys.SupportSel);
			VerificaTela(sys.supportModule_WarrantyIcon);
								
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
			
				
		} catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
		
	}
}
