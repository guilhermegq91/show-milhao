package pckCommon;

public class Resposta extends BasePergResp{
	int id;
	int id_pergunta;
	int id_opcaoEscolhida;
	
	public Resposta(String msg, int id, int id_pergunta, int id_opcaoEscolhida){
		super(msg);
		this.id = id;
		this.id_pergunta = id_pergunta;
		this.id_opcaoEscolhida = id_opcaoEscolhida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_resposta() {
		return id_pergunta;
	}

	public void setId_resposta(int id_resposta) {
		this.id_pergunta = id_resposta;
	}

	public int getId_opcaoEscolhida() {
		return id_opcaoEscolhida;
	}

	public void setId_opcaoEscolhida(int id_opcaoEscolhida) {
		this.id_opcaoEscolhida = id_opcaoEscolhida;
	}
}
