package pckServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {
	
	public static void main(String args[]) throws IOException {
		new Servidor(6789).start();
	}
	
	private int porta; // Porta onde o servidor escutara
	
	public Servidor (int porta) {
		// Porta que o servidor vai escutar
		this.porta = porta;
	}

	public void start() {
		
		try {
			ServerSocket servidor = new ServerSocket(this.porta);
			System.out.println("Servidor escutando na porta:" + this.porta);
			
			// Loop infinito aguardando conexoes...
			while(true) {
			
				Socket cliente = servidor.accept();
				
				System.out.println( "Nova conexão de: " 
				                  + cliente.getInetAddress().getHostAddress() );
				
				// Lança o cliente para a thread, liberando o fluxo
				ControlaCliente cc = new ControlaCliente(cliente);
				new Thread(cc).start();

			}
			
		}catch(Exception IOException){
			System.out.println("Erro " + IOException.getMessage());
		}

		System.out.println("Porta Aberta");
	}
	
}
