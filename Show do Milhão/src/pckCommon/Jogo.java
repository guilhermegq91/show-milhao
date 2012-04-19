package pckCommon;

import java.io.File;
import java.util.ArrayList;

public class Jogo
{
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
		
		int nrPergunta = 1;
		while(true)
		{
			if (nrPergunta <= 5)
			{
				if (nrPergunta == 1)
					Som.tocar("Rodada1.wav");
				
				p = perguntas.SorteiaPergunta(NivelPergunta.FACIL);
			}
			
			else if (nrPergunta <= 10)
			{
				if (nrPergunta == 6)
					Som.tocar("Rodada2.wav");
				
				p = perguntas.SorteiaPergunta(NivelPergunta.MEDIO);	
			}
							
			
			else if (nrPergunta <= 15)
			{
				if (nrPergunta == 11)
					Som.tocar("Rodada3.wav");
				
				p = perguntas.SorteiaPergunta(NivelPergunta.DIFICIL);
			}

			else if (nrPergunta == 16 )
				p = perguntas.SorteiaPergunta(NivelPergunta.DIFICIL);

			else
				j.venceu();
			
			valorAcertar = Math.pow(10, (int)(nrPergunta / 5) + 3) * (   nrPergunta           );
			valorParar	 = Math.pow(10, (int)(nrPergunta / 5) + 3) * (   nrPergunta - 1       );
			valorErrar	 = Math.pow(10, (int)(nrPergunta / 5) + 3) * ( ( nrPergunta - 1 ) / 2 );
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

}
