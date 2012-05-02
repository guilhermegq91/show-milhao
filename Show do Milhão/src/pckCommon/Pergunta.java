package pckCommon;

import java.io.Serializable;

public class Pergunta extends ObjetoMensagem implements Serializable
{
	private int             id;
	private String          descricao;
	private NivelPergunta   nivel;
	private OpcaoPergunta[] opcoes; // Array de opções    
	private double          valorAcertar;
	private double          valorParar;
	private double          valorErrar;
	private int             contPergunta;

	public Pergunta(String msg, int id, String descricao, OpcaoPergunta[] opcoes, NivelPergunta nivel)
	{
		super(msg);
		this.id		   = id;
		this.descricao = descricao;
		this.opcoes	   = opcoes;
		this.nivel	   = nivel;
		this.valorAcertar = 0;
		this.valorErrar   = 0;
		this.valorParar   = 0;
	}

	public int getContPergunta()
	{
		return contPergunta;
	}

	public void setContPergunta(int contPergunta)
	{
		this.contPergunta = contPergunta;
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
	
		
	public double getValorAcertar()
	{
		return valorAcertar;
	}

	public void setValorAcertar(double valorAcertar)
	{
		this.valorAcertar = valorAcertar;
	}

	public double getValorParar()
	{
		return valorParar;
	}

	public void setValorParar(double valorParar)
	{
		this.valorParar = valorParar;
	}

	public double getValorErrar()
	{
		return valorErrar;
	}

	public void setValorErrar(double valorErrar)
	{
		this.valorErrar = valorErrar;
	}

	@Override
	public String toString()
	{	
		String texto = getDescricao() + "\n| ";
		
		for(int i = 0; i < getOpcoes().length; i++)
			texto += "(" + (i + 1) + ") " + getOpcoes()[i] + " | ";
		
		return texto;
	}
}
