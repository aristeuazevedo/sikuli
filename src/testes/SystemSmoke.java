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

import utilidades.LSC_System;
import utilidades.ResultExec;


@SuppressWarnings("unused")
public class SystemSmoke {
	
	String SysTabUns = " ";
	String SysTabSel = " ";
	String idioma = " ";
	
	LSC_System sys;
	
	ResultExec resultado = new ResultExec("Smoke Test");
	
	Screen s = new Screen();
			
	public SystemSmoke( String idioma){
		
		this.idioma = idioma;
		
		SysTabUns = "imgs/"+idioma+"/SystemTabUnselected.PNG";
		SysTabSel = "imgs/"+idioma+"/SystemTabSelected.PNG";
		sys = new LSC_System(idioma);
	}
	
	public ResultExec Smoke()
	{
		
		try {
										
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
					
			System.out.print(sys.LSC_Title);
			
			s.wait(sys.LSC_Title,30.0);
			s.click(sys.LSC_Title);
			
			
			s.click(SysTabUns);
			VerificaTela(sys.icn_hardDrive);
		
			s.click(SysTabSel);
			VerificaTela(sys.icn_memory);
			
			s.click(SysTabSel);
			VerificaTela(sys.icn_backup);
			
			s.click(SysTabSel);
			VerificaTela(sys.icn_softwareUpdate);
			
			s.click(SysTabSel);
			VerificaTela(sys.icn_battery);
		
			s.click(SysTabSel);
			VerificaTela(sys.icn_systemInfo);
			
			s.click(SysTabSel);			
			VerificaTela(sys.icn_filePrinter);
			
									
		} catch (IOException e) {
					
			System.out.println("Imagem não encontrada");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
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
			
			//verifica se a tela é a correta
			if(icone != sys.icn_systemInfo && icone != sys.icn_filePrinter)
			s.wait(icone,3.0);
			else
			s.wait(10.0);
		
		} catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
		
	}
	




}
