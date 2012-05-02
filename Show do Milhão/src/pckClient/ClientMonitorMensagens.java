package pckClient;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import pckCommon.Mensagem;

public class ClientMonitorMensagens implements Runnable
{
	private Cliente cliente;
	private ServerSocket socketRecepcao;
	private Socket socketConexao;
	private ObjectInputStream input;
	
	public ClientMonitorMensagens(Cliente cliente)
	{
		this.cliente = cliente;
		
		try
		{
			this.socketRecepcao = new ServerSocket(6789);
			this.socketConexao = socketRecepcao.accept();
			this.input = new ObjectInputStream(socketConexao.getInputStream());
		}
		
		catch(Exception e) {JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.WARNING_MESSAGE); }
	}

	public void run()
	{
		Mensagem msg;
		
		try
		{
			while(true)
				msg  = (Mensagem)input.readObject();
		}
		
		catch(Exception e) { JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.WARNING_MESSAGE); }
	}

}
