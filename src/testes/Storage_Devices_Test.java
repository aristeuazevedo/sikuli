package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_CheckUP;
import utilidades.LSC_DeviceManager;
import utilidades.LSC_StorageDevices;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class Storage_Devices_Test {


	LSC_StorageDevices sys;
	LSC_System sys_system;
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Storage Devices Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	public Storage_Devices_Test( String idioma){
		this.idioma = idioma;
		sys = new LSC_StorageDevices(idioma);
		sys_system = new LSC_System(idioma);
	}
		
	public List<ResultExec> storageDevice_test(){
		listaResultados.add(resultado);
		
		optimizeSpace();

		moreStorage();
		
		optimizePerformance();
		
		return listaResultados;
	}
	
	//EXECUTE TESTS
	public void optimizeSpace(){
		
		resultado = new ResultExec("Optimize Storage Test");
		
		try {
			if(utilities.ExistVerify(sys.SystemUns)){
				s.click(sys.SystemUns);
			}
				
			else{
				s.click(sys.SystemSel);
			}
			
			titleLSC();
			
			s.click(sys_system.icn_hardDrive);
						
			s.click(sys.Optimize_space);
			
			s.click(sys.btnDiskCleanup);
			
			titleLSC();
			
			s.wait(6.0);
						
			exitCleanMangWindow();
			
			resultado.addMensagens("Passed");
			
		}catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		
		listaResultados.add(resultado);
		
	}

	
	public void moreStorage(){
		
		resultado = new ResultExec("More Storage Test");
		
		try {
			s.click(sys.GetMoreStorage);
			
			s.click(sys.btnShopnow);
						
			s.wait(6.0);
						
			exitMoreStorage();
			
			
			resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		
		
		listaResultados.add(resultado);
	}
	
	public void optimizePerformance(){
		
		resultado = new ResultExec("Optimize Performance Test");
		
		try {
			s.click(sys.Optimize_performance);
			
			s.click(sys.btnOptimize);
			
			titleLSC();
						
			s.wait(6.0);
						
			exitDesfragmenter();
			
			resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		
		listaResultados.add(resultado);
		
	}
	
		
	
	//CLOSE APPS
	//close the Disk Cleanup opened by LSC
	public void exitCleanMangWindow(){
		//ResultExec resultado = new ResultExec("Reopening LSC - Settings test"); 
		
		try {
			//resultado = new ResultExec("LSC initialization");							
			Runtime.getRuntime().exec("taskkill.exe /IM cleanmgr.exe /F"); 
			//resultado.addMensagens("Passed");
		}catch (Exception e) {
			e.printStackTrace();
			//resultado.addMensagens(sys.ImageError);
		}
		//listaResultados.add(resultado);
	}
	
	//close the browser opened by LSC
	public void exitMoreStorage(){
		
		try {
			s.click(sys.WindowsExit);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//close the Disk Desfragmenter
	public void exitDesfragmenter(){
		try {
			//resultado = new ResultExec("LSC initialization");							
			Runtime.getRuntime().exec("taskkill.exe /IM dfrgui.exe /F"); 
			//resultado.addMensagens("Passed");
		}catch (Exception e) {
			e.printStackTrace();
			//resultado.addMensagens(sys.ImageError);
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
	}
