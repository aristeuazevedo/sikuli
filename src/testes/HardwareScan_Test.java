package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import utilidades.LSC_CheckUP;
import utilidades.LSC_HardwareScan;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class HardwareScan_Test  {
	
	LSC_HardwareScan sys;
	LSC_CheckUP sys_checkup;
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Hardware Scan Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	public HardwareScan_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_HardwareScan(idioma);
		sys_checkup = new LSC_CheckUP(idioma);
	}
		
	public List<ResultExec> hw_test(){
		listaResultados.add(resultado);
		
		HardwareScan_Cancel();
		
		HardwareScan_Quick();
		
		return listaResultados;
	}
	
	public void HardwareScan_Cancel(){
		
		titleLSC();
		s.wait(10.0);
		resultado = new ResultExec("Quick test cancel");
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
			
			s.wait(sys.settings_hw,180.0);
			
			
			if(utilities.ExistVerify(sys.scrolltab)){
				s.wheel(sys.scrolltab, 1, 2);
				}
			
			
			s.click(sys.launch_btn,1000);
			
			s.click(sys.ok,300);
			
			s.click(sys.inprogress);
						
			s.click(sys.cancel);
			
			s.click(sys.yes_btn);
			
			s.wait(sys.canceled_status,8000);
					
			s.click(sys.canceled_status);
			
			resultado.addMensagens("Passed");

		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		listaResultados.add(resultado);
		
		
	}
		
	public void HardwareScan_Quick(){
		
		titleLSC();
		s.wait(10.0);
		resultado = new ResultExec("Quick test execution");
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
			
			s.wait(sys.settings_hw,180.0);
			
			/*
			//TESTE DE HARDWARE SCAN MAIS RAPIDO
			s.click(sys.selectAll);
			s.click(sys.processor_hw);
			*/
			
			if(utilities.ExistVerify(sys.scrolltab)){
				s.wheel(sys.scrolltab, 1, 2);
				}
			
			s.click(sys.launch_btn,1000);
			
			s.click(sys.ok,300);
			
			titleLSC();
			
			s.click(sys.inprogress);
						
			titleLSC();
			
			s.wait(sys.complete,2000);
			/*
			Boolean x = true;
			while(x){
			if(s.wait(sys.complete, 200.0)!=null){
				x=false;
				
				}
			
			else{
				s.click(sys.inprogress);
				s.click(sys.LSC_Title);
			}
			
			}*/
			
			s.click(sys.percent);
			
			resultado.addMensagens("Passed");

		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		
		listaResultados.add(resultado);
	}
	
	public void titleLSC(){
		
		try {	
			s.wait(sys.LSC_Title,50.0);
			s.click(sys.LSC_Title);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		
}
}
