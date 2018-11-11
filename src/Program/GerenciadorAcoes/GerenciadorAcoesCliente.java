package Program.GerenciadorAcoes;

import java.util.ArrayList;

import Program.Controle_Midias.Colecao;
import Program.Filtros.FiltroGeral;
import Program.Main.main;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Registro;
import Program.Midias.Serie;
import Program.UserInterface.UserInterface;

public class GerenciadorAcoesCliente {
	
	private static final String PEDENOTA = "a nota que deseja dar a ";
	private static final String PEDENROEPS = "o numero de novos episodios que assistiu";
	private static final String PEDENOME_COLECAO = "o nome que deseja dar a sua colecao:";
	private static final String PEDENOME_FILME = "o nome do filme que esta procurando:";
	private static final String PEDENOME_SERIE = "o nome da serie que esta procurando:";
		
	public GerenciadorAcoesCliente() {
	}
	
	public Filme criaFilme(Midia midia) {
		return new Filme(midia.getNome(), midia.getGenero(), midia.getDuracao(), midia.getProdutora(), midia.getDiretor(), midia.getAno(), midia.getNroEpisodios());
	}
	
	public Serie criaSerie(Midia midia) {
		return new Serie(midia.getNome(), midia.getGenero(), midia.getDuracao(), midia.getProdutora(), midia.getDiretor(), midia.getAno(), midia.getNroEpisodios());
	}
	
	public void atribuiNota(Registro registro) {
		int nota = main.userInterface.pedeInt(PEDENOTA + registro.getNome() + ":");
		registro.setNota(nota);
	}
	
	public void atualizaStatus(Registro registro) {
		ArrayList<String> possiveisStatus = registro.retornaPossiveisStatus();
		int indice = main.userInterface.selecionaOpcao(possiveisStatus);
		registro.setStatus(possiveisStatus.get(indice));			
	}
	
	public void atualizaNroEpisodiosAssistidos(Serie serie) {
		int novos_eps = main.userInterface.pedeInt(PEDENROEPS);
		int quantidadeAssistida = serie.getNroEpisodiosAssistidos() + novos_eps;
		serie.setNroEpisodiosAssistidos(quantidadeAssistida);
	}
	
	public String pedeNomeColecaoAdicionar() {
		String nome = null;
		Boolean erro = true;  // flag erro - Nome ja existente
		while(erro) {
			nome = main.userInterface.pedeString(PEDENOME_COLECAO);
			if(nome.equals("")) {
				return null;
			}
			if(!main.repositorio.getColecoes().containsKey(nome)) {
				erro = false;
			}
			else {
				main.userInterface.printaErroNomeJaExistente("Colecao"); 
			}
		}
		return nome;
	}
	
	public String pedeNomeFilmeAdicionar() {
		String nome = null;
		Boolean erro = true;  // flag erro - Nome nao existente no catálogo
		
		while(erro) {
			nome = main.userInterface.pedeString(PEDENOME_FILME);
			if(nome.equals("")) {
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
	
	public void criaColecao() {
		String nome = this.pedeNomeColecaoAdicionar();
		if(nome.equals(null)) {
			return;
		}
		Colecao novaColecao = new Colecao(nome);
		main.repositorio.adicionaColecao(novaColecao);
	}
	
	public void renomearColecao(Colecao colecao) {
		String nome = this.pedeNomeColecaoAdicionar();
		if(nome.equals(null)) {
			return;
		}
		colecao.setNome(nome);
	}
	
	public void adicionaFilme() {
		FiltroGeral filtroGeral = new FiltroGeral();
		boolean nomeNaoEncontrado = true;
		String nome = null;
		ArrayList<Midia> opcoes = null;
		
		while(nomeNaoEncontrado) {
			nome = main.userInterface.pedeString(PEDENOME_FILME);
			if(nome.equals("")) {
				return;
			}
			opcoes = filtroGeral.buscaMidiaPorNome(nome, main.catalogo.getFilmes());
			if(opcoes.isEmpty()) {
				main.userInterface.printaErroNomeNaoEncontrado();
			}
			else {
				nomeNaoEncontrado = false;
			}
		}			
		int i = main.userInterface.selecionaOpcao(opcoes);
		main.repositorio.adicionaFilme(this.criaFilme(opcoes.get(i)));
	}
	
	public void adicionaSerie() {
		FiltroGeral filtroGeral = new FiltroGeral();
		boolean nomeNaoEncontrado = true;
		String nome = null;
		ArrayList<Midia> opcoes = null;
		
		while(nomeNaoEncontrado) {
			nome = main.userInterface.pedeString(PEDENOME_SERIE);
			if(nome.equals("")) {
				return;
			}
			opcoes = filtroGeral.buscaMidiaPorNome(nome, main.catalogo.getSeries());
			if(opcoes.isEmpty()) {
				main.userInterface.printaErroNomeNaoEncontrado();
			}
			else {
				nomeNaoEncontrado = false;
			}
		}			
		int i = main.userInterface.selecionaOpcao(opcoes);
		main.repositorio.adicionaSerie(this.criaSerie(opcoes.get(i)));
	}
}
