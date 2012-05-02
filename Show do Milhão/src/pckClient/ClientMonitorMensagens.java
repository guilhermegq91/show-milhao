package pckClient;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import pckCommon.Mensagem;

public class ClientMonitorMensagens implements Runnable {

	private Cliente cl;
	private ServerSocket socketRecepcao;
	private Socket socketConexao;
	private ObjectInputStream input;
	
	public ClientMonitorMensagens(Cliente cl){
		this.cl = cl;
		try{
			this.socketRecepcao = new ServerSocket(6788);
			this.socketConexao = socketRecepcao.accept();
			this.input = new ObjectInputStream(socketConexao.getInputStream());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.WARNING_MESSAGE);							
		}
	}
	
	@Override
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
