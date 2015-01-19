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
	
	String LSCtitle = " ";
	String BackupIcon = " ";
	String BatteryIcon = " ";
	String FilePrintersIcon = " ";
	String MemoryIcon = " ";
	String SoftwareUpdateIcon = " ";
	String StorageDeviceIcon = " ";
	String SysInfoIcon = " ";
	String SysTabUns = " ";
	String SysTabSel = " ";
	String idioma = " ";
	LSC_System sys;
	
	ResultExec resultado = new ResultExec("Smoke Test");
	
	Screen s = new Screen();
			
	public SystemSmoke( String idioma){
		//caminhos das imagens
		
		
		this.idioma = idioma;
		
		SysTabUns = "imgs/"+idioma+"/SystemTabUnselected.PNG";
		SysTabSel = "imgs/"+idioma+"/SystemTabSelected.PNG";
		LSCtitle = "imgs/"+idioma+"/LSC_appTitle.PNG";

		
		sys = new LSC_System(idioma);
	}
	
	public ResultExec Smoke()
	{
		
		try {
										
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
					
			
					
			//s.wait(LSCtitle,30.0);
			System.out.print(LSCtitle);
			
			s.wait(LSCtitle,30.0);
			s.click(LSCtitle);
			
			//
			
			s.click(SysTabUns);
			StorageDevice();
			
			///
			s.click(SysTabSel);
			Memory();
			
			//
			s.click(SysTabSel);
			Backup();
			
			//
			s.click(SysTabSel);
			SoftwareUpdate();
			
			//
			s.click(SysTabSel);
			Battery();
			
			//
			s.click(SysTabSel);
			SysInfo();
			
			//
			s.click(SysTabSel);
			FilePrinters();

			
									
		} catch (IOException e) {
					
			System.out.println("Imagem não encontrada");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	
	public void StorageDevice()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(sys.icn_hardDrive,10.0);
			s.click(sys.icn_hardDrive);
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
		
	}
	
	public void Memory()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(sys.icn_memory,10.0);
			s.click(sys.icn_memory);
			System.out.print(sys.icn_memory);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
			e.printStackTrace();
		}
		
	}

	public void Backup()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(sys.icn_backup,10.0);
			s.click(sys.icn_backup);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

	public void SoftwareUpdate()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(sys.icn_softwareUpdate,10.0);
			s.click(sys.icn_softwareUpdate);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

	public void Battery()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(sys.icn_battery,10.0);
			s.click(sys.icn_battery);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

	public void SysInfo()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(sys.icn_systemInfo,10.0);
			s.click(sys.icn_systemInfo);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

	public void FilePrinters()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(sys.icn_filePrinter,10.0);
			s.click(sys.icn_filePrinter);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

}
