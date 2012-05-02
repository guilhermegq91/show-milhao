package pckServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor
{	
	public static void main(String args[]) throws IOException
	{
		String porta = javax.swing.JOptionPane.showInputDialog("Informe a porta para o servidor");
		
		if ( porta != null ) {
			new Servidor(Integer.valueOf(porta)).start();
		}
	}
	
	// Porta onde o servidor escutar�
	private int porta; 
	
	public Servidor (int porta)
	{
		this.porta = porta;
	}

	public void start()
	{	
		try
		{
			ServerSocket servidor = new ServerSocket(this.porta);
			System.out.println("Servidor escutando na porta: " + this.porta);
			
			// Loop infinito aguardando conexoes...
			while(true)
			{
				Socket cliente = servidor.accept();
				
				System.out.println("Nova conex�o de: " + cliente.getInetAddress().getHostAddress());
				
				// Lan�a o cliente para a thread, liberando o fluxo
				ControlaCliente cc = new ControlaCliente(cliente);
				new Thread(cc).start();
			}
			
		}
		
		catch(Exception IOException){ System.out.println("Erro " + IOException.getMessage()); }

		System.out.println("Porta Aberta");
	}
}
