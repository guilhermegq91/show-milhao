package pckCommon;

import java.io.File;
import java.util.ArrayList;

import pckClient.Som;

public class Jogo
{

	private String nomeJogador;
	private String ipJogador;
	private int contPerguntas;
	private double vlrUltPergunta;
	private CadastroPerguntas perguntas;
	
	public Jogo(String nomeJogador, String ipJogador)
	{
		//carrega a lista de perguntos deste jogo
		this.perguntas = new CadastroPerguntas("Resources/Perguntas.csv");
		this.nomeJogador = nomeJogador;
		this.ipJogador = ipJogador;
		this.contPerguntas = 1;
		this.vlrUltPergunta = 0;
	}
	
	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public String getIpJogador() {
		return ipJogador;
	}

	public void setIpJogador(String ipJogador) {
		this.ipJogador = ipJogador;
	}

	public Pergunta proximaPergunta()
	{	
		double valorAcertar, valorParar, valorErrar;
		perguntas.sorteiaPergunta(NivelPergunta.FACIL);
		contPerguntas++;
		return null;		
	}
	
	//-----------------------------------------------------------------------------
	//testes
	//-----------------------------------------------------------------------------
	public void venceu()
	{
		Som.tocar("UmMilhao.wav");
		System.out.println("Você venceu.");
		encerra();
	}
	
	public void perdeu()
	{
		System.out.println("Você perdeu.");
		encerra();
	}
	
	public void encerra()
	{
		Som.tocar("Fim.wav");
		System.exit(0);
	}
	
	
	public static void main(String args[])
	{
		Jogo j = new Jogo();
		
		Teclado t = new Teclado();
		
		ArrayList<Pergunta> perguntaFacil	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaMedio	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaDificil	= new ArrayList<Pergunta>();
		
		CadastroPerguntas perguntas = new CadastroPerguntas(perguntaFacil, perguntaMedio, perguntaDificil);
		perguntas.ImportaCSV( new File("Resources/Perguntas.csv") );
		
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
			
			/*   - Acertar: ValorPergunta
				   - Parar: ValorPerguntaAnterior
				   - Errar: ValorPerguntaAnterior/2
		    */
			
			valorAcertar = Math.pow(10, Math.ceil(nrPergunta / 5) + 2) * (   Math.ceil(nrPergunta / 5)           );
			valorParar	 = Math.pow(10, Math.ceil(nrPergunta / 5) + 2) * (   Math.ceil(nrPergunta / 5) - 1       );
			valorErrar	 = Math.pow(10, Math.ceil(nrPergunta / 5) + 2) * ( ( Math.ceil(nrPergunta / 5) - 1 ) / 2 );
			Som.tocar("Question/" + (int)valorAcertar + ".wav");
			
			System.out.println(p + " (5) PULAR |");
			
			System.out.println("ACERTAR: " + valorAcertar + " PARAR: " + valorParar + " ERRAR: " + valorErrar);
			
			
			alternativa = t.leInt("\nDigite o número correspondente à alternativa desejada.");
			
			if ( alternativa == 5 )
			{
				System.out.println("Você pulou.\n");
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
	}
}
