package pckServer;

import java.net.*;
import java.util.*;

public class ControlaCliente implements Runnable {

	private Socket cliente;

	public ControlaCliente(Socket cliente) {
		this.cliente = cliente;
	}
	
	public void run() {
		
		// Controla o Jogo
		try {
			Scanner s = new Scanner (this.cliente.getInputStream());
				
			while (s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
			
		}catch(Exception IOException){
			System.out.println("Erro " + IOException.getMessage());
		}
	}
	
}
