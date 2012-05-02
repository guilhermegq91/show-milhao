package pckClient;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import pckCommon.BasePergResp;
import pckCommon.Mensagem;
import pckCommon.Pergunta;

public class ClientMonitorMensagens implements Runnable
{
	private Cliente cliente;
	private ServerSocket socketRecepcao;
	private Socket socketConexao;
	private ObjectInputStream input;
	
	public ClientMonitorMensagens(Cliente cliente)
	{
		this.cliente = cliente;
	}

	@Override
	public void run()
	{
		Mensagem msg;

		try
		{
			this.socketRecepcao = new ServerSocket(6788);
			
		}
		
		catch(Exception e) {JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.WARNING_MESSAGE); }
		
		try
		{
			while(true)
			{
				this.socketConexao = socketRecepcao.accept();
				this.input = new ObjectInputStream(socketConexao.getInputStream());
				msg = (Mensagem)input.readObject();
				BasePergResp obj = msg.getObj();
				if(obj instanceof Pergunta)
				{
					cliente.getFrameCl().exibePergunta((Pergunta)obj);
				}
			}
		}
		
		catch(Exception e) { JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.WARNING_MESSAGE); }
	}

}
