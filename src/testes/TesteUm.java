package testes;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.script.*;

import utilidades.ResultExec;

@SuppressWarnings("unused")
public class TesteUm {
	private static Robot rob;
	
	public ResultExec teste(String idioma)
	{
		Screen s = new Screen();
		
		ResultExec resultado = new ResultExec("TesteUM");
		
		//target.setMinScore(0.95);
		
		try {
						
			//java.awt.Desktop.getDesktop().open(new File("C:/Program Files/Lenovo/Lenovo Solution Center/LSC.exe"));
			
			java.awt.Desktop.getDesktop().open(new File("Linguagens/"+idioma+".bat"));
			
			//caminhos das imagens
			String tituloLSC = "imgs/"+idioma+"/LSC_appTitle.PNG";
			String quickBar = "imgs/"+idioma+"/Quickbar.PNG";
			
			//Tempo de espera para encontrar a imagem esperada
			s.wait(tituloLSC,15.0);
			
			s.click(quickBar);
					
			s.paste("未安装");
			s.wait(5.0);
			//s.paste("informção");
			s.type(Key.DOWN);
			s.type(Key.ENTER);
			
			//ScreenRegion sr = new ScreenRegion();
			
									
		} catch (IOException e) {
					
			//System.out.println("Imagem não encontrada");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return resultado;
		
		
	}

}
