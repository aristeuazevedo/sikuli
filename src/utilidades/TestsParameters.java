package utilidades;

/**
 * 
 * This class stores the informations that the user selects previously
 * 
 * @param idioma
 *            language selected for executes the tests 
 * @param shortIdioma
 *            shortIdioma of the language selected
 * @param machineName
 *            name of machine, used in configurations
 * @author Aristeu Azevedo
 */
public class TestsParameters {

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
	private boolean memory;
	private boolean backup;

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getShortIdioma() {
		return shortIdioma;
	}

	public void setShortIdioma(String shortIdioma) {
		this.shortIdioma = shortIdioma;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
	
	public boolean isSupportSmoke() {
		return supportSmoke;
	}

	public void setSupportSmoke(boolean supportSmoke) {
		this.supportSmoke = supportSmoke;
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

	public boolean isMemory() {
		return memory;
	}

	public void setMemory(boolean memory) {
		this.memory = memory;
	}

	public boolean isBackup() {
		return backup;
	}

	public void setBackup(boolean backup) {
		this.backup = backup;
	}

}
