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

public class SystemSmoke {
	
	public ResultExec Smoke(String idioma)
	{
		Screen s = new Screen();
		
		ResultExec resultado = new ResultExec("Smoke Test");
		
	try {
				
						
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
			
			//caminhos das imagens
			String LSCtitle = "imgs/"+idioma+"/LSC_appTitle.PNG";
			String BackupIcon = "imgs/"+idioma+"/BackupIcon.PNG";
			String BatteryIcon = "imgs/"+idioma+"/BatteryIcon.PNG";
			String FilePrintersIcon = "imgs/"+idioma+"/FilePrintersIcon.PNG";
			String MemoryIcon = "imgs/"+idioma+"/MemoryIcon.PNG";
			String SoftwareUpdateIcon = "imgs/"+idioma+"/SoftwareUpdateIcon.PNG";
			String StorageDeviceIcon = "imgs/"+idioma+"/StorageDeviceIcon.PNG";
			String SysInfoIcon = "imgs/"+idioma+"/SystemInformationIcon.PNG";
			String SysTabUns = "imgs/"+idioma+"/SystemTabUnselected.PNG";
			String SysTabSel = "imgs/"+idioma+"/SystemTabSelected.PNG";
			
			
			//Tempo de espera para encontrar a imagem esperada
			s.wait(LSCtitle,30.0);
			
			//
			s.click(SysTabUns);
			s.wait(StorageDeviceIcon,10.0);
			s.click(StorageDeviceIcon);
			
			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon,10.0);
			s.click(MemoryIcon);
			
			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon,10.0);
			s.click(BackupIcon);
			
			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon,10.0);
			s.click(SoftwareUpdateIcon);
			
			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon,10.0);
			s.click(BatteryIcon);
			
			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon,10.0);
			s.click(SysInfoIcon);
			
			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon,10.0);
			s.click(FilePrintersIcon);


			//s.paste("informção");
			s.type(Key.DOWN);
			s.type(Key.ENTER);
			
			//ScreenRegion sr = new ScreenRegion();
			
									
		} catch (IOException e) {
					
			//System.out.println("Imagem não encontrada");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return resultado;
	}

}
