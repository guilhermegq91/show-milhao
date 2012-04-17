package pckCommon;

import java.io.Serializable;

public abstract class BasePergResp implements Serializable{
	
	private String msg;
	
    //essa classe é abstrata. vai servir para polimorfismo.
	//a classe mensagem vai enviar um objeto herdado desta classe, assim facilita
	//para enviarmos outras coisas futuramente.
	
	public BasePergResp(String msg){
		this.msg = msg;		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String toString(){
		return msg;
	}
	

}
