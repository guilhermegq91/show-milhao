package pckCommon;

import java.io.Serializable;

public abstract class ObjetoMensagem implements Serializable
{
	private String msg;
	
    /* Esta classe é abstrata e serve para polimorfismo.
	 * A classe mensagem envia um objeto herdado desta classe, facilitando
	 * para enviarmos outras coisas futuramente. */
	
	public ObjetoMensagem(String msg)
	{
		this.msg = msg;		
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	
	public String toString()
	{
		return msg;
	}
}
