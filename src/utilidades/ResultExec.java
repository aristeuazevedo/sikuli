package utilidades;

public class ResultExec {

	private boolean result;
	private String mensagem;
	private String nomeTeste;

	public ResultExec(String nomeTeste) {
		super();
		this.nomeTeste = nomeTeste;
		this.mensagem = "";
		this.result = false;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeTeste() {
		return nomeTeste;
	}

	public void setNomeTeste(String nomeTeste) {
		this.nomeTeste = nomeTeste;
	}

	// Encapsulamentos

}
