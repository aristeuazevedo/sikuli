/*package testes;

import java.io.File;
import java.io.IOException;

import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import utilidades.ResultExec;

public class Security_Module_Test {

	public ResultExec Smoke(String idioma) {
		Screen s = new Screen();

		ResultExec resultado = new ResultExec("Smoke Test");

		try {

			java.awt.Desktop.getDesktop().open(
					new File("Linguagens/" + idioma + ".bat"));
			
			String Fingerprint = "imgs/" + idioma + "/Fingerprint.PNG";
			String Firewall = "imgs/" + idioma + "/Firewall.PNG";
			String InternetConnection = "imgs/" + idioma
					+ "/InternetConnection.PNG";
			String Password = "imgs/" + idioma + "/Password.PNG";
			String SecurityButtonIsSelected = "imgs/" + idioma
					+ "/SecurityButtonIsSelected.PNG";
			String SecurityButtonUnselected = "imgs/" + idioma
					+ "/SecurityButtonUnselected.PNG";
			String VirusProtection = "imgs/" + idioma + "/VirusProtection.PNG";

			// Tempo de espera para encontrar a imagem esperada
			s.wait(LSCtitle, 30.0);

			//
			s.click(SysTabUns);
			s.wait(StorageDeviceIcon, 10.0);
			s.click(StorageDeviceIcon);

			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon, 10.0);
			s.click(MemoryIcon);

			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon, 10.0);
			s.click(BackupIcon);

			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon, 10.0);
			s.click(SoftwareUpdateIcon);

			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon, 10.0);
			s.click(BatteryIcon);

			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon, 10.0);
			s.click(SysInfoIcon);

			//
			s.click(SysTabSel);
			s.wait(StorageDeviceIcon, 10.0);
			s.click(FilePrintersIcon);

			// s.paste("informção");
			s.type(Key.DOWN);
			s.type(Key.ENTER);

			// ScreenRegion sr = new ScreenRegion();

		} catch (IOException e) {

			// System.out.println("Imagem não encontrada");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return resultado;
	}

}*/
