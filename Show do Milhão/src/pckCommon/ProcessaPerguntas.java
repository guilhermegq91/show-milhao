package pckCommon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessaPerguntas
{
	public static final int PERGUNTA	= 0;
	public static final int OPCAO1		= 1;
	public static final int OPCAO2		= 2;
	public static final int OPCAO3		= 3;
	public static final int OPCAO4		= 4;
	public static final int RESPOSTA	= 5;
	public static final int DIFICULDADE	= 6;
	
	public static void main(String args[])
	{
		ProcessaPerguntas p = new ProcessaPerguntas();
		ArrayList<Pergunta> perguntaFacil	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaMedio	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaDificil	= new ArrayList<Pergunta>();
		
		p.ProcessaCSV(new File("Resources/Perguntas.csv"), perguntaFacil, perguntaMedio, perguntaDificil);
		
		for(int i = 0; i < perguntaFacil.size(); i++)
			System.out.println(perguntaFacil.get(i).getId() + " | " + 
					perguntaFacil.get(i).getNivel() 	+ " | " +
					perguntaFacil.get(i).getDescricao() + " \n " + 
					perguntaFacil.get(i).getOpcoes()[0] + " | " + 
					perguntaFacil.get(i).getOpcoes()[1] + " | " + 
					perguntaFacil.get(i).getOpcoes()[2] + " | " + 
					perguntaFacil.get(i).getOpcoes()[3] + " | ");
		
		System.out.println("\n");
		
		for(int i = 0; i < perguntaMedio.size(); i++)
			System.out.println(perguntaMedio.get(i).getId() + " | " + 
					perguntaMedio.get(i).getNivel() 	+ " | " +
					perguntaMedio.get(i).getDescricao() + " \n " + 
					perguntaMedio.get(i).getOpcoes()[0] + " | " + 
					perguntaMedio.get(i).getOpcoes()[1] + " | " + 
					perguntaMedio.get(i).getOpcoes()[2] + " | " + 
					perguntaMedio.get(i).getOpcoes()[3] + " | ");
		
		System.out.println("\n");
		
		for(int i = 0; i < perguntaDificil.size(); i++)
			System.out.println(perguntaDificil.get(i).getId() + " | " + 
					perguntaDificil.get(i).getNivel() 	+ " | " +
					perguntaDificil.get(i).getDescricao() + " \n " + 
					perguntaDificil.get(i).getOpcoes()[0] + " | " + 
					perguntaDificil.get(i).getOpcoes()[1] + " | " + 
					perguntaDificil.get(i).getOpcoes()[2] + " | " + 
					perguntaDificil.get(i).getOpcoes()[3] + " | ");
	}
	
	public void ProcessaCSV(File arquivo, ArrayList<Pergunta> perguntaFacil, ArrayList<Pergunta> perguntaMedio, ArrayList<Pergunta> perguntaDificil)
	{
		String[] dados = null;
		OpcaoPergunta[] opcoes = null;
		
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(arquivo));
			
			int i = 0;			
			String linha = null;
			while((linha = in.readLine()) != null)
			{
				dados = linha.split(";");			
				
				opcoes = new OpcaoPergunta[4];
				opcoes[0] = new OpcaoPergunta(0, dados[OPCAO1], 0 == Integer.valueOf(dados[RESPOSTA]) );
				opcoes[1] = new OpcaoPergunta(1, dados[OPCAO2], 1 == Integer.valueOf(dados[RESPOSTA]) );
				opcoes[2] = new OpcaoPergunta(2, dados[OPCAO3], 2 == Integer.valueOf(dados[RESPOSTA]) );
				opcoes[3] = new OpcaoPergunta(3, dados[OPCAO4], 3 == Integer.valueOf(dados[RESPOSTA]) );		

				if ( dados[DIFICULDADE].toCharArray()[0] == 'F')
					perguntaFacil.add(new Pergunta(i, dados[PERGUNTA], opcoes, NivelPergunta.FACIL));
				else if ( dados[DIFICULDADE].toCharArray()[0] == 'M')
					perguntaMedio.add(new Pergunta(i, dados[PERGUNTA], opcoes, NivelPergunta.MEDIO));
				else if ( dados[DIFICULDADE].toCharArray()[0] == 'D')
					perguntaDificil.add(new Pergunta(i, dados[PERGUNTA], opcoes, NivelPergunta.DIFICIL));							
				
				i++;
			}
			in.close();
		}
		 
		catch ( NumberFormatException e)
		{
			System.out.println("Erro na conversão de " + dados[5] + " para um valor numérico. \nHá erros na formatação do arquivo de perguntas.");
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
