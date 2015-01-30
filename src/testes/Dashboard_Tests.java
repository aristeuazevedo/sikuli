package testes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sikuli.core.search.RegionMatch;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.stringtemplate.v4.ST.RegionType;

import utilidades.LSC_CheckUP;
import utilidades.LSC_Dashboard;
import utilidades.LSC_Security;
import utilidades.LSC_Support;
import utilidades.LSC_System;
import utilidades.ResultExec;
import utilidades.Utilidades;

public class Dashboard_Tests {

	LSC_Dashboard sys;
	LSC_System system;
	LSC_Security security;
	LSC_Support support;
	LSC_CheckUP checkup;
	
	Region i;
	
	String idioma = "";
	ResultExec resultado = new ResultExec("Dashboard Tests");
	private List<ResultExec> listaResultados = new ArrayList<ResultExec>();
	Screen s = new Screen();
	Utilidades utilidades = new Utilidades();
	
	public Dashboard_Tests(String idioma) {
		super();
		this.idioma = idioma;
		sys = new LSC_Dashboard(idioma); 
		system = new LSC_System(idioma);
		security = new LSC_Security(idioma);
		support = new LSC_Support(idioma);
		checkup = new LSC_CheckUP(idioma);
		}
	
public List<ResultExec> verify_Test(){
		
		listaResultados.add(resultado);
		
		titleLSC();
		
		openDashScreen();
		
		allIconClicks();
					
		editDashboard();
		return listaResultados;
	}

public void SelectTabHome()
{
	resultado = new ResultExec("Home tab");
	try{
			s.click(sys.HomeSel, 200);
			resultado.addMensagens("Tab Selected Passed");
	} catch (FindFailed e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		try{
		s.click(sys.HomeUns, 200);
		resultado.addMensagens("Tab Unselected Passed");
		} catch (FindFailed e1) {
			e1.printStackTrace();
		}
	}
	listaResultados.add(resultado);
	
	try{
		resultado = new ResultExec("Alert Button");
		s.click(sys.alert_button);
		resultado.addMensagens("Passed");
		listaResultados.add(resultado);
	}catch (FindFailed e) {	
		e.printStackTrace();
	}
	listaResultados.add(resultado);
}

public void titleLSC(){
	
	try {
			
		s.wait(sys.LSC_Title,30.0);
		s.click(sys.LSC_Title);
		//resultado.addMensagens("Passed");
	} catch (FindFailed e) {
		e.printStackTrace();
		resultado.addMensagens(sys.ImageError);
	}
	//listaResultados.add(resultado);
}

public void openDashScreen(){

	try{	
		resultado = new ResultExec("Dashboard open Screen");				
				
		s.click(sys.dashboard_button, 700);
		
		s.click(sys.system_dashboard, 700);
		
		s.click(sys.security_dashboard, 700);
		
		s.click(sys.checkup_dashboard, 700);
		
		resultado.addMensagens("Passed");
		
	} catch (FindFailed e) {	
		e.printStackTrace();
		resultado.addMensagens(sys.ImageError);
	}
	listaResultados.add(resultado);
}

public void allIconClicks(){
	try{	
		resultado = new ResultExec("All Icons Verify");				
		listaResultados.add(resultado);
		s.click(sys.dashboard_button, 1000);
				
		s.wait(2.0);
		executionClick(sys.cpu_dashboard);
		s.wait(3.0);
		exitWindow();
		s.wait(3.0);
		executionClick(sys.memory_dashboard);
		s.wait(3.0);
		exitWindow();
		s.wait(3.0);
			
		
		executionClick(sys.backup_dashboard);
		executionClick(sys.device_dashboard);
		executionClick(sys.firewall_dashboard);
		executionClick(sys.virus_dashboard);
		
		executionClick(sys.storage_dashboard);
		executionClick(sys.updates_dashboard);
		executionClick(sys.network_dashboard);
		executionClick(sys.hardware_dashboard);
		
		
		
	} catch (FindFailed e) {	
		e.printStackTrace();
		resultado.addMensagens(sys.ImageError);
	}
}

public void verifyButton(){
	try{	
		resultado = new ResultExec("Verify Buttons");				
				
		s.click(sys.dashboard_button, 700);
		
		s.click(sys.system_dashboard, 700);
		
		s.click(sys.security_dashboard, 700);
		
		s.click(sys.checkup_dashboard, 700);
		
		
		
		resultado.addMensagens("Passed");
		
		
	} catch (FindFailed e) {	
		e.printStackTrace();
		resultado.addMensagens(sys.ImageError);
	}
	listaResultados.add(resultado);
}

public void executionClick(String icone){
	String nome = nomeIcone(icone);
	
	
	if(icone.equals(sys.storage_dashboard) ||
		icone.equals(sys.updates_dashboard) ||
		icone.equals(sys.network_dashboard) ||
		icone.equals(sys.hardware_dashboard)) {
		try{	
			resultado = new ResultExec(nome+" Dashboard exist");
			
			titleLSC();
			s.click(icone,1000);
			s.wait(4.0);
			s.click(sys.LSC_welcomeExit);
			resultado.addMensagens("Passed");
			
		}catch (FindFailed e) {	
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
	}
	else {
		try{
		resultado = new ResultExec(nome+" Dashboard exist");
		titleLSC();
		s.click(icone,1000);
		resultado.addMensagens("Passed");
	
		}catch (FindFailed e) {	
			e.printStackTrace();
			resultado.addMensagens(sys.ImageError);
		}
	}
	listaResultados.add(resultado);
	
}

public String nomeIcone(String icone){
	String nomeicone="";
	
	if(icone.contains("memory")){
		return "Memory";
	}
	
	if(icone.contains("Hardware")){
		return "Hardware Scan";
	}
	
	if(icone.contains("cpu")){
		return "CPU";
	}
	
	if(icone.contains("network")){
		return "Network";
	}

	if(icone.contains("storage")){
		return "Storage Devices";
	}
	
	if(icone.contains("updates")){
		return "Updates";
	}
	
	if(icone.contains("backup")){
		return "Backup";
	}
	
	if(icone.contains("device")){
		return "Device Manager";
	}

	if(icone.contains("firewall")){
		return "Firewall";
	}
	
	if(icone.contains("virus")){
		return "Virus Protection";
	}

	if(icone.contains("battery")){
		return "Battery";
	}
		
	return nomeicone;
}

public void editDashboard(){
	try{	
		resultado = new ResultExec("Edit Dashboard");				
		listaResultados.add(resultado);
		
		s.click(sys.dashboard_button, 700);
		s.click(sys.edit_dash, 700);
			
				i = localVerify();
		
		dashboardClick(sys.storage_dashboard);
		
		dashboardClick(sys.memory_dashboard);
		
		dashboardClick(sys.cpu_dashboard);
		
		dashboardClick(sys.hardware_dashboard);
		
		dashboardClick(sys.updates_dashboard);
		
		dashboardClick(sys.backup_dashboard);
				
		dashboardClick(sys.firewall_dashboard);
		
		s.click(sys.cancel_dash);
		
		/*
		s.wait(2.0);
		s.drag(sys.device_dashboard);
		s.dropAt(s.find(sys.editMessage_dash).below());
		
		s.wait(2.0);
		s.drag(sys.virus_dashboard);
		s.dropAt(s.find(sys.editMessage_dash).below());
		*/
		
		
		//listaResultados.add(resultado);
		
	} catch (FindFailed e) {	
		e.printStackTrace();
	}
	
}

public Region localVerify(){
	try {
		return s.find(sys.editMessage_dash);
	} catch (FindFailed e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}


public void dashboardClick(String icone){
	String nome = nomeIcone(icone);
	
	try{
	resultado = new ResultExec(nome+" Dashboard edit");
	titleLSC();
	s.wait(2.0);
	
	if(i!=null){
		//s.drag(icone);
		
		s.wait(2.0);
		//Region i = s.find(sys.editMessage_dash).below();
		//s.dropAt(i);
		s.dragDrop(icone, i);
		resultado.addMensagens("Passed");
	}
	
	}	catch (FindFailed e) {	
		e.printStackTrace();
		resultado.addMensagens(sys.ImageError);
	}
	listaResultados.add(resultado);
}

public void exitWindow(){
	//ResultExec resultado = new ResultExec("Reopening LSC - Settings test"); 
	/*
	try {
		//resultado = new ResultExec("LSC initialization");							
		Runtime.getRuntime().exec("taskkill /IM taskmgr.exe /F"); 
		//resultado.addMensagens("Passed");
	}catch (Exception e) {
		e.printStackTrace();
		//resultado.addMensagens(sys.ImageError);
		
		*/
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("cmd /c start \"\" \"cmds/taskManager.lnk");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//listaResultados.add(resultado);

}



