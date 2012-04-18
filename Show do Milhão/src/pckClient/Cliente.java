package pckClient;

import java.io.ObjectOutputStream;
import java.net.Socket;

import pckCommon.*;


public class Cliente {
	
	private Socket cliente;
	private Resposta resp = null;
	
	public Cliente(){
		resp = new Resposta("START", 0, 0, 0);
	}
	
	/*
	 * Conecta com o servidor
	 */
	public void conectaSocket() {
		try {
			Socket c = new Socket("127.0.0.1", 6789);
			cliente = c;
			
		}catch (Exception e) {
			System.out.println("Erro (1): " + e);
		}
	}
	
	/*
	 * Envia pacote "start" para o sincronizar novo jogo com o servidor
	 */
	public boolean iniciaJogo() {
		conectaSocket();
		
		ObjectOutputStream output;
		
		try {
			output = new ObjectOutputStream(cliente.getOutputStream());
			
			output.flush();
	        output.writeObject(resp);
	        output.flush();
	        output.close();
	        
		}catch (Exception e) {
			System.out.println("Erro (2): " + e);
		}
		return true;
	}

	/*
	 * Envia uma resposta genérica
	 */
	public boolean enviaResposta() {
		
		return true;
	}
	
}
