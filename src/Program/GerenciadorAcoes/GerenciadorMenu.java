package Program.GerenciadorAcoes;

import java.util.ArrayList;
import Program.Main.main;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Registro;
import Program.Midias.Serie;
import Program.Controle_Midias.Colecao;

public class GerenciadorMenu {
	private static final String SENHA = "ggn24";
	private static GerenciadorAcoesCliente gerenciadorAcoesCliente = new GerenciadorAcoesCliente();

	public GerenciadorMenu() {
	}

	public void escolhaUsuario() {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("S")) {
			opcao = main.userInterface.menuEscolhaUsuario();
			switch(opcao) {
				case "1":
					menuPrincipalCliente();
					break;
				case "2":
					verificaSenhaAdministrador();
					break;
			}
		}
	}
	
	private void verificaSenhaAdministrador() {
		boolean acessoConcedido = main.userInterface.verificaSenhaAdministrador(SENHA);
		if(acessoConcedido) {
			menuPrincipalAdm();
		}
	}
	
	private void menuPrincipalAdm() {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("S")) {
			opcao = main.userInterface.menuPrincipalAdm();
			switch(opcao) {
				case "1":
					verCatalogo();
					break;
			}
		}	
	}
	
	private void verCatalogo() {
		GerenciadorAcoesAdm gerenciadorAcoesAdm = new GerenciadorAcoesAdm();
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			
			ArrayList<Midia> midiaFilmes = new ArrayList<Midia>(main.catalogo.getFilmes().values());
			ArrayList<Midia> midiaSeries = new ArrayList<Midia>(main.catalogo.getSeries().values());
			
			opcao = main.userInterface.menuVerCatalogo(midiaFilmes, midiaSeries);
			
			switch(opcao.toUpperCase()) {
			case "F":
				gerenciadorAcoesAdm.adicionarMidiaFilme();
				break;
			case "S":
				gerenciadorAcoesAdm.adicionarMidiaSerie();
				break;
			case "V":	// Seguranca para nao entrar no default
				break;
			default:		 // opcao eh um numero -> usuario deseja ver a midia 
				int indice = 0;
				try {
		        	indice = Integer.parseInt(opcao) - 1;
		        } catch (NumberFormatException e) {
		        	opcao = "V"; // Sair do metodo 
		        }
				if(indice < midiaFilmes.size()) { // Eh um filme
					verMidiaFilme(midiaFilmes.get(indice));
				}
				else {							 // Eh uma serie
					indice = indice - midiaFilmes.size();
					verMidiaSerie(midiaSeries.get(indice));
				}
			}
		}
	}
	
	private void verMidiaFilme(Midia midia) {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			opcao = main.userInterface.menuVerMidia(midia);
			switch(opcao.toUpperCase()) {
				case "D":
					if(main.userInterface.confirmaRemocao(midia.getNome()));{
						main.catalogo.removeFilme(midia.getNome());
					}
					break;
			}
		}
	}
	
	private void verMidiaSerie(Midia midia) {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			opcao = main.userInterface.menuVerMidia(midia);
			switch(opcao.toUpperCase()) {
				case "D":
					if(main.userInterface.confirmaRemocao(midia.getNome())) {
						main.catalogo.removeSerie(midia.getNome());
					}
					break;
			}
		}
	}
	
	private void menuPrincipalCliente() {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("S")) {
			opcao = main.userInterface.menuPrincipalCliente();
			
			switch(opcao) {
				case "1": 
					verRepositorio();
					break;
				case "2":
					verColecoes();
					break;
				case "3":
					main.userInterface.recomendacoesUsuarioAssistir();
					break;
				case "4":
					gerenciadorAcoesCliente.verHistorico();
					break;
				case "5":
					main.userInterface.batalha();
					break;
				case "6":
					main.userInterface.sugestContinuar();
					break;
			}
		}
	}
		
	private void verRepositorio() {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			
			ArrayList<Midia> filmes = new ArrayList<Midia>(main.repositorio.getFilmes().values());
			ArrayList<Midia> series = new ArrayList<Midia>(main.repositorio.getSeries().values());
			
			opcao = main.userInterface.menuVerRepositorio(filmes, series);
			
			switch(opcao.toUpperCase()) {
			case "F":
				gerenciadorAcoesCliente.adicionaFilme();
				break;
			case "S":
				gerenciadorAcoesCliente.adicionaSerie();
				break;
			case "P":
				selecionaFiltro();
				break;
			case "V":   // Seguranca para nao entrar no default
				break;
			default:		 // opcao eh um numero -> usuario deseja ver o registro
				int indice = 0;
				try {
		        	indice = Integer.parseInt(opcao) - 1;
		        } catch (NumberFormatException e) {
		        	opcao = "V"; // Sair do metodo 
		        }
				if(indice < filmes.size()) { // Eh um filme
					verFilme((Filme)filmes.get(indice));
				}
				else {					 // Eh uma serie
					indice = indice - filmes.size();
					verSerie((Serie)series.get(indice));
				}
			}
		}
	}	
	
	private void verFilme(Filme filme) {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			opcao = main.userInterface.menuVerFilme(filme);
			switch(opcao.toUpperCase()) {
				case "N":
					gerenciadorAcoesCliente.atribuiNota(filme);
					break;
				case "S":
					gerenciadorAcoesCliente.atualizaStatus(filme);
					break;
				case "D":
					if(main.userInterface.confirmaRemocao(filme.getNome())) {
						main.repositorio.removeFilme(filme.getNome());
					}
					break;
			}
		}
	}
	
	private void verSerie(Serie serie) {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			opcao = main.userInterface.menuVerSerie(serie);
			switch(opcao.toUpperCase()) {
				case "N":
					gerenciadorAcoesCliente.atribuiNota(serie);
					break;
				case "S":
					gerenciadorAcoesCliente.atualizaStatus(serie);
					break;
				case "E":
					gerenciadorAcoesCliente.atualizaNroEpisodiosAssistidos(serie);
					break;
				case "D":
					if(main.userInterface.confirmaRemocao(serie.getNome())) {
						main.repositorio.removeSerie(serie.getNome());
					}
					break;
			}
		}
	}
	
	private void verColecoes() {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			
			ArrayList<Colecao> colecoes = new ArrayList<Colecao>(main.repositorio.getColecoes().values());
						
			opcao = main.userInterface.menuVerColecoes(colecoes);
			
			switch(opcao.toUpperCase()) {
			case "A":
				gerenciadorAcoesCliente.criaColecao();
				break;
			case "V":	// Seguranca para nao entrar no default
				break;

			default:		 // opcao eh um numero -> usuario deseja ver a colecao 
				int indice = 0;
				try {
		        	indice = Integer.parseInt(opcao) - 1;
		        } catch (NumberFormatException e) {
		        	opcao = "V"; // Sair do metodo 
		        }
				verColecao(colecoes.get(indice));
			}
		}
	}
	
	private void verColecao(Colecao colecao) {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			ArrayList<Registro> registros = new ArrayList<Registro>(colecao.getRegistros().values());
			opcao = main.userInterface.menuVerColecao(colecao, registros);
			
			switch(opcao.toUpperCase()) {
				case "A":
					gerenciadorAcoesCliente.adicionarRegistroColecao(colecao);
					break;
				case "N":
					gerenciadorAcoesCliente.renomearColecao(colecao);
					break;
				case "R":
					if(main.userInterface.confirmaRemocao(colecao.getNome())) { 
						main.repositorio.removeColecao(colecao.getNome());
					}
					break;
				case "V":	// Seguranca para nao entrar no default
					break;
				default:		 // opcao eh um numero -> usuario deseja ver um registro
					int indice = 0;
					try {
			        	indice = Integer.parseInt(opcao) - 1;
			        } catch (NumberFormatException e) {
			        	opcao = "V"; // Sair do metodo 
			        }
					Registro registro = registros.get(indice);
					if(registro instanceof Filme) {
						verFilmeColecao((Filme)registro, colecao);
					} 
					else {
						verSerieColecao((Serie)registro, colecao);
					}
			}
		}	
	}

	private void verFilmeColecao(Filme filme, Colecao colecao) {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			opcao = main.userInterface.menuVerFilme(filme);
			switch(opcao.toUpperCase()) {
				case "N":
					gerenciadorAcoesCliente.atribuiNota(filme);
					break;
				case "S":
					gerenciadorAcoesCliente.atualizaStatus(filme);
					break;
				case "D":
					if(main.userInterface.confirmaRemocao(filme.getNome() + " de " + colecao.getNome())) {
						colecao.removeRegistro(filme.getNome());
					}
					break;
			}
		}
	}
	
	private void verSerieColecao(Serie serie, Colecao colecao) {
		String opcao = "";
		
		while(!opcao.equalsIgnoreCase("V")) {
			opcao = main.userInterface.menuVerSerie(serie);
			switch(opcao.toUpperCase()) {
				case "N":
					gerenciadorAcoesCliente.atribuiNota(serie);
					break;
				case "S":
					gerenciadorAcoesCliente.atualizaStatus(serie);
					break;
				case "E":
					gerenciadorAcoesCliente.atualizaNroEpisodiosAssistidos(serie);
					break;
				case "D":
					if(main.userInterface.confirmaRemocao(serie.getNome() + " de " + colecao.getNome())) {
						colecao.removeRegistro(serie.getNome());
					}
					break;

			}
		}
	}
	
	private void selecionaFiltro() {
		String opcao = "";
		opcao = main.userInterface.menuSelecionaFiltro();
			
		switch(opcao.toUpperCase()) {
			case "N":
				pesquisaPorNome();
				break;
			case "G":
				pesquisaPorGenero();
				break;
			case "A":
				pesquisaPorNota();
				break;
			case "S":
				pesquisaPorStatus();
				break;
		}
	}		
		
	private void pesquisaPorNome() {
		String opcao = "";
		ArrayList<Midia> opcoes = gerenciadorAcoesCliente.pesquisaPorNome();
		if(opcoes.isEmpty()) {
			main.userInterface.pesquisaNaoEncontrada();
			return;
		}
		
		do {
			opcao = main.userInterface.menuPesquisaPorNome(opcoes);
	
			switch(opcao.toUpperCase()) {
				case "V":	// Seguranca para nao entrar no default
					break;
				default:		 // opcao eh um numero -> usuario deseja ver um registro
					int indice = 0;
					try {
						indice = Integer.parseInt(opcao) - 1;
					} catch (NumberFormatException e) {
						opcao = "V"; // Sair do metodo 
					}
					Midia registro = opcoes.get(indice);
					if(registro instanceof Filme) {
						verFilme((Filme)registro);
					} 
					else {
						verSerie((Serie)registro);
					}
			}
		} while(!opcao.equalsIgnoreCase("V"));
	}
	
	private void pesquisaPorGenero() {
		String opcao = "";
		ArrayList<Midia> opcoes = gerenciadorAcoesCliente.pesquisaPorGenero();
		if(opcoes.isEmpty()) {
			main.userInterface.pesquisaNaoEncontrada();
			return;
		}
		
		do {
			opcao = main.userInterface.menuPesquisaPorGenero(opcoes);
	
			switch(opcao.toUpperCase()) {
				case "V":	// Seguranca para nao entrar no default
					break;
				default:		 // opcao eh um numero -> usuario deseja ver um registro
					int indice = 0;
					try {
						indice = Integer.parseInt(opcao) - 1;
					} catch (NumberFormatException e) {
						opcao = "V"; // Sair do metodo 
					}
					Midia registro = opcoes.get(indice);
					if(registro instanceof Filme) {
						verFilme((Filme)registro);
					} 
					else {
						verSerie((Serie)registro);
					}
			}
		} while(!opcao.equalsIgnoreCase("V"));
	}
	
	private void pesquisaPorStatus() {
		String opcao = "";
		ArrayList<Registro> opcoes = gerenciadorAcoesCliente.pesquisaPorStatus();
		if(opcoes == null) {
			return; // Opcao "Voltar"
		}
		
		if(opcoes.isEmpty()) {
			main.userInterface.pesquisaNaoEncontrada();
			return;
		}
		
		do {
			opcao = main.userInterface.menuPesquisaPorStatus(opcoes);
	
			switch(opcao.toUpperCase()) {
				case "V":	// Seguranca para nao entrar no default
					break;
				default:		 // opcao eh um numero -> usuario deseja ver um registro
					int indice = 0;
					try {
						indice = Integer.parseInt(opcao) - 1;
					} catch (NumberFormatException e) {
						opcao = "V"; // Sair do metodo 
					}
					Registro registro = opcoes.get(indice);
					if(registro instanceof Filme) {
						verFilme((Filme)registro);
					} 
					else {
						verSerie((Serie)registro);
					}
			}
		} while(!opcao.equalsIgnoreCase("V"));
	}
	
	private void pesquisaPorNota() {
		String opcao = "";
		ArrayList<Registro> opcoes = gerenciadorAcoesCliente.pesquisaPorNota();
		if(opcoes.isEmpty()) {
			main.userInterface.pesquisaNaoEncontrada();
			return;
		}
		
		do {
			opcao = main.userInterface.menuPesquisaPorNota(opcoes);
	
			switch(opcao.toUpperCase()) {
				case "V":	// Seguranca para nao entrar no default
					break;
				default:		 // opcao eh um numero -> usuario deseja ver um registro
					int indice = 0;
					try {
						indice = Integer.parseInt(opcao) - 1;
					} catch (NumberFormatException e) {
						opcao = "V"; // Sair do metodo 
					}
					Registro registro = opcoes.get(indice);
					if(registro instanceof Filme) {
						verFilme((Filme)registro);
					} 
					else {
						verSerie((Serie)registro);
					}
			}
		} while(!opcao.equalsIgnoreCase("V"));
	}
}
