package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_Backup;
import utilidades.LSC_Software_Updates;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class Software_Updates_Test {

	LSC_Software_Updates sys;
	LSC_System system;
	
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Software Updates Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
	public Software_Updates_Test(String idioma) {
		this.idioma = idioma;
		system = new LSC_System(idioma);
		sys = new LSC_Software_Updates(idioma);
	}
	
	public List<ResultExec> Main_Soft_updates_test(){
		listaResultados.add(resultado);
		
		resultado = new ResultExec("Software Updates Link");
		try {
			
			if(utilities.ExistVerify(system.SystemUns)){
				s.click(system.SystemUns);
			}
				
			else{
				s.click(system.SystemSel);
			}
						
			s.click(system.icn_softwareUpdate);
			s.click(sys.SU_Screen_Descrip);
			s.click(sys.SU_Screen_Title);
						
		}catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
		
		
		SU_Lenovo_Updates_test();
		SU_Windows_Updates_test();
		
		
		return listaResultados;
	}
	
	
	public void SU_Lenovo_Updates_test()
	{
		resultado = new ResultExec("Software Updates Link");
		try {
						
			/////LENOVO SOFTWARE NOT INSTALLED (YELLOW ALERT)/////
			if(utilities.ExistVerify(sys.SU_No_Lenovo_Software))
			{
				if(utilities.ExistVerify(sys.SU_No_Lenovo_Software_Msg))
				{
					s.click(sys.SU_Lenovo_Download);
					s.wait(40.0);
					utilities.ExistVerify(sys.SU_Lenovo_URL);
					utilities.exitIE();
					s.wait(5.0);
				}
				
				else
				{
					s.click(sys.SU_No_Lenovo_Software);
					s.click(sys.SU_Lenovo_Download);
					s.wait(40.0);
					utilities.ExistVerify(sys.SU_Lenovo_URL);
					utilities.exitIE();
					s.wait(5.0);
				}
			}
			
			/////NEVER UPDATED LENOVO SOFTWARE (RED ALERT)/////
			if(utilities.ExistVerify(sys.SU_Lenovo_Never_Updated))
			{
				if(utilities.ExistVerify(sys.SU_Lenovo_Never_Updated_Msg))
				{
					s.click(sys.SU_Launch);
					s.wait(5.0);
					utilities.ExistVerify(sys.SU_App);
					s.click(sys.SU_App_Close);
				}
				
				else
				{
					s.click(sys.SU_Lenovo_Never_Updated);
					s.click(sys.SU_Launch);
					s.wait(5.0);
					utilities.ExistVerify(sys.SU_App);
					s.click(sys.SU_App_Close);
				}
			}
			resultado.addMensagens("Passed");
		}catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultado.addMensagens(sys.ImageError);
			}
		
		listaResultados.add(resultado);
	}
	
	public void SU_Windows_Updates_test()
	{
	/////WINDOWS IS UPDATED (GREEN ALERT)/////
		
		try{
				if(utilities.ExistVerify(sys.SU_Win_Update_Green))
				{
					if(utilities.ExistVerify(sys.SU_Check_for_updates))
					{
						s.click(sys.SU_Launch);
						s.wait(5.0);
						utilities.ExistVerify(sys.SU_Win_Update_Window);
						utilities.exitWindowsUpdate();
						s.wait(3.0);
					}
					
					else
					{
						s.click(sys.SU_Win_Update_Green);
						s.click(sys.SU_Launch);
						s.wait(5.0);
						utilities.ExistVerify(sys.SU_Win_Update_Window);
						utilities.exitWindowsUpdate();
						s.wait(3.0);
					}
				}
				
				resultado.addMensagens("Passed");
				listaResultados.add(resultado);
				
			}catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultado.addMensagens(sys.ImageError);
			}
			
		
		
		
	}
}
