package pckCommon;

import java.io.File;
import java.util.ArrayList;

public class Jogo
{
	public static void main(String args[])
	{
		Teclado t = new Teclado();
		
		ArrayList<Pergunta> perguntaFacil	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaMedio	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaDificil	= new ArrayList<Pergunta>();
		
		CadastroPerguntas perguntas = new CadastroPerguntas(perguntaFacil, perguntaMedio, perguntaDificil);
		perguntas.ImportaCSV( new File("Resources/Perguntas.csv") );
		
		System.out.println("Bem vindo");
		
		
		Pergunta p;
		int alternativa;
		for(int i = 0; i < 10; i++)
		{
			p = perguntas.SorteiaPergunta(NivelPergunta.FACIL);
			System.out.println(p + " (5) PULAR |");
			
			alternativa = t.leInt("\nDigite o número correspondente à alternativa desejada.");
			if ( p.getOpcoes()[alternativa - 1].getVerdadeira() ) 
				System.out.println("Resposta correta.");
			else
				System.out.println("Resposta incorreta.");
		}
	}
}
