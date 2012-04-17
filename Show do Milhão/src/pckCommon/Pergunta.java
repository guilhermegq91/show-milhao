package pckCommon;

public class Pergunta extends BasePergResp
{
	private int id;
	private String descricao;
	private NivelPergunta nivel;
	private OpcaoPergunta[] opcoes; //array de opcoes	

	public Pergunta(String msg, int id, String descricao, OpcaoPergunta[] opcoes, NivelPergunta nivel)
	{
		super(msg);
		this.id			= id;
		this.descricao	= descricao;
		this.opcoes		= opcoes;
		this.nivel		= nivel;
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
}
