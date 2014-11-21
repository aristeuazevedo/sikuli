package utilidades;


/**
 * Classe que armazena os caminhos das imagens comuns
 * Usadas por todas as outras telas
 * @author	Aristeu Azevedo
 */
public class LSC_Main {

	String idioma = "";

	String caminho = "imgs/module_icons/";
	
	String check_repair_status = caminho + "check_repair_status.png";
	String icn_DefaultExe_LE = caminho + "icn_DefaultExe_LE.png";
	String icn_DefaultURL_LE = caminho + "icn_DefaultURL_LE.png";
	String icn_predictive = caminho + "icn_predictive.png";
	
	String icn_recoveryMedia = caminho + "icn_recoveryMedia.png ";
	String icn_systemMonitor_title = caminho + "icn_systemMonitor_title.png";
	String icn_systemMonitor = caminho + "icn_systemMonitor.png";
    public String LSC_Title = caminho + "LSC_appTitle.png";
    
    
    
    //icones do Access Support Online
    public String virtualAgente = caminho + "lenovoVirtualAgentIcon.png";
    public String lenovoForum = caminho + "lenovoForumIcon.png";
    public String lenovoSupport = caminho + "lenovoSupportIcon.png";
    
    //icones do Access Support Online Chines
    public String moreInfo = caminho + "icn_MoreHelp.png";
    public String expert = caminho + "icn_ExpertOnline.png";
    public String selfHelp = caminho + "icn_SelfHelp.png";
    public String onlineRepair = caminho + "icn_OnlineRepair.png";
    public String lenovoRobot = caminho + "icn_LenovoRobot.png";
    public String icn_AskLenovo = caminho + "icn_AskLenovo.png";
    
    //alertas
    public String icn_warning = caminho + "icn_accordionWarning.png";
    public String icn_error = caminho + "icn_accordionError.png";
    public String icn_aborted = caminho + "icn_accordionAborted.png";
    public String icn_ok = caminho + "icn_accordionOK.png";
    public String icn_save = caminho + "icnSave.png";
    public String icn_info = caminho + "icnInfo.png";
    public String btn_back = caminho + "btnBackActive.png";
    		
    
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
