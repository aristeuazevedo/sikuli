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
	
	ResultExec resultado = new ResultExec("Smoke Test");
	
	Screen s = new Screen();
			
	public SystemSmoke( String idioma){
		//caminhos das imagens
		LSCtitle = "imgs/"+idioma+"/LSC_appTitle.PNG";
		BackupIcon = "imgs/"+idioma+"/BackupIcon.PNG";
		BatteryIcon = "imgs/"+idioma+"/BatteryIcon.PNG";
		FilePrintersIcon = "imgs/"+idioma+"/FilePrintersIcon.PNG";
		MemoryIcon = "imgs/"+idioma+"/MemoryIcon.PNG";
		SoftwareUpdateIcon = "imgs/"+idioma+"/SoftwareUpdateIcon.PNG";
		StorageDeviceIcon = "imgs/"+idioma+"/StorageDeviceIcon.PNG";
		SysInfoIcon = "imgs/"+idioma+"/SystemInformationIcon.PNG";
		SysTabUns = "imgs/"+idioma+"/SystemTabUnselected.PNG";
		SysTabSel = "imgs/"+idioma+"/SystemTabSelected.PNG";
		this.idioma = idioma;
	}
	
	public ResultExec Smoke()
	{
		
		
		
		

		try {
										
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
					
					
			s.wait(LSCtitle,30.0);
			
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
					
			//System.out.println("Imagem não encontrada");
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
			s.wait(StorageDeviceIcon,10.0);
			s.click(StorageDeviceIcon);
			
		} catch (Exception e) {
			
			resultado.addMensagens(e.toString());
		}
		
	}
	
	public void Memory()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(StorageDeviceIcon,10.0);
			s.click(MemoryIcon);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

	public void Backup()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(StorageDeviceIcon,10.0);
			s.click(BackupIcon);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

	public void SoftwareUpdate()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(StorageDeviceIcon,10.0);
			s.click(SoftwareUpdateIcon);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

	public void Battery()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(StorageDeviceIcon,10.0);
			s.click(BatteryIcon);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

	public void SysInfo()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(StorageDeviceIcon,10.0);
			s.click(SysInfoIcon);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

	public void FilePrinters()
	{
		try {
			
			s.click(LSCtitle);
			s.wait(StorageDeviceIcon,10.0);
			s.click(FilePrintersIcon);
			
		} catch (Exception e) {
			resultado.addMensagens(e.toString());
		}
		
	}

}
