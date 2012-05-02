package pckCommon;

public class Comando extends BasePergResp
{
	private static final int IDENTIFICACAO = 1;
	
	public int getTipo()
	{
		return tipo;
	}

	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}

	private int tipo;
	
	public Comando(int tipo, String msg)
	{
		super(msg);
		this.tipo = tipo;
	}
}
