package utilidades;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;

public class Utilidades {
	
	private  static Robot rob;
	
	//chama o metodo de captura e salva a imagem como jpg
	public static void print(String str) throws IOException
	{
		try{
			rob = new Robot();
				
		}catch(AWTException e1) {
			throw new RuntimeException("Unable to initialize",e1);		
		}
		
		BufferedImage image = Utilidades.capture();
		
		ImageIO.write(image, "jpg", new File("C:\\Users\\Lenovo\\Desktop\\victorwork\\"+str+".jpg"));
		
		
	}
	
	//captura tela da maquina, qualquer dimensao
	public static BufferedImage capture()
	{
		return rob.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	}
	
	//retorna a data atual da maquina
	public static void horaData ()
	{
		GregorianCalendar gc = new GregorianCalendar();
		Date data = gc.getTime();
			
		System.out.println(data);
		
	}
	

}
