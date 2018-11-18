package Program.GerenciadorAcoes;

import java.util.ArrayList;

import Program.Main.main;
import Program.Midias.Filme;
import Program.Midias.Midia;

public class GerenciadorAcoesAdm {
	
	private static final String PEDENOME = "o NOME da midia a ser adicionada:";
	private static final String PEDEGENERO = "o(s) GENERO(s) da midia a ser adicionada:";
	private static final String PEDEDURACAO = "a DURACAO da midia a ser adicionada:";
	private static final String PEDEPRODUTORA = "a PRODUTORA da midia a ser adicionada:";
	private static final String PEDEDIRETOR = "o nome do DIRETOR da midia a ser adicionada:";
	private static final String PEDEANO = "o ANO da midia a ser adicionada:";
	private static final String PEDENROEPS = "o NUMERO DE EPISODIOS da midia a ser adicionada:";
	
	public GerenciadorAcoesAdm() {
	}
	
	public String pedeNomeMidiaFilmeAdicionar() {
		String nome = null;
		Boolean erro = true;  // flag erro - Nome ja existente
		while(erro)	{
			nome = main.userInterface.pedeString(PEDENOME);
			if(nome.equals(""))	{
				return null;
			}
			if(!main.catalogo.getFilmes().containsKey(nome)) {
				erro = false;
			}
			else {
				main.userInterface.printaErroNomeJaExistente("Filme"); 
			}
		}
		return nome;
	}
	
	public String pedeNomeMidiaSerieAdicionar() {
		String nome = null;
		Boolean erro = true;  // flag erro - Nome ja existente
		while(erro) {
			nome = main.userInterface.pedeString(PEDENOME);
			if(nome.equals("")) {
				return null;
			}
			if(!main.catalogo.getSeries().containsKey(nome)) {
				erro = false;
			}
			else {
				main.userInterface.printaErroNomeJaExistente("Serie"); 
			}
		}
		return nome;
	}
		
	public void adicionarMidiaFilme() {
		String nome = this.pedeNomeMidiaFilmeAdicionar();
		if(nome.equals(null)) {
			return;
		}
		ArrayList<String> genero = main.userInterface.pedeArrayString(PEDEGENERO); 
		int duracao = main.userInterface.pedeInt(PEDEDURACAO); 
		String produtora = main.userInterface.pedeString(PEDEPRODUTORA);
		String diretor = main.userInterface.pedeString(PEDEDIRETOR);
		int ano = main.userInterface.pedeInt(PEDEANO);	
		ArrayList<Integer> nroEpisodios = new ArrayList<>(); 
		nroEpisodios.add(Filme.EPS_FILMES);
		
		Midia filme = new Midia(nome, genero, duracao, produtora, diretor, ano, nroEpisodios);
		
		main.catalogo.adicionaFilme(filme);
	}
	
	public void adicionarMidiaSerie() {	
		String nome = this.pedeNomeMidiaSerieAdicionar();
		if(nome.equals(null)) {	
			return;
		}
		ArrayList<String> genero = main.userInterface.pedeArrayString(PEDEGENERO); 
		int duracao = main.userInterface.pedeInt(PEDEDURACAO); 
		String produtora = main.userInterface.pedeString(PEDEPRODUTORA);
		String diretor = main.userInterface.pedeString(PEDEDIRETOR);
		int ano = main.userInterface.pedeInt(PEDEANO);	
		ArrayList<Integer> nroEpisodios = main.userInterface.pedeArrayInt(PEDENROEPS);
		
		Midia serie = new Midia(nome, genero, duracao, produtora, diretor, ano, nroEpisodios);
		
		main.catalogo.adicionaSerie(serie);
	}
}













