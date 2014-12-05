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
    public String LSC_exit = caminho + "exitLSC.PNG";
    public String LSC_welcomeScreen;
    public String LSC_welcomeExit = caminho + "welcomeExit.PNG";
    public String verifyScroll = caminho + "verifyScroll.PNG";
    
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
    public String icn_errorBig = caminho + "icn_Error_big.png";
    public String icn_OkBig = caminho + "icnOk_60x60.png";
    public String icn_CancelBig = caminho + "icnCancel_60x60.png";
    public String icn_warningBig = caminho + "icn_Warning_big.png";
    
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
    
	public String alwaysshowWlcomeScreen;
    
    public String ok_button;
    public String alert_button;
    
	public String submit_service_request = caminho + "submit_service_request.png";
	
	public String ImageError = "Image not Found";
	
	
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
	    ok_button = "imgs/"+idioma+"/ok_button.PNG";
	    alwaysshowWlcomeScreen = "imgs/"+idioma+"/alwaysShowWelcomeScreen.PNG";
	    LSC_welcomeScreen = "imgs/"+idioma+"/welcomeScreen.PNG";
	    alert_button = "imgs/"+idioma+"/alertButton.PNG";
		}

}
