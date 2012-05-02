package pckCommon;

import java.io.Serializable;

public class Mensagem implements Serializable
{	
	private ObjetoMensagem obj;
	private String msg;
	private String remetente;
	
	public Mensagem(String msg)
	{
		this.msg = msg;
	}
	
	public Mensagem(String msg, String remetente)
	{
		this.msg = msg;
		this.remetente = remetente;
	}
	
	public Mensagem(ObjetoMensagem obj, String msg)
	{
		this.obj = obj;
		this.msg = msg;
	}
	
	public ObjetoMensagem getObj() 
	{
		return obj;
	}
	
	public void setObj(ObjetoMensagem obj) 
	{
		this.obj = obj;
	}
	
	public String getMsg() 
	{
		return msg;
	}
	
	public void setMsg(String msg) 
	{
		this.msg = msg;
	}

	public String getRemetente()
	{
		return remetente;
	}

	public void setRemetente(String remetente)
	{
		this.remetente = remetente;
	}	
}