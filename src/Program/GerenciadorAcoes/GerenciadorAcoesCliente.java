package Program.GerenciadorAcoes;

import java.util.*;

import Program.Controle_Midias.Colecao;
import Program.Controle_Midias.Repositorio;
import Program.Filtros.FiltroGeral;
import Program.Filtros.FiltroRepositorio;
import Program.Main.main;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Registro;
import Program.Midias.Serie;
import Program.ProcessadorEstatistico.ProcessadorEstatistico;
import Program.Recomendador.Recomendador;

import  static Program.Midias.Registro.NOTAMAXIMA;

public class GerenciadorAcoesCliente {
	
	private static final String PEDENOTA = "a nota (0-10) que deseja dar a ";
	private static final String PEDENROEPS = "o numero de novos episodios que assistiu";
	private static final String PEDENOME_COLECAO = "o nome que deseja dar a sua colecao:";
	private static final String PEDENOME_FILME = "o nome do filme que esta procurando:";
	private static final String PEDENOME_SERIE = "o nome da serie que esta procurando:";
	private static final String PEDENOME_REGISTRO = "o nome do filme/serie que esta procurando:";
	private static final String PEDEMIDIAFAVORITA = "sua Midia favorita, entre as opcoes acima:";
	private static final String PEDEGENERO_PESQUISA = "o genero que esta procurando:";
	private static final int QUANTIDADERETORNO = 10;

	public GerenciadorAcoesCliente() {
	}
	
	public Filme criaFilme(Midia midia) {
		return new Filme(midia.getNome(), midia.getGenero(), midia.getDuracao(), midia.getProdutora(), midia.getDiretor(), midia.getAno(), midia.getNroEpisodios());
	}
	
	public Serie criaSerie(Midia midia) {
		return new Serie(midia.getNome(), midia.getGenero(), midia.getDuracao(), midia.getProdutora(), midia.getDiretor(), midia.getAno(), midia.getNroEpisodios());
	}
	
	public void atribuiNota(Registro registro) {
		int nota = 0;
		do {
			nota = main.userInterface.pedeInt(PEDENOTA + registro.getNome() + ":");
		} while(nota < 0 || nota > NOTAMAXIMA);
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
		Boolean erro = true;  // flag erro - Nome nao existente no catalogo
		
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
		boolean nomeNaoEncontrado = true; // Se nome (ou parte) existe no catalogo
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

	public Registro batalha(ArrayList<Registro> registrosBatalha){
		Collections.shuffle(registrosBatalha);
		ArrayList<String> nomesBatalha;
		Registro registroVencedor = null;

		while(registrosBatalha.size() != 1) {
			nomesBatalha = this.selecionaParNomesBatalha(registrosBatalha.subList(0,2));
			int escolhaFavorita = main.userInterface.selecionaOpcao(nomesBatalha, PEDEMIDIAFAVORITA);

			if(escolhaFavorita == 0){
				registrosBatalha.remove(1);
			} else {
				registrosBatalha.remove(0);
			}
			registroVencedor = registrosBatalha.get(0);
		}

		return registroVencedor;

	}

	private ArrayList<String> selecionaParNomesBatalha(List<Registro> registros){
		ArrayList<String> nomesBatalha = new ArrayList<>();

		nomesBatalha.add(registros.get(0).getNome());
		nomesBatalha.add(registros.get(1).getNome());

		return nomesBatalha;
	}
	
	public void adicionarRegistroColecao(Colecao colecao) {
		FiltroGeral filtroGeral = new FiltroGeral();
		boolean nomeNaoEncontrado = true;
		String nome = null;
		ArrayList<Midia> opcoes = null;
		
		while(nomeNaoEncontrado) {
			nome = main.userInterface.pedeString(PEDENOME_REGISTRO);
			if(nome.equals("")) {
				return;
			}
			opcoes = filtroGeral.buscaMidiaPorNome(nome, main.repositorio.getFilmes());
			opcoes.addAll(filtroGeral.buscaMidiaPorNome(nome, main.repositorio.getSeries()));
			if(opcoes.isEmpty()) {
				main.userInterface.printaErroNomeNaoEncontrado();
			}
			else {
				nomeNaoEncontrado = false;
			}
		}			
		int i = main.userInterface.selecionaOpcao(opcoes);
		Midia registro = opcoes.get(i);
		
		if(registro instanceof Filme) {
			colecao.adicionaRegistro((Filme)registro);
		}
		else {
			colecao.adicionaRegistro((Serie)registro);
		}
	}

	public ArrayList<Midia> sugestContinuar(Repositorio repositorio){
        Hashtable<String,Midia> seriesUsuario = repositorio.getSeries();
        ArrayList<Midia> sugestoes = new ArrayList<>();
        ArrayList<Integer> indiceSugestoes = new ArrayList<>();
        ArrayList<Registro> midiasAssistindo = new FiltroRepositorio().filtraPorStatus(Serie.ASSISTINDO, this.valuesHashtable(seriesUsuario));

        for (Registro registro : midiasAssistindo){
            int quantidadeEpRestantes = new ProcessadorEstatistico().calculaEpisodiosRestantes((Serie) registro);
            if(quantidadeEpRestantes>0){
                int posicao = this.posicaoAdicaoArray(indiceSugestoes, quantidadeEpRestantes);
                indiceSugestoes.add(posicao, quantidadeEpRestantes);
                sugestoes.add(posicao, registro);
            }
        }
        sugestoes = new FiltroGeral().filtraPorRanking(QUANTIDADERETORNO, sugestoes);
        return sugestoes;
    }

    private int posicaoAdicaoArray(ArrayList<Integer> indices, int epRestantes){
        int indexRetorno = 0;

        for(Integer valor : indices){
            if(valor <= epRestantes){
                indexRetorno = indices.indexOf(valor);
            }
        }
        return indexRetorno;
    }

    private ArrayList<Registro> valuesHashtable(Hashtable<String, Midia> midias){
        ArrayList<Registro> midiasLista = new ArrayList<>();
        Set<String> keyMidias = midias.keySet();
        for (String key : keyMidias){
            midiasLista.add((Registro) midias.get(key));
        }
        return midiasLista;
    }
    
    private ArrayList<Midia> getArrayMidias(Repositorio repositorio) {
    	ArrayList<Midia> midias = new ArrayList<Midia>(main.repositorio.getFilmes().values());
    	midias.addAll(new ArrayList<Midia>(main.repositorio.getSeries().values()));
    	
    	return midias;
    }
    
    private ArrayList<Registro> arrayMidiaToRegistro(ArrayList<Midia> midias) {
    	ArrayList<Registro> registros = new ArrayList<>();
    	for(Midia midia : midias) {
    		Registro registro = (Registro)midia; 
    		registros.add(registro);
    	}
    	return registros;
    }

    public int horasGastasAssistindo(Repositorio repositorio){
		ProcessadorEstatistico procesEstatistico = new ProcessadorEstatistico();
		int horasTotaisAssistidas = procesEstatistico.calculaHorasAssistidasSeries(repositorio.getSeries());
		horasTotaisAssistidas += procesEstatistico.calculaHorasAssistidasFilmes(repositorio.getFilmes());

		return horasTotaisAssistidas;
	}
    
    public ArrayList<Midia> pesquisaPorNome() {
    	FiltroGeral filtroGeral = new FiltroGeral();
    	String nome = main.userInterface.pedeString(PEDENOME_REGISTRO);
    	
    	Hashtable<String, Midia> registros = main.repositorio.getFilmes();
    	registros.putAll(main.repositorio.getSeries());
    	ArrayList<Midia> opcoes = filtroGeral.buscaMidiaPorNome(nome, registros);
    	
    	return opcoes;
    }
    
    public ArrayList<Midia> pesquisaPorGenero() {
    	FiltroGeral filtroGeral = new FiltroGeral();
    	String genero = main.userInterface.pedeString(PEDEGENERO_PESQUISA);
    	
    	ArrayList<Midia> registros = this.getArrayMidias(main.repositorio);
    	ArrayList<Midia> opcoes = filtroGeral.filtraPorGenero(genero, registros);
    	
    	return opcoes;
    }
    
    public ArrayList<Registro> pesquisaPorNota() {
    	FiltroRepositorio filtroRepositorio = new FiltroRepositorio();
    	double nota = main.userInterface.pedeNota();
    	
    	ArrayList<Registro> registros = this.arrayMidiaToRegistro(this.getArrayMidias(main.repositorio));
    	ArrayList<Registro> opcoes = filtroRepositorio.filtraPorNotaIgual(nota, registros);
    	
    	return opcoes;
    }
    
    public ArrayList<Registro> pesquisaPorStatus() {
    	FiltroRepositorio filtroRepositorio = new FiltroRepositorio();
    	String status = main.userInterface.pedeStatus();
    	
    	ArrayList<Registro> registros = this.arrayMidiaToRegistro(this.getArrayMidias(main.repositorio));
    	ArrayList<Registro> opcoes = filtroRepositorio.filtraPorStatus(status, registros);
    	
    	return opcoes;
    }
    
    public void verRecomendacoes() {
    	Recomendador r = new Recomendador();
    	ArrayList<Midia> midias = getArrayMidias(main.repositorio);
		ArrayList<Registro> historico = this.arrayMidiaToRegistro(midias);
		ArrayList<Midia> midiasRetornoRecomendacao = r.recomendarParaUsuario(historico, main.catalogo);
		main.userInterface.printaArrayMidias(midiasRetornoRecomendacao);
    }
    
    public void verHistorico() {
    	ProcessadorEstatistico procEst = new ProcessadorEstatistico();
    	Recomendador recomendador = new Recomendador();
    	//Ver tempo total assistido, quantidade de filmes e series assistidos, quantidade de filmes e series assistidos
    	//de acordo com genero, etc.
    	String tempoSeries, tempoFilmes;
    	int epsAssistidos, filmesAssistidos, horasAssistidas;
    	ArrayList<String> generos;
    	
    	tempoSeries =  procEst.minutosParaDiasHorasMin(procEst.calculaHorasAssistidasSeries(main.repositorio.getSeries()));
    	tempoFilmes = procEst.minutosParaDiasHorasMin(procEst.calculaHorasAssistidasFilmes(main.repositorio.getFilmes()));
    	horasAssistidas = this.horasGastasAssistindo(main.repositorio);
    	epsAssistidos = procEst.calculaTotalEpisodiosAssistidos(main.repositorio.getSeries());
    	filmesAssistidos = procEst.calculaQtdeFilmesAssistidos(main.repositorio.getFilmes());
    	
    	ArrayList<Midia> midias = getArrayMidias(main.repositorio);
		ArrayList<Registro> historico = this.arrayMidiaToRegistro(midias);
    	generos = recomendador.analisaGenero(historico);
    	
    	main.userInterface.imprimeHistorico(tempoSeries, tempoFilmes, horasAssistidas, epsAssistidos, filmesAssistidos, generos);
    }
    
}
