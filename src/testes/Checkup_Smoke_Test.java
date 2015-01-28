package testes;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.script.*;

import utilidades.LSC_CheckUP;
import utilidades.LSC_Main;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;



public class Checkup_Smoke_Test {
	
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Smoke Test Check Up");
	
	String idioma = "";
	
	LSC_CheckUP sys;
	
	
	Screen s = new Screen();
	
	public Checkup_Smoke_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_CheckUP(idioma);
	}
	
	public List<ResultExec> Smoke()
	{	
		
		listaResultados.add(resultado);
		titleLSC();
		
		tabUnselected();

		tabSelected();	
		VerificaTela(sys.icn_hwScan);
			
			
		tabSelected();
		VerificaTela(sys.icn_deviceManager);
			
		tabSelected();
		VerificaTela(sys.icn_snapshot);
			
				
		
		return listaResultados;
	}
	
	public void titleLSC(){
		
		try {
			resultado = new ResultExec("LSC Title verification");		
			s.wait(sys.LSC_Title,30.0);
			s.click(sys.LSC_Title);
			resultado.addMensagens("Passed");
		} catch (FindFailed e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
		listaResultados.add(resultado);
}
	
	public void VerificaTela(String icone)
	{
		try {
			s.click(sys.LSC_Title);
			resultado = new ResultExec(Utilidades.nomeIcone(icone));
			s.wait(icone,10.0);
			s.click(icone);
							
			if(icone == sys.icn_snapshot)
				s.wait(sys.icn_save,40.0);
		
			resultado.addMensagens("Passed");
			
		} catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
		listaResultados.add(resultado);
	}
	
	//TODO Verifica a aba System não selecionada
	public void tabUnselected(){
				try {
					resultado = new ResultExec("Tab Checkup Unselected");
					s.wait(2.0);
					s.click(sys.CheckupUns);
					s.wait(2.0);
					resultado.addMensagens("Passed");
				} catch (FindFailed e) {
					resultado.addMensagens(e.toString());
					e.printStackTrace();
				}
				listaResultados.add(resultado);
	}
	
	//TODO Verifica a aba System selecionada
	public void tabSelected(){
			try {
				resultado = new ResultExec("Tab Checkup Selected");
				s.wait(2.0);
				s.click(sys.CheckupSel);
				s.wait(2.0);
				resultado.addMensagens("Passed");
			} catch (FindFailed e) {
				resultado.addMensagens(e.toString());
				e.printStackTrace();
			}
			listaResultados.add(resultado);
	}
}
