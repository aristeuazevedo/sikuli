package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Finishings;

import org.python.core.NewCompilerResources;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import gui.*;
import testes.*;
import utilidades.*;

/**
 * Classe principal responsável por gerenciar quais telas serão testadas, 
 * também possui métodos que fazem a chamada de classes.
 *@author Aristeu Azevedo
 */

public class MainExec {
	
	static ResultExec resultado = new ResultExec("");
	static TestsParameters testParam = new TestsParameters();
	static System_Smoke_Test SystemTest ;
	static Security_Smoke_Test SecurityTest ;
	static Checkup_Smoke_Test CheckupTest ;
	static Support_Smoke_Test SupportTest ;
	static ListaResult lista;
	static Settings_Tests settings;
	static Dashboard_Tests dashboard;
	static HardwareScan_Test hardwarescan;
	static DeviceManager_Test deviceManager;
	static Storage_Devices_Test storageDevice;
	static Memory_Test memoryTest;
	static Backup_Test backupTest;
	static Software_Updates_Test suTest;
	static LSC_environment_preparation env_preparation;
	
	static Machine_Type machine_type = new Machine_Type();
		
	public static void main(String[] args) {
				
		//TestSelection window = new TestSelection();
		TestSelect window = new TestSelect();
			
		//Setting the machine type using methods of the Utilidades
		
		//--------------------------------------------------------------
		//Getting the machine information and saving on a document
		//Utilidades.execFpsmbios();
		
		//chama a tela de seleção de idiomas
		window.setVisible(true);
		
		//verifica se a tela de seleção ainda está ativa
		while (window.isShowing() == true) {
			testParam = window.testParam;
		}
				
		testParam.setData(Utilidades.horaData());
		
		//objeto que carrega as informações da execução
		lista = new ListaResult(testParam.getMachineName(), testParam.getData(), testParam.getShortIdioma());
		lista.setNomeMaquina(testParam.getMachineName());				
		lista.addResultado(initializeLSC(testParam.getShortIdioma()));
		
		settings = new Settings_Tests(testParam.getShortIdioma());
		
		//reading the document of the machine information
		machine_type = Utilidades.readMachineType();
		lista.setChassi(machine_type.chassi);

		lista.setMachineType(machine_type.machineType);
		
		//environment preparation, for now only works on english language 
		if(testParam.getShortIdioma().equals("en_US")){
			env_preparation = new LSC_environment_preparation(testParam.getShortIdioma());
		}
		
		selectSmokeTests();
		
		selectSettingTests();
		
		//testes de Alerta
		if (testParam.isAlerts()) {
			AlertTests alertTest = new AlertTests(
					testParam.getShortIdioma());       
			for (ResultExec result : alertTest.verify_Test()) {
				lista.addResultado(result);
			}
		}
						
		Utilidades.titleLSC();
		
		selectDashboardTests();
		
		hardwareScan_test();
		
		deviceManager_test();
		
		storageDevice_test();
		
		memory_test();
		
		backup_test();
		
		//TESTES DE SOFTWARE UPDATES (CARLOS)
		//suTest = new Software_Updates_Test(testParam.getShortIdioma());
		//suTest.Main_Soft_updates_test();
		
		Utilidades.closeApp(testParam.idioma);
		
		Utilidades.grava(lista);
		
		
	}
	
	/**
	 * Chama o bat do LSC com a sigla do idioma previamente selecionado
	 */
	public static ResultExec initializeLSC(String idioma){
			
		try {
			resultado = new ResultExec("LSC initialization");							
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
			resultado.addMensagens("Passed");
		}catch (Exception e) {
			e.printStackTrace();
			resultado.addMensagens(e.toString());
		}
			return resultado;
			
		}	

	/**
	 * Método para chamada de testes de acordo com os valores 
	 * setados na tela "testsSelection"
	 */
	public static void selectSmokeTests()
	{
		if (testParam.isSystemSmoke()) {
			System_Smoke_Test SystemTest = new System_Smoke_Test(
					testParam.getShortIdioma());
			for (ResultExec result : SystemTest.Smoke()) {
				lista.addResultado(result);
			}
		}
		
		if (testParam.isSecuritySmoke()) {
			Security_Smoke_Test SecurityTest = new Security_Smoke_Test(
					testParam.getShortIdioma());
			for (ResultExec result : SecurityTest.Smoke()) {
				lista.addResultado(result);
			}
		}
		
		
		if (testParam.isCheckupSmoke()) {
			Checkup_Smoke_Test CheckupTest = new Checkup_Smoke_Test(
					testParam.getShortIdioma());
			for (ResultExec result : CheckupTest.Smoke()) {
				lista.addResultado(result);
			}
		}
		
		
		if (testParam.supportSmoke) {
			Support_Smoke_Test SupportTest = new Support_Smoke_Test(
					testParam.getShortIdioma());
			for (ResultExec result : SupportTest.Smoke()) {
				lista.addResultado(result);
			}
		}
	}
	
	public static void selectSettingTests(){
		//testes de settings
			if(testParam.settings){
				for (ResultExec result : settings.Select_allchecks()) {
					lista.addResultado(result);
				}
				
				settings = new Settings_Tests(testParam.getShortIdioma());
				for (ResultExec result : settings.notificationArea()) {
					lista.addResultado(result);
				}
				
				settings = new Settings_Tests(testParam.getShortIdioma());
				for (ResultExec result : settings.welcomeScreen()) {
					lista.addResultado(result);
				}
			}
	}
		
	public static void selectDashboardTests(){
		//testes de settings
		dashboard = new Dashboard_Tests(testParam.getShortIdioma());
			if(testParam.dashboard){
					
				settings = new Settings_Tests(testParam.getShortIdioma());
				for (ResultExec result : dashboard.verify_Test()) {
					lista.addResultado(result);
				}
			}
	}
	
	public static void hardwareScan_test(){
		hardwarescan = new HardwareScan_Test(testParam.getShortIdioma());
		
		if(testParam.hardwarescan){
			for (ResultExec result : hardwarescan.hw_test()) {
				lista.addResultado(result);
			}
		}
	}
	
	public static void deviceManager_test(){
		deviceManager = new DeviceManager_Test(testParam.getShortIdioma());
		
		if(testParam.isDeviceManager()){
			for (ResultExec result : deviceManager.deviceManager_test()) {
				lista.addResultado(result);
			}
		}
	}
	
	public static void storageDevice_test(){
		storageDevice = new Storage_Devices_Test(testParam.getShortIdioma());
		
		if(testParam.isStorageDevices()){
			for (ResultExec result : storageDevice.storageDevice_test()) {
				lista.addResultado(result);
			}
		}
	}
		
	public static void memory_test(){
		memoryTest = new Memory_Test(testParam.getShortIdioma());
		
		if(testParam.isMemory()){
			for (ResultExec result : memoryTest.memory_test()) {
				lista.addResultado(result);
			}
		}
	}
	
	public static void backup_test(){
		backupTest = new Backup_Test(testParam.getShortIdioma());
		
		if(testParam.isBackup()){
			for (ResultExec result : backupTest.backup_test()) {
				lista.addResultado(result);
			}
		}
	}
	
}
