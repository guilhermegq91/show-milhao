package pckCommon;

import java.util.ArrayList;

public class CadastroPerguntas {
	
	private ArrayList<Pergunta> perguntaFacil;
	private ArrayList<Pergunta> perguntaMedio;
	private ArrayList<Pergunta> perguntaDificil;
	
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
	
		switch(nivel){
			case FACIL   : listaPergSolicitada = perguntaFacil;  
			               break;
			case MEDIO   : listaPergSolicitada = perguntaMedio;
			               break;
			case DIFICIL : listaPergSolicitada = perguntaDificil;
			               break;
			default : return null;
		}		
		int numRand = getNumRandom(listaPergSolicitada.size());
		Pergunta perguntaSorteada = getPergunta(listaPergSolicitada, numRand);
		listaPergSolicitada.remove(numRand);
		return perguntaSorteada;		
	}

}
