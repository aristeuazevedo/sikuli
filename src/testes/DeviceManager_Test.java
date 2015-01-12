package testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.KeyModifier;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_CheckUP;
import utilidades.LSC_DeviceManager;
import utilidades.LSC_HardwareScan;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class DeviceManager_Test {

	
	LSC_DeviceManager sys;
	LSC_CheckUP sys_checkup;
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Device Manager Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	public DeviceManager_Test( String idioma){
		this.idioma = idioma;
		sys = new LSC_DeviceManager(idioma);
		sys_checkup = new LSC_CheckUP(idioma);
	}
		
	public List<ResultExec> deviceManager_test(){
		listaResultados.add(resultado);
		
		resultado = new ResultExec("Device Manager Link");
		try {
			
			if(utilities.ExistVerify(sys_checkup.CheckupUns)){
				s.click(sys_checkup.CheckupUns);
			}
				
			else{
				s.click(sys_checkup.CheckupSel);
			}
						
			s.click(sys_checkup.icn_deviceManager);
			
			s.click(sys.link_deviceManager);
						
			s.click(sys.btn_deviceManager);
			
			titleLSC();
		
			s.wait(3.0);
			
			close_DeviceManager();
					
			resultado.addMensagens("Passed");
			listaResultados.add(resultado);
			
		}catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}

		
		return listaResultados;
	}
	//DO NOT WORKS
	public void exitDeviceManagerWin(){
		
		try {
				
			Runtime.getRuntime().exec("taskkill /IM mmc.exe /F"); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void titleLSC(){
		
		try {
			//resultado = new ResultExec("LSC Title verification");		
			s.wait(sys.LSC_Title,30.0);
			s.click(sys.LSC_Title);
			//resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		//listaResultados.add(resultado);
	}
	
	public static void close_DeviceManager(){
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("cmd /c start \"\" \"cmds/deviceManager.lnk");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
