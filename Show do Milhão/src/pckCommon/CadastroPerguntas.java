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
		CadastroPerguntas p = new CadastroPerguntas("Resources/Perguntas.csv");		
		p.imprimeLista( p.getPerguntaFacil() );
		p.imprimeLista( p.getPerguntaMedio() );
		p.imprimeLista( p.getPerguntaDificil() );
	}
	
	public CadastroPerguntas(String arquivoCSV)
	{
		perguntaFacil	= new ArrayList<Pergunta>();
		perguntaMedio	= new ArrayList<Pergunta>();
		perguntaDificil	= new ArrayList<Pergunta>();

		this.ImportaCSV(new File(arquivoCSV));
	}
	
	//usado apenas dentro da classe para sortear um numero randomico
	private int getNumRandom(int maximo)
	{
		return (1 + (int)(Math.random() * maximo)); 
	}
	
	//usado apenas dentro desta classe para obter a pergunta de acordo com o index sorteado
	private Pergunta getPergunta(ArrayList<Pergunta> listaPerguntas, int numero)
	{
		return listaPerguntas.get(numero);
	}
	
	//retorna a pergunta sorteada
	public Pergunta sorteiaPergunta(NivelPergunta nivel)
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
		
		int numRand = getNumRandom(listaPergSolicitada.size() - 1);
		Pergunta perguntaSorteada = getPergunta(listaPergSolicitada, numRand);
		listaPergSolicitada.remove(numRand);
		
		return perguntaSorteada;		
	}
	
	private Pergunta getPerguntaById(int id)
	{
		for(int i=0;i<perguntaFacil.size();i++)
		{
			if(perguntaFacil.get(i).getId() == id)
				return perguntaFacil.get(i);
		}
		for(int i=0;i<perguntaMedio.size();i++)
		{
			if(perguntaMedio.get(i).getId() == id)
				return perguntaMedio.get(i);
		}		
		for(int i=0;i<perguntaDificil.size();i++)
		{
			if(perguntaDificil.get(i).getId() == id)
				return perguntaDificil.get(i);
		}		
		return null; //	só chega até aqui se não localizar a pergunta nas listas
	}
	
	private OpcaoPergunta getOpcaoPerguntaById(Pergunta pergunta, int idOpcao)
	{
		if(pergunta != null)
		{
			for(int i=0;i<pergunta.getOpcoes().length;i++){
				if(pergunta.getOpcoes()[i].getId() == idOpcao)
					return pergunta.getOpcoes()[i];
			}
		}
		return null; //só chega aqui se não localizar opção
	}
	
	public boolean verifResposta(int idPergunta, int idOpcao)
	{
		OpcaoPergunta opcao = getOpcaoPerguntaById(getPerguntaById(idPergunta), idOpcao);
		if(opcao != null)
		{
			return opcao.getVerdadeira();
		}		
		return false;
	}
	
	private void ImportaCSV(File arquivo)
	{
		String[] dados = null;
		OpcaoPergunta[] opcoes = null;
		
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(arquivo));
			
			int i = 0;			
			String linha = null;
			//cada pergunta terá um ID unico, independente de qual lista ela esta			
			while((linha = in.readLine()) != null)
			{
				dados = linha.split(";");			
				
				opcoes = new OpcaoPergunta[4];
				opcoes[0] = new OpcaoPergunta(0, dados[OPCAO1], 1 == Integer.valueOf(dados[RESPOSTA]) );
				opcoes[1] = new OpcaoPergunta(1, dados[OPCAO2], 2 == Integer.valueOf(dados[RESPOSTA]) );
				opcoes[2] = new OpcaoPergunta(2, dados[OPCAO3], 3 == Integer.valueOf(dados[RESPOSTA]) );
				opcoes[3] = new OpcaoPergunta(3, dados[OPCAO4], 4 == Integer.valueOf(dados[RESPOSTA]) );		

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

	public ArrayList<Pergunta> getPerguntaMedio()
	{
		return perguntaMedio;
	}

	public ArrayList<Pergunta> getPerguntaDificil()
	{
		return perguntaDificil;
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
