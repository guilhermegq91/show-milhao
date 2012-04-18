package pckCommon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CadastroPerguntas
{
	public static final int PERGUNTA	= 0;
	public static final int OPCAO1		= 1;
	public static final int OPCAO2		= 2;
	public static final int OPCAO3		= 3;
	public static final int OPCAO4		= 4;
	public static final int RESPOSTA	= 5;
	public static final int DIFICULDADE	= 6;	
	
	private ArrayList<Pergunta> perguntaFacil;
	private ArrayList<Pergunta> perguntaMedio;
	private ArrayList<Pergunta> perguntaDificil;
	
	public static void main(String args[])
	{
		ArrayList<Pergunta> perguntaFacil	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaMedio	= new ArrayList<Pergunta>();
		ArrayList<Pergunta> perguntaDificil	= new ArrayList<Pergunta>();
		
		CadastroPerguntas p = new CadastroPerguntas(perguntaFacil, perguntaMedio, perguntaDificil);

		p.ImportaCSV( new File("Resources/Perguntas.csv") );
		
		p.imprimeLista( p.getPerguntaFacil() );
		p.imprimeLista( p.getPerguntaMedio() );
		p.imprimeLista( p.getPerguntaDificil() );
	}
	
	public CadastroPerguntas(ArrayList<Pergunta> perguntaFacil, ArrayList<Pergunta> perguntaMedio, ArrayList<Pergunta> perguntaDificil)
	{
		this.perguntaFacil	 = perguntaFacil;
		this.perguntaMedio	 = perguntaMedio;
		this.perguntaDificil = perguntaDificil;
	}
	
	private int getNumRandom(int maximo)
	{
		return (1 + (int)(Math.random() * maximo)); 
	}
	
	private Pergunta getPergunta(ArrayList<Pergunta> listaPerguntas, int numero)
	{
		return listaPerguntas.get(numero);
	}
	
	public Pergunta SorteiaPergunta(NivelPergunta nivel)
	{
		ArrayList<Pergunta> listaPergSolicitada;
	
		switch(nivel)
		{
			case FACIL   : listaPergSolicitada = perguntaFacil;  
			               break;
			
			case MEDIO   : listaPergSolicitada = perguntaMedio;
			               break;
			
			case DIFICIL : listaPergSolicitada = perguntaDificil;
			               break;
			
			default      : return null;
		}		
		
		int numRand = getNumRandom(listaPergSolicitada.size());
		Pergunta perguntaSorteada = getPergunta(listaPergSolicitada, numRand);
		listaPergSolicitada.remove(numRand);
		
		return perguntaSorteada;		
	}
	
	public void ImportaCSV(File arquivo)
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
					getPerguntaFacil().add(new Pergunta("", i, dados[PERGUNTA], opcoes, NivelPergunta.FACIL));
				else if ( dados[DIFICULDADE].toCharArray()[0] == 'M')
					getPerguntaMedio().add(new Pergunta("", i, dados[PERGUNTA], opcoes, NivelPergunta.MEDIO));
				else if ( dados[DIFICULDADE].toCharArray()[0] == 'D')
					getPerguntaDificil().add(new Pergunta("", i, dados[PERGUNTA], opcoes, NivelPergunta.DIFICIL));							
				
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
	
	public ArrayList<Pergunta> getPerguntaFacil()
	{
		return perguntaFacil;
	}

	public void setPerguntaFacil(ArrayList<Pergunta> perguntaFacil)
	{
		this.perguntaFacil = perguntaFacil;
	}

	public ArrayList<Pergunta> getPerguntaMedio()
	{
		return perguntaMedio;
	}

	public void setPerguntaMedio(ArrayList<Pergunta> perguntaMedio)
	{
		this.perguntaMedio = perguntaMedio;
	}

	public ArrayList<Pergunta> getPerguntaDificil()
	{
		return perguntaDificil;
	}

	public void setPerguntaDificil(ArrayList<Pergunta> perguntaDificil)
	{
		this.perguntaDificil = perguntaDificil;
	}

	public void imprimeLista(ArrayList<Pergunta> lista)
	{
		for(int i = 0; i < lista.size(); i++)
			System.out.println("\nPergunta: "  + lista.get(i).getId()	+ " | " +
							   "Dificuldade: " + lista.get(i).getNivel() + " \n" +
							   "---------------------------------------------------------\n" +
							   lista.get(i).getDescricao()	+ " \n" + 
							   "(1) " + lista.get(i).getOpcoes()[0]	+ " | " + 
							   "(2) " + lista.get(i).getOpcoes()[1]	+ " | " + 
							   "(3) " + lista.get(i).getOpcoes()[2]	+ " | " + 
							   "(4) " + lista.get(i).getOpcoes()[3]	+ " | ");		
	}
	
}
