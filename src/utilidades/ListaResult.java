package utilidades;

import java.util.ArrayList;
import java.util.List;

public class ListaResult {
	
	private String nomeMaquina;
	private String data;
	private String idioma;
	
	public List<ResultExec> listaResultado = new ArrayList<ResultExec>();
	
	public ListaResult(String nomeMaquina, String data, String idioma) {
		super();
		this.nomeMaquina = nomeMaquina;
		this.data = data;
		this.setIdioma(idioma);
	}


	public void addResultado( ResultExec elemento)
	{
		listaResultado.add(elemento);				
	}

	public String getNomeMaquina() {
		return nomeMaquina;
	}

	public void setNomeMaquina(String nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	

}
