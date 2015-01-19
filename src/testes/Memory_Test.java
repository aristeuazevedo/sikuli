package testes;

import java.util.ArrayList;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class Memory_Test {
	LSC_System sys;
	
	String idioma = "";
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	ResultExec resultado = new ResultExec("Memory Test");
	Screen s = new Screen();
	Utilidades utilities = new Utilidades();
	
public Memory_Test( String idioma){
		
		this.idioma = idioma;
		sys = new LSC_System(idioma);
	}
	
public List<ResultExec> memory_test(){
	listaResultados.add(resultado);
	
	titleLSC();
	s.wait(3.0);
	

	try {
		if(utilities.ExistVerify(sys.SystemUns)){
			s.click(sys.SystemUns);
		}
			
		else{
			s.click(sys.SystemSel);
		}
		
		titleLSC();
		
		s.click(sys.icn_memory);
		
		resultado.addMensagens("Passed");
		
	}catch (FindFailed e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		resultado.addMensagens(sys.ImageError);
	}
	
	
	return listaResultados;
}

public void test(){
titleLSC();




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
