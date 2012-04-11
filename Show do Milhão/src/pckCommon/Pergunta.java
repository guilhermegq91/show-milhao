package pckCommon;

public class Pergunta
{
	private int id;
	private String descricao;
	private NivelPergunta nivel;
	private OpcaoPergunta[] opcoes; //array de opcoes
	private int resposta;
	private String mensagem;

	public Pergunta(int id, String descricao, OpcaoPergunta[] opcoes, int resposta, NivelPergunta nivel)
	{
		this.id			= id;
		this.descricao	= descricao;
		this.opcoes		= opcoes;
		this.resposta	= resposta;
		this.nivel		= nivel;
	}

	public int getResposta()
	{
		return resposta;
	}

	public void setResposta(int resposta)
	{
		this.resposta = resposta;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public NivelPergunta getNivel()
	{
		return nivel;
	}

	public void setNivel(NivelPergunta nivel)
	{
		this.nivel = nivel;
	}

	public OpcaoPergunta[] getOpcoes()
	{
		return opcoes;
	}

	public void setOpcoes(OpcaoPergunta[] opcoes)
	{
		this.opcoes = opcoes;
	}
	
	public String getMensagem(){
		return mensagem;
	}
	
	public void setMensagem(String mensagem){
		this.mensagem = mensagem;
	}
}
