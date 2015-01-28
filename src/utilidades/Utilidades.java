package utilidades;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.imageio.ImageIO;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import testes.HardwareScan_Test;

/**
 * Classe com metodos comuns a serem utilizados por qualquer classe
 *
 * @author Aristeu Azevedo
 */
public class Utilidades {

	private static Robot rob;

	static Screen s = new Screen();

	public static LSC_Main main;

	public static void print(String str) throws IOException {
		try {
			rob = new Robot();

		} catch (AWTException e1) {
			throw new RuntimeException("Unable to initialize", e1);
		}

		BufferedImage image = Utilidades.capture();

		ImageIO.write(image, "jpg", new File(
				"C:\\Users\\Lenovo\\Desktop\\victorwork\\" + str + ".jpg"));

	}

	/**
	 * Captura a tela atual, como um "Print Screen"
	 */
	public static BufferedImage capture() {
		return rob.createScreenCapture(new Rectangle(Toolkit
				.getDefaultToolkit().getScreenSize()));
	}

	/**
	 * Retorna a data atual da maquina
	 */
	public static String horaData() {
		GregorianCalendar gc = new GregorianCalendar();
		Date data = gc.getTime();

		return data.toString();

	}

	/**
	 * Gera o arquivo HTML com os resultados dos testes executados
	 *
	 * @param lista
	 *            possui os resultados de cada teste e suas respectivas
	 *            mensagens
	 */
	public static void grava(ListaResult lista) {
		GregorianCalendar gc = new GregorianCalendar();
		String hora = gc.getTime().getHours() + "";
		String data = gc.getTime().getDate() + "";
		String minuto = gc.getTime().getMinutes() + "";
		File arquivo = new File(hora + minuto + data + ".html");

		try (FileWriter fw = new FileWriter(arquivo)) {
			fw.write("<HTML>");
			fw.write("<Head>");
			fw.write("<TITLE>Report</TITLE>");
			fw.write("</Head>");
			fw.write("<Body>");

			fw.write("<b><font color=red size=5>Machine Name:"
					+ lista.getNomeMaquina() + "</b>  </font>  <br>");
			fw.write("<b><font color=red size=5>Language:" + lista.getIdioma()
					+ "</b> </font>  <br>");
			fw.write("<b><font color=red size=5>Date:" + lista.getData()
					+ "</b>  </font>  <br>");

			String str = "";
			fw.write("<table border='1' style='width:100%'>");
			fw.write("<tr>");
			fw.write("<td><font size=4><b>Test Name</b></font> </td>");
			fw.write("<td><font size=4><b>Message</b></font> </td>");
			fw.write("</tr>");

			for (ResultExec result : lista.listaResultado) {
				fw.write("<tr>");
				if (result.getNomeTeste().contains("Smoke Test System")
						|| result.getNomeTeste()
								.contains("Smoke Test Security")
						|| result.getNomeTeste()
								.contains("Smoke Test Check Up")
						|| result.getNomeTeste().contains("Smoke Test Support")
						|| result.getNomeTeste().contains("Settings test")
						|| result.getNomeTeste().contains(
								"(Settings) - Select all check options")
						|| result.getNomeTeste().contains(
								"(Settings) - Show LSC window")
						|| result.getNomeTeste().contains("Alert tests")
						|| result.getNomeTeste().contains("Dashboard Tests")
						|| result.getNomeTeste().contains("Hardware Scan Test")
						|| result.getNomeTeste().contains("Storage Devices Test")
						|| result.getNomeTeste().contains("Hardware Scan Test")
						|| result.getNomeTeste().contains("Device Manager Test")
						|| result.getNomeTeste().contains("Memory Test")
						|| result.getNomeTeste().contains("Backup Test")){
					fw.write("<td bgcolor = green colspan='2' align=center ><font color=white><b>"
							+ result.getNomeTeste() + "</b></font></td>");
				} else {
					fw.write("<td>" + result.getNomeTeste() + "</td>");
					if (result.getMensagens().contains("Image not Found")) {
						fw.write("<td bgcolor = red><font color=white><b>"
								+ result.getMensagens() + "</b></font></td>");
					} else
						fw.write("<td>" + result.getMensagens() + "</td>");

					fw.write("</tr>");
				}
			}

			fw.write("</table>");
			fw.write("</Body>");
			fw.write("</HTML>");
			fw.flush();

		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}

	/**
	 * Metodo para retornar o nome do icone
	 *
	 * @param icone
	 *            caminho da imagem do icone
	 */
	public static String nomeIcone(String icone) {

		if (icone.contains("icn_systemInfo.png")) {
			return "System info Icon";
		}
		if (icone.contains("icn_hardDrive.png")) {
			return "Hard Drive Icon";
		}
		if (icone.contains("icn_memory.png")) {
			return "Memory Icon";
		}
		if (icone.contains("icn_backup.png")) {
			return "Backup Icon";
		}
		if (icone.contains("icn_softwareUpdate.png")) {
			return "Software Update Icon";
		}
		if (icone.contains("icn_battery.png")) {
			return "Battery Icon";
		}
		if (icone.contains("icn_filePrinter.png")) {
			return "File and Printers Icon";
		}
		if (icone.contains("icn_recoveryMedia.png")) {
			return "Recovery Media Icon";
		}

		if (icone.contains("icn_virusProtection.png")) {
			return "Virus Protection Icon";
		}
		if (icone.contains("icn_password.png")) {
			return "Password Icon";
		}
		if (icone.contains("icn_firewall.png")) {
			return "Firewall Icon";
		}
		if (icone.contains("icn_internet.png")) {
			return "Internet Connection Icon";
		}
		if (icone.contains("icn_fingerprint.png")) {
			return "Finger Print Icon";
		}

		if (icone.contains("icn_hwScan.png")) {
			return "Hardware Scan Icon";
		}
		if (icone.contains("icn_deviceManager.png")) {
			return "Device Manager Icon";
		}
		if (icone.contains("icn_snapshot.png")) {
			return "Snapshop Icon";
		}

		if (icone.contains("onlinesupportIcon.png")) {
			return "Online Support Icon";
		}
		if (icone.contains("supportModule_WarrantyIcon.png")) {
			return "Warranty Icon";
		}
		if (icone.contains("icn_configHistory.png")) {
			return "Configuration History Icon";
		}
		if (icone.contains("icn_ProductRegistration.png")) {
			return "Product Registration Icon";
		}

		return "Test Name Not Found";
	}

	public ResultExec SelectTab(String tab, Screen s, LSC_Main sys) {
		ResultExec resultado = new ResultExec("");
		tab = tab.toUpperCase();

		if (tab.equals("HOME")) {
			resultado.addMensagens("Home tab");
			try {
				s.click(sys.HomeSel, 200);
				resultado.addMensagens("Tab Selected Passed");
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				try {
					s.click(sys.HomeUns, 200);
					resultado.addMensagens("Tab Unselected Passed");
				} catch (FindFailed e1) {
					e1.printStackTrace();
				}
			}
		} else if (tab.equals("SYSTEM")) {
			resultado.addMensagens("System tab");
			try {
				s.click(sys.SystemSel, 200);
				resultado.addMensagens("Tab Selected Passed");
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				try {
					s.click(sys.SystemUns, 200);
					resultado.addMensagens("Tab Unselected Passed");
				} catch (FindFailed e1) {
					e1.printStackTrace();
				}
			}
		} else if (tab.equals("SECURITY")) {
			resultado.addMensagens("Security tab");
			try {
				s.click(sys.SecuritySel, 200);
				resultado.addMensagens("Tab Selected Passed");
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				try {
					s.click(sys.SecurityUns, 200);
					resultado.addMensagens("Tab Unselected Passed");
				} catch (FindFailed e1) {
					e1.printStackTrace();
				}
			}
		} else if (tab.equals("CHECK-UP")) {
			resultado.addMensagens("Check-up tab");
			try {
				s.click(sys.CheckupSel, 200);
				resultado.addMensagens("Tab Selected Passed");
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				try {
					s.click(sys.CheckupUns, 200);
					resultado.addMensagens("Tab Unselected Passed");
				} catch (FindFailed e1) {
					e1.printStackTrace();
				}
			}
		} else if (tab.equals("SUPPORT")) {
			resultado.addMensagens("Support tab");
			try {
				s.click(sys.SupportSel, 200);
				resultado.addMensagens("Tab Selected Passed");
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				try {
					s.click(sys.SupportUns, 200);
					resultado.addMensagens("Tab Unselected Passed");
				} catch (FindFailed e1) {
					e1.printStackTrace();
				}
			}
		} else
			resultado.addMensagens("Inexistent Tab");
		return resultado;

	}

	public Boolean ExistVerify(String imagem) {

		Screen s = new Screen();

		try {
			s.find(imagem);
		} catch (FindFailed e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public String redefineNomeIcone(String caminho) {

		if (caminho.contains("memory_settings")) {
			return "Memory Settings Evaluate";
		}

		else if (caminho.contains("storageDevices_settings")) {
			return "Storage Device Settigns Evaluate";
		}

		else if (caminho.contains("hardwareScan_settings")) {
			return "Hardware Scan Settigns Evaluate";
		}

		else if (caminho.contains("softwareUpdates_settings")) {
			return "Software Updates Settigns Evaluate ";
		}

		else if (caminho.contains("battery_settings")) {
			return "Battery Settigns Evaluate ";
		}

		else if (caminho.contains("recoveryMedia_settings")) {
			return "Recovery Media Settigns Evaluate ";
		}

		else if (caminho.contains("backup_settings")) {
			return "Backup Settigns Evaluate ";
		}

		else if (caminho.contains("deviceManager_settings")) {
			return "Device Manager Settigns Evaluate ";
		}

		else if (caminho.contains("warranty_settings")) {
			return "Warranty Settigns Evaluate ";
		}

		else if (caminho.contains("virusProtection_settings")) {
			return "Virus Protection Settigns Evaluate ";
		}

		else if (caminho.contains("firewall_settings")) {
			return "Firewall Settigns Evaluate ";
		}

		else if (caminho.contains("productRegistration_settings")) {
			return "Product Registration Settigns Evaluate ";
		}

		return "";
	}

	public void maximimaLSC(String idioma) {
		main = new LSC_Main(idioma);
		s.wait(4.0);
		try {
			
			s.doubleClick(main.LSC_Title);
			
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeApp(String idioma) {
		main = new LSC_Main(idioma);
		s.wait(4.0);
		try {
			s.click(main.Exit);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void titleLSC(){
		LSC_Main sys = new LSC_Main("en_US");
		try {
				
			s.wait(sys.LSC_Title,50.0);
			//s.doubleClick(sys.LSC_Title);
		
		} catch (FindFailed e) {
			e.printStackTrace();
			
		}
		
}
}