package pckServer;

import java.io.ObjectInputStream;
import java.net.Socket;

import pckCommon.Comando;
import pckCommon.Jogo;
import pckCommon.Mensagem;
import pckCommon.Pergunta;
import pckCommon.Resposta;

public class ControlaCliente implements Runnable
{
	private Socket cliente;

	public ControlaCliente(Socket cliente)
	{
		this.cliente = cliente;
	}
	
	public void run()
	{
		Mensagem m;
		
		// Controla o Jogo
		try
		{
			ObjectInputStream input = new ObjectInputStream( cliente.getInputStream() );
	        
			while (true)
			{
				m = (Mensagem) input.readObject();
				
				// A mensagem contém um comando
				if (m.getObj() instanceof Comando)
				{
					System.out.println("Recebido um comando.");
					Comando comando = (Comando) m.getObj();
					
					switch ( comando.getTipo() )
					{
						case 1:
						{
							Jogo j = new Jogo(comando.getMsg(), cliente.getInetAddress().toString());
						}
							
					}					
				}
				
				else if (m.getObj() instanceof Pergunta)
				{
					System.out.println("Recebida uma pergunta.");
				}
				
				else if (m.getObj() instanceof Resposta)
				{
					System.out.println("Recebida uma resposta.");
				}
			}
	        
	        /*// Verifica o que o cliente enviou
			switch( m.getObj() )
			{
				case 0:
					System.out.println("Enviar primeira pergunta");
				break;
			}*/
			
			// Instancia 
		}
		
		catch(Exception IOException){ System.out.println("Erro " + IOException.getMessage()); }
	}
	
}
