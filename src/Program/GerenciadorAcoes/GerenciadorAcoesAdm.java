package Program.GerenciadorAcoes;

import java.util.ArrayList;
import Program.Main.main;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.UserInterface.UserInterface;

public class GerenciadorAcoesAdm {
	
	private static final String PEDENOME = "o NOME da midia a ser adicionada:";
	private static final String PEDEGENERO = "o(s) GENERO(s) da midia a ser adicionada:";
	private static final String PEDEDURACAO = "a DURACAO da midia a ser adicionada:";
	private static final String PEDEPRODUTORA = "a PRODUTORA da midia a ser adicionada:";
	private static final String PEDEDIRETOR = "o nome do DIRETOR da midia a ser adicionada:";
	private static final String PEDEANO = "o ANO da midia a ser adicionada:";
	private static final String PEDENROEPS = "o NUMERO DE EPISODIOS da midia a ser adicionada:";
		
	private static UserInterface userInterface;
	
	public GerenciadorAcoesAdm() {
		userInterface = new UserInterface();
	}
	
	public void adicionarMidiaFilme() {
		String nome = null;
		Boolean erro = true;  // flag erro
		while(erro)
		{
			nome = main.userInterface.pedeString(PEDENOME);
			if(nome.equals(""))
			{
				return;
			}
			if(!main.catalogo.getFilmes().containsKey(nome))
			{
				erro = false;
			}
			else
			{
				main.userInterface.printaErroNomeJaExistente("Filme"); 
			}
		}
		//ArrayList<String> genero = userInterface.pedeArrayString(PEDEGENERO); 
		int duracao = userInterface.pedeInt(PEDEDURACAO); 
		String produtora = userInterface.pedeString(PEDEPRODUTORA);
		String diretor = userInterface.pedeString(PEDEDIRETOR);
		int ano = userInterface.pedeInt(PEDEANO);	
		ArrayList<Integer> nroEpisodios = new ArrayList<>(); 
		nroEpisodios.add(Filme.EPS_FILMES);
		
		//Midia filme = new Midia(nome, genero, duracao, produtora, diretor, ano, nroEpisodios);
		
		//main.catalogo.adicionaFilme(filme);
	}
	
	public void adicionarMidiaSerie() {	
		String nome = null;
		Boolean erro = true;  // flag erro
		while(erro)
		{
			nome = main.userInterface.pedeString(PEDENOME);
			if(nome.equals(""))
			{
				return;
			}
			if(!main.catalogo.getSeries().containsKey(nome))
			{
				erro = false;
			}
			else
			{
				main.userInterface.printaErroNomeJaExistente("Serie"); 
			}
		}
		//ArrayList<String> genero = userInterface.pedeArrayString(PEDEGENERO); 
		int duracao = userInterface.pedeInt(PEDEDURACAO); 
		String produtora = userInterface.pedeString(PEDEPRODUTORA);
		String diretor = userInterface.pedeString(PEDEDIRETOR);
		int ano = userInterface.pedeInt(PEDEANO);	
		ArrayList<Integer> nroEpisodios = userInterface.pedeArrayInt(PEDENROEPS);
		
		//Midia serie = new Midia(nome, genero, duracao, produtora, diretor, ano, nroEpisodios);
		
		//main.catalogo.adicionaSerie(serie);
	}
	
	public void removerMidiaFilme(String nome) {
		main.catalogo.removeFilme(nome);
	}
	
	public void removerMidiaSerie(String nome) {
		main.catalogo.removeSerie(nome);
	}
}













