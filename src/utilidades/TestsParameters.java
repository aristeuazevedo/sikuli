package utilidades;


/**
 * Classe que armazena os dados que o usuário selecionou previamente
 * @param	idioma	Idioma selecionado para executar os testes
 * @param	shortIdioma	Sigla do idioma selecionado
 * @param	machineName	Nome da máquina, usado para Configurações 
 * @author	Aristeu Azevedo
 */
public class TestsParameters {
	public boolean isSettings() {
		return settings;
	}
	public void setSettings(boolean settings) {
		this.settings = settings;
	}
	public boolean isAlerts() {
		return alerts;
	}
	public void setAlerts(boolean alerts) {
		this.alerts = alerts;
	}
	public boolean isDashboard() {
		return dashboard;
	}
	public void setDashboard(boolean dashboard) {
		this.dashboard = dashboard;
	}
	public String idioma;
	public String shortIdioma;
	public String machineName;
	public String data;
	
	public boolean checkupSmoke;
	public boolean securitySmoke;
	public boolean systemSmoke;
	public boolean supportSmoke;
	
	public boolean settings;
	public boolean alerts;
	public boolean dashboard;
	public boolean hardwarescan;
	
	private boolean deviceManager;
	private boolean storageDevices;
	
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public boolean isCheckupSmoke() {
		return checkupSmoke;
	}
	public void setCheckupSmoke(boolean checkupSmoke) {
		this.checkupSmoke = checkupSmoke;
	}
	public boolean isSecuritySmoke() {
		return securitySmoke;
	}
	public void setSecuritySmoke(boolean securitySmoke) {
		this.securitySmoke = securitySmoke;
	}
	public boolean isSystemSmoke() {
		return systemSmoke;
	}
	public void setSystemSmoke(boolean systemSmoke) {
		this.systemSmoke = systemSmoke;
	}
	public boolean isSupportSmoke() {
		return supportSmoke;
	}
	public void setSupportSmoke(boolean supportSmoke) {
		this.supportSmoke = supportSmoke;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getShortIdioma() {
		return shortIdioma;
	}
	public void setShortIdioma(String shortIdioma) {
		this.shortIdioma = shortIdioma;
	}
	public boolean isHardwarescan() {
		return hardwarescan;
	}
	public void setHardwarescan(boolean hardwarescan) {
		this.hardwarescan = hardwarescan;
	}
	public boolean isDeviceManager() {
		return deviceManager;
	}
	public void setDeviceManager(boolean deviceManager) {
		this.deviceManager = deviceManager;
	}
	public boolean isStorageDevices() {
		return storageDevices;
	}
	public void setStorageDevices(boolean storageDevices) {
		this.storageDevices = storageDevices;
	}
	
}
