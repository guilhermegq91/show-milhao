package pckCommon;

import java.io.Serializable;

public class Mensagem implements Serializable{
	
	private BasePergResp obj;
	private String msg;
	private String remetente;
	
	public Mensagem(String msg) {
		this.msg = msg;
	}
	
	public Mensagem(String msg, String remetente)
	{
		this.msg = msg;
		this.remetente = remetente;
	}
	
	public Mensagem(BasePergResp obj, String msg)
	{
		this.obj = obj;
		this.msg = msg;
	}
	
	public BasePergResp getObj() 
	{
		return obj;
	}
	
	public void setObj(BasePergResp obj) 
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

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
	
	
}