package pckServer;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import pckClient.Cliente;
import pckCommon.Mensagem;

public class ServerMonitorMensagens implements Runnable  {
	private Servidor serv;
	private ServerSocket socketRecepcao;
	private Socket socketConexao;
	private ObjectInputStream input;
	
	public ServerMonitorMensagens(Servidor serv){
		this.serv = serv;
		try{
			this.socketRecepcao = new ServerSocket(6789);
			this.socketConexao = socketRecepcao.accept();
			this.input = new ObjectInputStream(socketConexao.getInputStream());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.WARNING_MESSAGE);							
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		Mensagem msg;
		try{
		  while(true){
			  msg  = (Mensagem)input.readObject();
		  }
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.WARNING_MESSAGE);							
		}
	}	
}
