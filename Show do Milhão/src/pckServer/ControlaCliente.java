package pckServer;


import java.io.ObjectInputStream;
import java.net.*;
import java.util.*;
import pckCommon.*;

public class ControlaCliente implements Runnable {

	private Socket cliente;

	public ControlaCliente(Socket cliente) {
		this.cliente = cliente;
	}
	
	public void run() {
		
		Mensagem m;
		
		// Controla o Jogo
		try {
			
			ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());
	        m = (Mensagem) input.readObject();

			// Verifica o que o cliente enviou
			switch( m.getId() ) {
				case 0:
					System.out.println("Enviar primeira pergunta");
				break;
			}
			
			// Instancia 
			
		}catch(Exception IOException){
			System.out.println("Erro " + IOException.getMessage());
		}
	}
	
}
