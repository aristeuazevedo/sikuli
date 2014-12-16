package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_CheckUP;
import utilidades.LSC_HardwareScan;
import utilidades.LSC_Main;
import utilidades.ResultExec;

public class HardwareScan_Test  {
	
	LSC_HardwareScan sys;
	LSC_CheckUP sys_checkup;
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Smoke Test Check Up");
	Screen s = new Screen();
	
	public HardwareScan_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_HardwareScan(idioma);
		sys_checkup = new LSC_CheckUP(idioma);
	}
	
	public void HardwareScan_Quick(){
		try {
			s.click(sys_checkup.CheckupUns);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
