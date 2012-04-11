package pckCommon;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessaPerguntas
{
	public static void main(String args[])
	{
		ProcessaPerguntas p = new ProcessaPerguntas();
		ArrayList<Pergunta> a = p.ProcessaCSV(new File("Resources/Perguntas.csv"));
		
		for(int i = 0; i < a.size(); i++)
			System.out.println(a.get(i).getId() + " | " + a.get(i).getNivel() + " | " +
								a.get(i).getDescricao() + " \n " + 
								a.get(i).getOpcoes()[0] + " | " + 
								a.get(i).getOpcoes()[1] + " | " + 
								a.get(i).getOpcoes()[2] + " | " + 
								a.get(i).getOpcoes()[3] + " | ");
	}
	
	public ArrayList<Pergunta> ProcessaCSV(File arquivo)
	{
		String[] dados = null;
		OpcaoPergunta[] opcoes = null;
		
		try
		{
			BufferedReader in = new BufferedReader( new FileReader(arquivo) );
			ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();

			int i = 0;			
			String linha = null;
			while((linha = in.readLine()) != null)
			{
				dados = linha.split(";");			
				
				opcoes = new OpcaoPergunta[4];
				opcoes[0] = new OpcaoPergunta(0, dados[1], false);
				opcoes[1] = new OpcaoPergunta(1, dados[2], false);
				opcoes[2] = new OpcaoPergunta(2, dados[3], false);
				opcoes[3] = new OpcaoPergunta(3, dados[4], false);		

				perguntas.add(new Pergunta(i, dados[0], opcoes, Integer.valueOf(dados[5]), NivelPergunta.DIFICIL));								
				
				i++;
			}
			in.close();
		
			return perguntas;
		}
		 
		catch ( NumberFormatException e)
		{
			System.out.println("Erro na conversão de " + dados[5] + " para um valor numérico. \nHá erros na formatação do arquivo de perguntas.");
			e.printStackTrace();
			return null;
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
