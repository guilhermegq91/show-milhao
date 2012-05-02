package pckServer;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.*;

import org.omg.CORBA.RepositoryIdHelper;

import pckCommon.*;

public class ControlaCliente implements Runnable {

	private Socket clienteIn;
	private Socket clienteOut;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Mensagem m;
	private Jogo j;
	private Pergunta p;

	public ControlaCliente(Socket clienteIn) {
		this.clienteIn = clienteIn;
	}
	
	public void run() {
		
		
		
		// Controla o Jogo
		try {
			
			ObjectInputStream input = new ObjectInputStream(clienteIn.getInputStream());
	        m = (Mensagem) input.readObject();
	        
	        
			// Verifica a a��o a ser tomada
	        if (m.getMsg().equals("inicia")) {
	        		
	        	// Inicia novo jogo instanciando nova classe (sobreescrevendo se necessario)
	        	j = new Jogo( m.getRemetente()
	        			    , clienteIn.getInetAddress().getHostAddress() );
	        	
	        	// Transmite pr�xima pergunta para o jogador (salva socket)
	        	Socket c = new Socket(clienteIn.getInetAddress().getHostAddress()
	        			             , 6777);
	        	clienteOut = c;
	        	p = j.proximaPergunta();

	        	m = new Mensagem(p, "Pergunta");
	        	
	        	try {
	        		out = new ObjectOutputStream(c.getOutputStream());
	        		out.flush();
	        		out.writeObject(m);
	        		out.flush();
	        		//out.close();
	        		
	        		trataRetorno();

	        	} catch (Exception e) {
	    			System.out.println("Erro (2): " + e);
	    		}
	        	
	        } else {
	        	
	        }
			
		}catch(Exception IOException){
			System.out.println("Erro " + IOException);
		}
	}
	
	public void trataRetorno() {
		try {
			in = new ObjectInputStream(clienteIn.getInputStream());
	        m = (Mensagem) in.readObject();
	        
	        if (m.getObj() instanceof Resposta) {
	        	
	        	Resposta r = (Resposta) m.getObj();

	        	// Verifica se acertou ou errou
	        	if ( p.getOpcoes()[r.getId_opcaoEscolhida()].getVerdadeira() ) {
	        	//if ( true ) {
	        		
	        		// Retorna acerto
	        		out.writeObject( new Mensagem("Certa") );
	        		out.flush();
	        		
	        		if ( p.getContPergunta() < 16 ) { 
		        		
	        			// Sorteia pr�xima
		        		p = j.proximaPergunta();
		        		out.writeObject( new Mensagem(p, "pergunta") );
		        		out.flush();

	        		} else {
		        		out.writeObject( new Mensagem("Ganhou") );
		        		out.flush();
	        		}

	        		trataRetorno();
	        	} else {
	        		// Retorna erro
	        		out.writeObject( new Mensagem("Errada") );
	        		out.flush();
	        	}

	        } else {
	        	if (m.getMsg() == "Pular") {

	        	}
	        }

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
