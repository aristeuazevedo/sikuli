package testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import com.jgoodies.common.base.SystemUtils;

import utilidades.LSC_CheckUP;
import utilidades.LSC_HardwareScan;
import utilidades.ResultExec;
import utilidades.Utilidades;

/**
 * Class used to prepare the LSC to run the tests 
 * @author	Aristeu Azevedo
 * @param 	sys			It has the paths to the files and images
 * @param	sys_checkup It has the paths to "check up" files and images
 * @param	idioma		Language select to be executed
 * @param	resultado	Messages and names of the executed tests
 * @param	s			Parameter used by Sikuli to monitor the screen
 * @param	utilities	instance which has some common methods 
 */
public class HardwareScan_Test  {
	
	LSC_HardwareScan sys;
	LSC_CheckUP sys_checkup;
	String idioma = "";
	String chassi = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Hardware Scan Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	/**
	 * Constructor of the Hardware scan tests class
	 * @param idioma Used to verify the language selected by the user
	 * @param chassi Used to verify the the type of the machine
	 */ 
	public HardwareScan_Test( String idioma, String chassi){
		this.chassi = chassi;
		this.idioma = idioma;
		sys = new LSC_HardwareScan(idioma);
		sys_checkup = new LSC_CheckUP(idioma);
	}
		
	/**
	 * Main method to Run all the hardware scan tests
	 */ 
	public List<ResultExec> hw_test(){
		listaResultados.add(resultado);
		
		HardwareScan_Cancel();
		
		HardwareScan_Quick();
		
		schedule_hardwarescan();
		
		Wifi_message();
		
				
		return listaResultados;
	}
	
	/**
	 * Method to Run the hardware scan but cancel in the middle of execution
	 */ 
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
			
			titleLSC();
			
			s.wait(4.0);
			
			s.click(sys.ok,300);
			
			s.click(sys.inprogress);
						
			s.click(sys.cancel);
			
			s.wait(2.0);
			
			s.click(sys.yes_btn);
								
			s.wait(sys.canceled_status,8000);
					
			s.click(sys.canceled_status);
			
			resultado.addMensagens("Passed");

		} catch (FindFailed e) {
			
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		listaResultados.add(resultado);
		
		
	}
		
	/**
	 * Method to Run the hardware scan with the quick tests
	 */ 
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
			
			s.wait(2.0);
			
			s.click(sys.ok,300);
			
			titleLSC();
			
			s.click(sys.inprogress);
						
			titleLSC();
			
			s.wait(sys.complete,2000);
			
			s.click(sys.percent);
			
			resultado.addMensagens("Passed");

		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		
		listaResultados.add(resultado);
	}
		
	/**
	 * Method to turn on and off the schedule feature
	 * Disable and enable the schedule of test
	 */
	public void schedule_hardwarescan(){
		
		resultado = new ResultExec("Disable and enable the schedule of tests");
		try {
			
			if(utilities.ExistVerify(sys_checkup.CheckupUns)){
			s.click(sys_checkup.CheckupUns);
			}
			
			else{
				s.click(sys_checkup.CheckupSel);
			}
			
			s.click(sys_checkup.icn_hwScan,300);
			
			
			s.click(sys.schedule,300);
			
			//verify if the schedule is on or off
			if(s.exists(sys.info_NotAvailable)!=null || s.exists(sys.notAvailable)!=null ){
				//turn the schedule on 
				ScdOn_Off();
				resultado.addMensagens("The Schedule was Disable and was turned on");
			}
			
			else{
				
				//turn the schedule off 
				ScdOn_Off();
				//turn the schedule on 
				ScdOn_Off();
				
				resultado.addMensagens("The Schedule was Enable and continues on");
			}

		} catch (FindFailed e) {
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		
		listaResultados.add(resultado);
		
	}
	
	/**
	 * Used to alternate the Schedule Hardware Scan (on/off)
	 */
	public void ScdOn_Off(){
		
		try {						
			
			s.wait(2.0);
			
			s.click(sys.scd_automaticMessage);
			
			s.click(sys.btn_save);
			
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Used to disable the wifi mode
	 */
	public void Wifi_Disable(){
		
		try {
			Runtime.getRuntime().exec("netsh wlan disconnect");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	/**
	 * Verify the message before the starts of hardware scan
	 */
	public void Wifi_message(){
				
		resultado = new ResultExec("Machine using and wifi warning message");	
			
		try {
				
			if(utilities.ExistVerify(sys_checkup.CheckupUns)){
				s.click(sys_checkup.CheckupUns);
			}
				
			else{
				s.click(sys_checkup.CheckupSel);
			}
			
			s.wait(2.0);
			
			s.click(sys_checkup.icn_hwScan,300);
			
			s.click(sys.hw_link,300);
			
			s.click(sys.runScan_btn,300);
			
			s.wait(sys.settings_hw,180.0);
						
			if(utilities.ExistVerify(sys.scrolltab)){
				s.wheel(sys.scrolltab, 1, 2);
			}
			
			//messages verify before the HardwareScan
			
			s.wait(2.0);
			
			if(chassi.equals("Portable")){
				
				if(s.exists(sys.wireless)!=null)	{	
					s.hover(sys.wireless);
					Wifi_Disable();
					s.click(sys.launch_btn);
					s.hover(sys.conect_wireless);
					s.hover(sys.message_warning);
					
					resultado.addMensagens("(Portable) Has 'Wifi' and 'Using machine' message");
				}
				
				else{
					s.click(sys.launch_btn);
					s.hover(sys.conect_wireless);
					s.hover(sys.message_warning);
					
					resultado.addMensagens("(Portable) 'Has Using machine' message");
				}
			}
			
			if(chassi.equals("Desktop")){
				
					s.click(sys.launch_btn);
					s.hover(sys.message_warning);
					resultado.addMensagens("(Desktop) Has 'Using machine' message");
				
			}
			
			s.click(sys.cancel);
			
			} catch (FindFailed e) {
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
