package utilidades;

import java.util.ArrayList;
import java.util.List;

public class ResultExec {

	private boolean result;
	
	private List<String> mensagens = new ArrayList<String>();
	private String nomeTeste;

	public ResultExec(String nomeTeste) {
		super();
		this.nomeTeste = nomeTeste;
		this.result = false;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
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

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}

	// Encapsulamentos

}
