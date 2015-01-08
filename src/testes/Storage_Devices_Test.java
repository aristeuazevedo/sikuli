package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.Screen;

import utilidades.LSC_CheckUP;
import utilidades.LSC_DeviceManager;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class Storage_Devices_Test {


	LSC_DeviceManager sys;
	LSC_CheckUP sys_checkup;
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Device Manager Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	public Storage_Devices_Test( String idioma){
		this.idioma = idioma;
		sys = new LSC_DeviceManager(idioma);
		sys_checkup = new LSC_CheckUP(idioma);
	}
	
	
	
}
