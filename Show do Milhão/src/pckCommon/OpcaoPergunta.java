package pckCommon;

public class OpcaoPergunta {
	int id;
	String descricao;
	boolean verdadeira;
	
	public OpcaoPergunta(String descricao, boolean verdadeira){
		this.descricao = descricao;
		this.verdadeira = verdadeira;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getVerdadeira() {
		return verdadeira;
	}

	public void setVerdadeira(boolean verdadeira) {
		this.verdadeira = verdadeira;
	}
}
