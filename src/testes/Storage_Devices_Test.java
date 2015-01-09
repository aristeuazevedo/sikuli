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
	ResultExec resultado = new ResultExec("Device Manager Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	public Storage_Devices_Test( String idioma){
		this.idioma = idioma;
		sys = new LSC_StorageDevices(idioma);
		sys_system = new LSC_System(idioma);
	}
		
	public List<ResultExec> storageDevice_test(){
		listaResultados.add(resultado);
		
try {
			
			if(utilities.ExistVerify(sys.SystemUns)){
				s.click(sys.SystemUns);
			}
				
			else{
				s.click(sys.SystemSel);
			}
			
			s.click(sys_system.icn_hardDrive);
			

							
			resultado.addMensagens("Passed");
			listaResultados.add(resultado);
			
		}catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}

	
		
		return listaResultados;
	}
}
