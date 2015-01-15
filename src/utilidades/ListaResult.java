package utilidades;

import java.util.ArrayList;
import java.util.List;

public class ListaResult {
	
	private List<ResultExec> lista = new ArrayList<ResultExec>();
	
	public void addResultado( ResultExec elemento)
	{
		lista.add(elemento);				
	}
	

}
