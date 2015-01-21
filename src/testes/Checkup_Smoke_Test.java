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
import utilidades.LSC_System;
import utilidades.ResultExec;



public class Checkup_Smoke_Test {
	
	String idioma = "";
	
	LSC_CheckUP sys;
	
	ResultExec resultado = new ResultExec("Smoke Test Check Up");
	
	Screen s = new Screen();
	
	public Checkup_Smoke_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_CheckUP(idioma);
	}
	
	public ResultExec Smoke()
	{	
		try {
			
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
					
			System.out.print(sys.LSC_Title);
			
			
			s.wait(sys.LSC_Title,30.0);
			s.click(sys.LSC_Title);
			
			s.wait(2.0);
			s.click(sys.CheckupUns);
			VerificaTela(sys.icn_hwScan);
			
			s.wait(2.0);
			s.click(sys.CheckupSel);
			VerificaTela(sys.icn_deviceManager);
			
			s.wait(2.0);
			s.click(sys.CheckupSel);
			VerificaTela(sys.icn_snapshot);
			
				
									
		} catch (IOException e) {
					
			System.out.println("Imagem não encontrada");
			e.printStackTrace();
		}catch (Exception e) {
			
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
		
		
		return resultado;
	}
	
	public void VerificaTela(String icone)
	{
		try {
			s.click(sys.LSC_Title);
			s.wait(icone,10.0);
			s.click(icone);
							
			if(icone == sys.icn_snapshot)
				s.wait(sys.icn_save,40.0);
		
		} catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
		
	}
	
	
	

}
