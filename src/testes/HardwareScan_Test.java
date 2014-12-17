package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_CheckUP;
import utilidades.LSC_HardwareScan;
import utilidades.LSC_Main;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class HardwareScan_Test  {
	
	LSC_HardwareScan sys;
	LSC_CheckUP sys_checkup;
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Smoke Test Check Up");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	public HardwareScan_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_HardwareScan(idioma);
		sys_checkup = new LSC_CheckUP(idioma);
	}
	
	public void HardwareScan_Quick(){
		
		titleLSC();
		s.wait(10.0);
		
		try {
			if(utilities.ExistVerify(sys_checkup.CheckupUns)){
			s.click(sys_checkup.CheckupUns);
			}
			
			else{
				s.click(sys_checkup.CheckupSel);
			}
			
			s.click(sys_checkup.icn_hwScan,300);
			
			s.click(sys.hw_link,300);
			
			s.click(sys.runScan_btn,300);
			
			titleLSC();
			
			s.wait(sys.settings_hw,180.0);
			
			s.wheel(sys.scrolltab, 1, 2);
			
			s.click(sys.launch_btn,1000);
			
			s.click(sys.ok,300);
			
			titleLSC();
			
			s.wait(sys.complete, 1000);
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void titleLSC(){
		
		try {
			resultado = new ResultExec("LSC Title verification");		
			s.wait(sys.LSC_Title,50.0);
			s.click(sys.LSC_Title);
			resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		listaResultados.add(resultado);
}
}
