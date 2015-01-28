package utilidades;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;

public class Utilidades {
	
	private  static Robot rob;
	
	//chama o metodo de captura e salva a imagem como jpg
	public static void print(String str) throws IOException
	{
		try{
			rob = new Robot();
				
		}catch(AWTException e1) {
			throw new RuntimeException("Unable to initialize",e1);		
		}
		
		BufferedImage image = Utilidades.capture();
		
		ImageIO.write(image, "jpg", new File("C:\\Users\\Lenovo\\Desktop\\victorwork\\"+str+".jpg"));
				
	}
	
	//captura tela da maquina, qualquer dimensao
	public static BufferedImage capture()
	{
		return rob.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	}
	
	//retorna a data atual da maquina
	public static String horaData ()
	{
		GregorianCalendar gc = new GregorianCalendar();
		Date data = gc.getTime();
			
		return data.toString();
		
	}
	
	//Grava o arquivo HTML
	public static void grava(ListaResult lista){
		GregorianCalendar gc = new GregorianCalendar();
		String hora = gc.getTime().getHours()+"";
		String data = gc.getTime().getDate()+"";
		String minuto = gc.getTime().getMinutes()+"";
		File arquivo = new File(hora+minuto+data+".html");
		
		try( FileWriter fw = new FileWriter(arquivo) ){
			fw.write("<HTML>");
			fw.write("<Head>");
			fw.write("<TITLE>Report</TITLE>");
			fw.write("</Head>");
			fw.write("<Body>");
			
			fw.write("<b><font color=red size=5>Language:"+lista.getIdioma()+"</b> </font>  <br>");
			fw.write("<b><font color=red size=5>Date:"+lista.getData()+"</b>  </font>  <br>");
			String str = "";
			fw.write("<table border='1' style='width:100%'>");
			fw.write("<tr>");
			fw.write("<td><font size=4><b>Test Name</b></font> </td>");
			fw.write("<td><font size=4><b>Message</b></font> </td>");
			fw.write("</tr>");
			
			for (ResultExec result : lista.listaResultado ) {
				fw.write("<tr>");
				if(result.getNomeTeste().contains("Smoke Test System")
					|| result.getNomeTeste().contains("Smoke Test Security")
					|| result.getNomeTeste().contains("Smoke Test Check Up")
					)
				{
					fw.write("<td colspan='2' align=center ><b>"+result.getNomeTeste()+"</b></td>");
				}
				else{
				fw.write("<td>"+result.getNomeTeste()+"</td>");
				fw.write("<td>"+result.getMensagens()+"</td>");
				fw.write("</tr>");
				}
			}
			
			fw.write("</table>");
			fw.write("</Body>");
			fw.write("</HTML>");
		    fw.flush();
		    
		}catch(IOException ex){
		  ex.printStackTrace();
		  
		}
	}
	
	public static String nomeIcone(String icone){
		
		if(icone.contains("icn_systemInfo.png")){ return "System info Icon";}
		if(icone.contains("icn_hardDrive.png")){ return "Hard Drive Icon";}
		if(icone.contains("icn_memory.png")){ return "Memory Icon";}
		if(icone.contains("icn_backup.png")){ return "Backup Icon";}
		if(icone.contains("icn_softwareUpdate.png")){ return "Software Update Icon";}
		if(icone.contains("icn_battery.png")){ return "Battery Icon";}
		if(icone.contains("icn_filePrinter.png")){ return "File and Printers Icon";}
		if(icone.contains("icn_filePrinter.png")){ return "File and Printers Icon";}
		
		if(icone.contains("icn_virusProtection.png")){ return "Virus Protection Icon";}
		if(icone.contains("icn_password.png")){ return "Password Icon";}
		if(icone.contains("icn_firewall.png")){ return "Firewall Icon";}
		if(icone.contains("icn_internet.png")){ return "Internet Connection Icon";}
		if(icone.contains("icn_fingerprint.png")){ return "Finger Print Icon";}
		
		if(icone.contains("icn_hwScan.png")){ return "Hardware Scan Icon";}
		if(icone.contains("icn_deviceManager.png")){ return "Device Manager Icon";}
		if(icone.contains("icn_snapshot.png")){ return "Snapshop Icon";}
		
		return "Test Name Not Found";
	}

}
