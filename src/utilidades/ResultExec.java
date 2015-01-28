package utilidades;

import java.util.ArrayList;
import java.util.List;

public class ResultExec {
	
	private String nomeMaquina;
	
	
	private boolean result;
	private List<String> mensagens = new ArrayList<String>();
	private String nomeTeste;

	public ResultExec(String nomeTeste) {
		super();
		this.nomeTeste = nomeTeste;
		this.result = false;
	}


	public String getNomeTeste() {
		return nomeTeste;
	}

	public void setNomeTeste(String nomeTeste) {
		this.nomeTeste = nomeTeste;
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void addMensagens(String mensagens) {
		this.mensagens.add(mensagens);
	}

	public String getNomeMaquina() {
		return nomeMaquina;
	}

	public void setNomeMaquina(String nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}

	// Encapsulamentos

}
