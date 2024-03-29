package pckCommon;

import java.io.Serializable;

import pckClient.Som;

public class Jogo implements Serializable
{
	private String nomeJogador;
	private String ipJogador;
	private int contPerguntas = 0;
	private double vlrUltPergunta;
	private ListaPerguntas perguntas;
	
	public Jogo(String nomeJogador, String ipJogador)
	{
		// Carrega a lista de perguntas deste jogo
		this.perguntas      = new ListaPerguntas("Resources/Perguntas.csv");
		this.nomeJogador    = nomeJogador;
		this.ipJogador      = ipJogador;
		this.contPerguntas  = 0;
		this.vlrUltPergunta = 0;
	}
	
	public String getNomeJogador()
	{
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador)
	{
		this.nomeJogador = nomeJogador;
	}

	public String getIpJogador()
	{
		return ipJogador;
	}

	public void setIpJogador(String ipJogador)
	{
		this.ipJogador = ipJogador;
	}

	public Pergunta proximaPergunta()
	{	
		double valorAcertar, valorParar, valorErrar;
		contPerguntas++;
		
		Pergunta p = null;
		if (contPerguntas <= 5)
			p = perguntas.sorteiaPergunta(NivelPergunta.FACIL);
		else if (contPerguntas <= 10)
			p = perguntas.sorteiaPergunta(NivelPergunta.MEDIO);
		else
			p = perguntas.sorteiaPergunta(NivelPergunta.DIFICIL);
		
		valorAcertar = this.getValorPergunta(contPerguntas);
		
		valorParar	 = this.getValorPergunta(contPerguntas - 1);
		valorParar   = ( valorParar < 0 ) ? 0 : valorParar;
		
		valorErrar	 = this.getValorPergunta(contPerguntas - 1) / 2;
		valorErrar	 = ( valorParar < 0 ) ? 0 : valorErrar;

		p.setContPergunta(contPerguntas);
		p.setValorAcertar(valorAcertar);
		p.setValorErrar(valorErrar);
		p.setValorParar(valorParar);
		
		return p;		
	}
	
	public double getValorPergunta(int pergunta)
	{
		double valor = 0;
		
        if (pergunta == 1) 
        	valor = 1000;
        else if (pergunta == 2) 
        	valor = 2000;
        else if (pergunta == 3) 
        	valor = 3000;
        else if (pergunta == 4) 
        	valor = 4000;
        else if (pergunta == 5) 
        	valor = 5000;
        
        // Segunda rodada
        else if (pergunta == 6) 
        	valor = 10000;
        else if (pergunta == 7) 
        	valor = 20000;
        else if (pergunta == 8) 
        	valor = 30000;
        else if (pergunta == 9) 
        	valor = 40000;
        else if (pergunta == 10) 
        	valor = 50000;
        
        // Terceira rodada
        else if (pergunta == 11) 
        	valor = 100000;
        else if (pergunta == 12) 
        	valor = 200000;
        else if (pergunta == 13) 
        	valor = 300000;
        else if (pergunta == 14) 
        	valor = 400000;
        else if (pergunta == 15) 
        	valor = 500000;
        
        // Final
        else if (pergunta == 16) 
        	valor = 1000000;

		return valor;
	}
		
	public void venceu()
	{
		Som.tocar("UmMilhao.wav");
		System.out.println("Voc� venceu.");
		encerra();
	}
	
	public void perdeu()
	{
		System.out.println("Voc� perdeu.");
		encerra();
	}
	
	public void encerra()
	{
		Som.tocar("Fim.wav");
		System.exit(0);
	}
	
	
	/*public static void main(String args[])
	{
		Jogo j = new Jogo("vini", "127.0.0.1");
		
		Teclado t = new Teclado();
		
		ArrayList<Pergunta> perguntaFacil	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaMedio	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaDificil	= new ArrayList<Pergunta>();
		
		CadastroPerguntas perguntas = new CadastroPerguntas("Resources/Perguntas.csv");
		//perguntas.ImportaCSV( new File("Resources/Perguntas.csv") );
		
		System.out.println("Bem vindo\n");
				
		Pergunta p = null;
		int alternativa;
		
		double valorAcertar, valorParar, valorErrar;
		
		int nrPergunta = 10;
		while(true)
		{
			if (nrPergunta <= 5)
			{
				if (nrPergunta == 1)
					Som.tocar("Rodada1.wav");
				
				p = perguntas.sorteiaPergunta(NivelPergunta.FACIL);
			}
			
			else if (nrPergunta <= 10)
			{
				if (nrPergunta == 6)
					Som.tocar("Rodada2.wav");
				
				p = perguntas.sorteiaPergunta(NivelPergunta.MEDIO);	
			}
							
			
			else if (nrPergunta <= 15)
			{
				if (nrPergunta == 11)
					Som.tocar("Rodada3.wav");
				
				p = perguntas.sorteiaPergunta(NivelPergunta.DIFICIL);
			}

			else if (nrPergunta == 16 )
				p = perguntas.sorteiaPergunta(NivelPergunta.DIFICIL);

			else
				j.venceu();
			
			// - Acertar: ValorPergunta
			// - Parar: ValorPerguntaAnterior
			// - Errar: ValorPerguntaAnterior/2
		    
			
			valorAcertar = Math.pow(10, Math.ceil(nrPergunta / 5) + 2) * (   Math.ceil(nrPergunta / 5)           );
			valorParar	 = Math.pow(10, Math.ceil(nrPergunta / 5) + 2) * (   Math.ceil(nrPergunta / 5) - 1       );
			valorErrar	 = Math.pow(10, Math.ceil(nrPergunta / 5) + 2) * ( ( Math.ceil(nrPergunta / 5) - 1 ) / 2 );
			Som.tocar("Question/" + (int)valorAcertar + ".wav");
			
			System.out.println(p + " (5) PULAR |");
			
			System.out.println("ACERTAR: " + valorAcertar + " PARAR: " + valorParar + " ERRAR: " + valorErrar);
			
			
			alternativa = t.leInt("\nDigite o n�mero correspondente a alternativa desejada.");
			
			if ( alternativa == 5 )
			{
				System.out.println("Voc� pulou.\n");
				continue;
			}
			
			else if ( p.getOpcoes()[alternativa - 1].getVerdadeira() ) 
			{
				System.out.println("Resposta correta.\n");
				Som.tocar("RespostaCerta.wav");
				nrPergunta++;
			}
			
			else
			{
				System.out.println("Resposta incorreta.\n");
				Som.tocar("RespostaErrada.wav");
				j.perdeu();
			}
		}
	}*/
}
