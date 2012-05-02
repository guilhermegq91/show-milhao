package pckServer;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.*;

import org.omg.CORBA.RepositoryIdHelper;

import pckCommon.*;

public class ControlaCliente implements Runnable {

	// Socket dos dados que entram
	private Socket clienteIn;
	
	// Socket dos dados que saem
	private Socket clienteOut;
	
	// Stream de entrada
	private ObjectInputStream in;

	// Stream de saida
	private ObjectOutputStream out;
	
	// Pacote a ser enviado
	private Mensagem m;
	
	// Instancia do jogo
	private Jogo j;
	
	// Instancia da pergunta atual
	private Pergunta p;

	public ControlaCliente(Socket clienteIn) {
		this.clienteIn = clienteIn;
	}
	
	public void run() {
		
		// Controla o Jogo
		try {
			
			// Recebe primeira conexao
			ObjectInputStream input = new ObjectInputStream(clienteIn.getInputStream());
	        m = (Mensagem) input.readObject();
	        
	        
			// Verifica a acao a ser tomada
	        if (m.getMsg().equals("inicia")) {
	        		
	        	// Inicia novo jogo instanciando nova classe (sobreescrevendo se necessario)
	        	j = new Jogo( m.getRemetente()
	        			    , clienteIn.getInetAddress().getHostAddress() );
	        	
	        	// Transmite proxima pergunta para o jogador (salva socket)
	        	Socket c = new Socket(clienteIn.getInetAddress().getHostAddress()
	        			             , 6777);
	        	clienteOut = c;
	        	
	        	// Sorteia proxima pergunta
	        	p = j.proximaPergunta();
	        	
	        	// Empacota pergunta
	        	m = new Mensagem(p, "Pergunta");
	        	
	        	// Envia pergunta
	        	try {
	        		out = new ObjectOutputStream(c.getOutputStream());
	        		out.flush();
	        		out.writeObject(m);
	        		out.flush();
	        		
	        		// Trata o retorno do cliente (inicia logica do jogo)
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
	
	/**
	 * Trata os dados recebidos do Client e coordena o tratamento das perguntas
	 * @return void
	 */
	public void trataRetorno() {
		
		try {
			// Salva Stream
			in = new ObjectInputStream(clienteIn.getInputStream());
			
			// Transforma objeto recebido em Mensagem
	        m = (Mensagem) in.readObject();
	        
	        // Verifica se foi enviado uma resposta
	        if (m.getObj() instanceof Resposta) {
	        	
	        	// Transforma objeto em uma resposta
	        	Resposta r = (Resposta) m.getObj();

	        	// Verifica se acertou ou errou
	        	if ( p.getOpcoes()[r.getId_opcaoEscolhida()].getVerdadeira() ) {
	        		
	        		// Retorna acerto
	        		out.writeObject( new Mensagem("Certa") );
	        		out.flush();
	        		
	        		// Perguntas antes de 1 milhao
	        		if ( p.getContPergunta() < 16 ) { 
		        		
	        			// Sorteia proxima
		        		p = j.proximaPergunta();
		        		
		        		// Envia pacote para o cliente  
		        		out.writeObject( new Mensagem(p, "pergunta") );
		        		out.flush();

	        		} else {
	        			// Ganhou
		        		out.writeObject( new Mensagem("Ganhou") );
		        		out.flush();
	        		}
	        		
	        		// Recursao para receber proxima informacao
	        		trataRetorno();
	        	} else {

	        		// Retorna erro
	        		out.writeObject( new Mensagem("Errada") );
	        		out.flush();
	        	}
	        }

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
