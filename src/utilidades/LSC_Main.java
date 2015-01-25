package utilidades;

public class LSC_Main {

	String idioma = "";

	String caminho = "imgs/module_icons/";
	
	String check_repair_status = caminho + "check_repair_status.png";
	String icn_DefaultExe_LE = caminho + "icn_DefaultExe_LE.png";
	String icn_DefaultURL_LE = caminho + "icn_DefaultURL_LE.png";
	String icn_predictive = caminho + "icn_predictive.png";
	String icn_premiumSupport = caminho + "icn_premiumSupport.png";
	String icn_recoveryMedia = caminho + "icn_recoveryMedia.png ";
	String icn_systemMonitor_title = caminho + "icn_systemMonitor_title.png";
	String icn_systemMonitor = caminho + "icn_systemMonitor.png";
    public String LSC_Title = caminho + "LSC_appTitle.png";
    
    public String icn_save = caminho + "icnSave.png";
    public String icn_info = caminho + "icnInfo.png";
    
    //icones do Access Support Online
    public String virtualAgente = caminho + "lenovoVirtualAgentIcon.png";
    
    //icones do Access Support Online Chines
    public String moreInfo = caminho + "icn_MoreHelp.png";
    public String expert = caminho + "icn_ExpertOnline.png";
    public String selfHelp = caminho + "icn_SelfHelp.png";
    public String onlineRepair = caminho + "icn_OnlineRepair.png";
    public String lenovoRobot = caminho + "icn_LenovoRobot.png";
    public String icn_AskLenovo = caminho + "icn_AskLenovo.png";
    
    public String CheckupSel;
    public String CheckupUns;
    public String HomeSel;
    public String HomeUns;
    public String SecuritySel;
    public String SecurityUns;
    public String SupportSel;
    public String SupportUns;
    public String SystemSel;
    public String SystemUns;
    
    
	String submit_service_request = caminho + "submit_service_request.png";
	
	
	public LSC_Main(String idioma) {
		
		this.idioma = idioma;
		
		CheckupSel = "imgs/"+idioma+"/CheckupTabSelected.PNG";
	    CheckupUns = "imgs/"+idioma+"/CheckupTabUnselected.PNG";
	    HomeSel = "imgs/"+idioma+"/HomeTabSelected.PNG";
	    HomeUns = "imgs/"+idioma+"/HomeTabUnselected.PNG";
	    SecuritySel = "imgs/"+idioma+"/SecurityTabSelected.PNG";
	    SecurityUns = "imgs/"+idioma+"/SecurityTabUnselected.PNG";
	    SupportSel = "imgs/"+idioma+"/SupportTabSelected.PNG";
	    SupportUns = "imgs/"+idioma+"/SupportTabUnselected.PNG";
	    SystemSel = "imgs/"+idioma+"/SystemTabSelected.PNG";
	    SystemUns = "imgs/"+idioma+"/SystemTabUnselected.PNG";
		}

}
