package Program.UserInterface;

import java.io.IOException;
import java.util.*;

import Program.Controle_Midias.Colecao;
import Program.Controle_Midias.Repositorio;
import Program.Filtros.FiltroRepositorio;
import Program.GerenciadorAcoes.GerenciadorAcoesCliente;
import Program.Main.main;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Registro;
import Program.Midias.Serie;
import Program.ProcessadorEstatistico.ProcessadorEstatistico;
import  static Program.Midias.Registro.NOTAMAXIMA;

public class UserInterface {
	private static Scanner input;
		
	public UserInterface() {
		input = new Scanner(System.in);
	}
	
	public String menuEscolhaUsuario() {
		String opcao = null;
		
		do {
			limpaTela();
			System.out.println("Selecione o tipo de usuario:");
			System.out.println("1 - Cliente");
			System.out.println("2 - Administrador");
			System.out.println("\nS - Sair");
			opcao = input.nextLine();
		}
		while(!opcao.equals("1") && !opcao.equals("2") && !opcao.equalsIgnoreCase("S"));
		return opcao;
	}
	
	public boolean verificaSenhaAdministrador(String codigoAcesso) {
		System.out.println("Digite a senha de acesso:");
		String senha = input.nextLine();
		
		do {
			limpaTela();
			if(senha.equals(codigoAcesso)) {
				return true;
			}
			else {
				System.out.println("Senha incorreta, tente novamente ou digite S para sair");
				senha = input.nextLine();
			}
		}
		while(!senha.equalsIgnoreCase("S"));	
		return false;
	}
	
	public String menuPrincipalAdm() {
		String opcao = null;
		do {
			limpaTela();
			System.out.println("1 - VER CATALOGO");
			System.out.println("\nS - Sair");
			opcao = input.nextLine();
		}
		while(!opcao.equals("1") && !opcao.equalsIgnoreCase("S"));
		return opcao;
	}
	
	public String menuVerCatalogo(ArrayList<Midia> filmes, ArrayList<Midia> series) {
		int numFilmes = filmes.size();
		int numSeries = series.size();
		String opcao = null;
		
		do {
			limpaTela();
			System.out.println("F - Adicionar novo filme");
			System.out.println("S - Adicionar nova serie\n");
			for(int i = 1; i <= numFilmes; i++) {
				Midia m = filmes.get(i-1); 
				System.out.println(i + "- (F) - " + m.getNome());
			}
			for(int i = numFilmes+1; i <= numFilmes+numSeries; i++) {
				Midia m = series.get(i-1); 
				System.out.println(i + "- (S) - " + m.getNome());
			}
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("F") && !opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, numFilmes+numSeries));
	return opcao;
	}
	
	public String menuVerMidia(Midia midia) {
		String opcao = null;
		
		do {
			limpaTela();
			System.out.println(midia);
			System.out.println("\nD - Deletar Midia");
			System.out.println("V - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("D") && !opcao.equalsIgnoreCase("V"));
		return opcao; 
	}
	
	public String menuPrincipalCliente() {
		String opcao = null;
		do {
			limpaTela();
			System.out.println("1 - MEU REPOSITORIO");
			System.out.println("2 - MINHAS COLECOES");
			System.out.println("3 - RECOMENDADOS PARA MIM");
			System.out.println("4 - MEU HISTORICO");
			System.out.println("5 - BATALHA");
			System.out.println("6 - CONTINUAR ASSISTINDO");
			System.out.println("\nS - Sair");
			opcao = input.nextLine();
		}
		while(!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5") && !opcao.equals("6") && !opcao.equalsIgnoreCase("S"));
		return opcao;
	}
	
	private boolean verificaIntervalo(String string, int max) {
        int numero = 0;
		
		try {
        	numero = Integer.parseInt(string);
        } catch (NumberFormatException e) {
        	return false;
        }
		
		if(numero > 0 && numero <= max) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String menuVerRepositorio(ArrayList<Midia> filmes, ArrayList<Midia> series ) {
		int numFilmes = filmes.size();
		int numSeries = series.size();
		String opcao = null;
		
		do {
			limpaTela();
			System.out.println("F - Adicionar novo filme");
			System.out.println("S - Adicionar nova serie");
			System.out.println("P - Pesquisar\n");
			for(int i = 1; i <= numFilmes; i++) {
				Filme f = (Filme)filmes.get(i-1); 
				System.out.println(i + "- (F) " + f.getNome() + " - " + f.getStatus() + " - Nota: " + f.getNota() );
			}
			for(int i = numFilmes + 1; i <= numFilmes+numSeries; i++) {
				Serie s = (Serie)series.get(i-1); 
				System.out.println(i + "- (S) " + s.getNome() + " - " + s.getStatus() + " - Nota: " + s.getNota() );
			}
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("F") && !opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("P") && !opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, numFilmes+numSeries));
	return opcao;
	}
	
	public String menuVerColecoes(ArrayList<Colecao> colecoes) {
		int numColecoes = colecoes.size();
		String opcao = null;
		
		do {
			limpaTela();
			System.out.println("A - Adicionar nova colecao\n");
			for(int i = 1; i <= numColecoes; i++) {
				Colecao c = colecoes.get(i-1); 
				System.out.println(i + " - " + c.getNome());
			}
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("A") && !opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, numColecoes));
	return opcao;
	}	
	
	public String menuVerColecao(Colecao colecao, ArrayList<Registro> registros) {
		String opcao = null;
		
		do {
			limpaTela();
			System.out.println(colecao.getNome() + "\n");
			for(int i=1; i<=registros.size(); i++) {
				Registro r = registros.get(i-1);
				System.out.println(i + "- " + r.getNome() + " - " + r.getStatus() + " - Nota: " + r.getNota());
			}
			System.out.println("\nA - Adicionar novo registro");
			System.out.println("N - Renomear colecao");
			System.out.println("R - Remover colecao");
			System.out.println("V - Voltar");
			opcao = input.nextLine();
		} while(!opcao.equalsIgnoreCase("A") && !opcao.equalsIgnoreCase("N") && !opcao.equalsIgnoreCase("R") && !opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, registros.size()));			
		return opcao;
	}
	
	public String menuVerFilme(Filme filme) {
		String opcao = null;
		
		do {
			limpaTela();
			System.out.println(filme);
			System.out.println("\nN - Atualizar nota");
			System.out.println("S - Atualizar status");
			System.out.println("D - Deletar Filme");
			System.out.println("V - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("N") && !opcao.equalsIgnoreCase("D") && !opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("V"));
		return opcao; 
	}
	
	public String menuVerSerie(Serie serie) {
		String opcao = null;
		
		do {
			limpaTela();
			System.out.println(serie);
			System.out.println("\nN - Atualizar nota");
			System.out.println("S - Atualizar status");
			System.out.println("E - Atualizar numero de episodios assistidos");
			System.out.println("D - Deletar Serie");
			System.out.println("V - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("N") && !opcao.equalsIgnoreCase("D") && !opcao.equalsIgnoreCase("E") && !opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("V"));
		return opcao; 
	}
	
	public String menuSelecionaFiltro() {
		String opcao = null;
		
		do {
			limpaTela();
			System.out.println("Selecione o criterio de pesquisa:");
			System.out.println("N - Nome");
			System.out.println("G - Genero");
			System.out.println("A - Avaliacao/Nota");
			System.out.println("S - Status");
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("N") && !opcao.equalsIgnoreCase("G") && !opcao.equalsIgnoreCase("A") && !opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("V"));
		return opcao;
	}
		
	public String menuPesquisaPorNome(ArrayList<Midia> opcoes) {
		String opcao = null;
		
		do {
			limpaTela();
			for(int i = 1; i <= opcoes.size(); i++) {
				Registro r = (Registro)opcoes.get(i-1); 
				System.out.println(i + "- " + r.getNome()+ " - " + r.getStatus() + " - Nota: " + r.getNota());
				System.out.println("\t" + r.getGenero());
			}
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, opcoes.size()));
		return opcao;
	}
	
	public String menuPesquisaPorGenero(ArrayList<Midia> opcoes) {
		String opcao = null;
		
		do {
			limpaTela();
			for(int i = 1; i <= opcoes.size(); i++) {
				Registro r = (Registro)opcoes.get(i-1); 
				System.out.println(i + "- " + r.getNome()+ " - " + r.getStatus() + " - Nota: " + r.getNota());
			}
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, opcoes.size()));
		return opcao;
	}
	
	public String menuPesquisaPorNota(ArrayList<Registro> opcoes) {
		String opcao = null;
		
		do {
			limpaTela();
			for(int i = 1; i <= opcoes.size(); i++) {
				Registro r = opcoes.get(i-1); 
				System.out.println(i + "- " + r.getNome()+ " - " + r.getStatus());
				System.out.println("\t" + r.getGenero());
			}
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, opcoes.size()));
		return opcao;
	}
	
	public String menuPesquisaPorStatus(ArrayList<Registro> opcoes) {
		String opcao = null;
		
		do {
			limpaTela();
			for(int i = 1; i <= opcoes.size(); i++) {
				Registro r = opcoes.get(i-1); 
				System.out.println(i + "- " + r.getNome()+ " - Nota: " + r.getNota());
				System.out.println("\t" + r.getGenero());
			}
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, opcoes.size()));
		return opcao;
	}
	
	public <T> int selecionaOpcao(ArrayList<T> opcoes) {
		int indice = 0;
		do {
			System.out.println("Selecione uma opcao: ");
			for(int i = 0; i < opcoes.size(); i++) {
				System.out.println(" " + (i+1) + ") " + opcoes.get(i));
			}
			indice = pedeInt();
		}
		while(indice <= 0 || indice > opcoes.size());
		return indice-1;
	}

	public <T> int selecionaOpcao(ArrayList<T> opcoes, String pedido) {
		System.out.println("Selecione uma opcao: ");
		for(int i = 0; i < opcoes.size(); i++) {
			System.out.println(" " + (i+1) + ") " + opcoes.get(i));
		}
		int indice = pedeInt(pedido);
		return indice-1;
	}

	public String pedeString(String pedido) {
		String entry;
		
		System.out.println("Informe " + pedido);
		entry = input.nextLine();
		
		return entry;
	}
		
	public ArrayList<String> pedeArrayString(String pedido){
		ArrayList<String> strings = new ArrayList<>();
		String resp="y";
		
		do {
			strings.add(this.pedeString(pedido));
			System.out.println("[enter] Continuar \n[x] Sair");
			resp = input.nextLine();
		}while(!resp.equals("x"));
		
		return strings;
	}
	
	public int pedeInt(String pedido) {
		
		int num = 0;
		
		System.out.println("Informe " + pedido);
		num = this.pedeInt();

		return num;
	}
	
	public ArrayList<Integer> pedeArrayInt(String pedido){
		ArrayList<Integer> nums = new ArrayList<>();
		String resp="y";
		
		System.out.println("Informe " + pedido);
		do {
			nums.add(this.pedeInt());
			System.out.println("[enter] Continuar \n[x] Sair");
			resp = input.nextLine();
		}while(!resp.equals("x"));
		
		return nums;
	}
	
	private int pedeInt(){
		String entry;
		boolean entradaAceita;
		int num = 0;
		
		do {
			entradaAceita = true;
			try {
					entry = input.nextLine();
					num = Integer.parseInt(entry);
				} catch (java.lang.NumberFormatException e) {
					entradaAceita = false;
					System.out.println("Valor invalido. Digite novamente, por favor: ");
				}
		}while(!entradaAceita);
		
		return num;
	}
	
	public double pedeNota() {
		double nota = 0;
		String entry;
		boolean entradaAceita;
		
		do {	
			limpaTela();
			System.out.println("Informe a nota (0-" + NOTAMAXIMA +") que esta procurando:");
			do {
				entradaAceita = true;
				try {
						entry = input.nextLine();
						nota = Double.parseDouble(entry);
					} catch (java.lang.NumberFormatException e) {
						entradaAceita = false;
						System.out.println("Valor invalido. Digite novamente, por favor: ");
					}
			}while(!entradaAceita);
		} while(nota < 0 || nota > NOTAMAXIMA);
			
		return nota;
	}
		
	public void printaArrayMidias(ArrayList<Midia> midias) {
		limpaTela();
		for(Midia m: midias){
			System.out.println(m.getNome());
			System.out.println("\t" + m.getGenero());
		}
	}
	
	public void imprimeHistorico(String tempoSeries, String tempoFilmes, int horasAssistidas, int epsAssistidos, int filmesAssistidos, ArrayList<String> generos) {
		limpaTela();
		System.out.println("=====Historico do usuario=====\n");
		this.imprimeTempoEmSeriesAssistidas(tempoSeries);
		this.imprimeTempoEmFilmesAssistidos(tempoFilmes);
		this.imprimeHorasAssistidas(horasAssistidas);
		this.imprimeTotalDeEpisodiosAssistidos(epsAssistidos);
		this.imprimeTotalDeFilmesAssistidos(filmesAssistidos);
		this.imprimeGenerosPreferidos(generos);
		System.out.println("==============================\n");
		input.nextLine();
	}
	
	private void imprimeTempoEmSeriesAssistidas(String tempoSeries) {
		System.out.println(" Tempo investido em series: " + tempoSeries);
	}
	
	private void imprimeTempoEmFilmesAssistidos(String tempoFilmes) {
		System.out.println(" Tempo investido em filmes: " + tempoFilmes);
	}
	
	private void imprimeHorasAssistidas(int horasAssistidas) {
		System.out.println(" Total de horas gastas em series e filmes: " + String.valueOf(horasAssistidas));
	}
	
	private void imprimeTotalDeEpisodiosAssistidos(int epsAssistidos) {
		System.out.println(" Total de episodios assistidos: " + String.valueOf(epsAssistidos));
	}
	
	private void imprimeTotalDeFilmesAssistidos(int filmesAssistidos) {
		System.out.println(" Quantidade de filmes ja assistidos: " + String.valueOf(filmesAssistidos));
	}
	
	private void imprimeGenerosPreferidos(ArrayList<String> generos) {
		System.out.println("Genero(s) favorito(s): " + generos);
	}
	
	public String pedeStatus() { // Utiliza apenas status de serie, pois os de filme estao representados nelas
		Serie serie = new Serie(); // Apenas para chamar o metodo retornaPossiveisStatus
		ArrayList<String> status = serie.retornaPossiveisStatus();
		int i = this.selecionaOpcao(status);
		return status.get(i);
	}
	
	public void batalha(){
		limpaTela();
		System.out.println("Batalha entre Midias!\n");

		GerenciadorAcoesCliente gerenciadorAcoesCliente = new GerenciadorAcoesCliente();
		ArrayList<Registro> registrosBatalha = new ArrayList<>();
		Registro registroVencedor;
		ArrayList<String> opcaoBatalha = new ArrayList<>();
		opcaoBatalha.add("Repositorio");
		opcaoBatalha.add("Colecoes");
		int opcao = this.selecionaOpcao(opcaoBatalha);


		if(opcao == 0){
			registrosBatalha = this.valuesHashtable(main.repositorio.getSeries());
			registrosBatalha.addAll(this.valuesHashtable(main.repositorio.getFilmes()));

		} else {
			ArrayList<String> nomeColecoesArray = new ArrayList<>();
			Hashtable<String, Colecao> colecoesRepositorio = main.repositorio.getColecoes();
			Set<String> nomeColecoes = colecoesRepositorio.keySet();

			if(nomeColecoes.isEmpty()){
				System.out.println("Sem colecoes para realizar a batalha.\n");
				return;
			}

			for(String nomeC : nomeColecoes){
				nomeColecoesArray.add(nomeC);
			}
			int opcaoColecao = this.selecionaOpcao(nomeColecoesArray, "a colecao para realizar a batalha");

			registrosBatalha = this.valuesHashtable(colecoesRepositorio.get(nomeColecoesArray.get(opcaoColecao)).getRegistros());

		}

		if(registrosBatalha.isEmpty()){
			System.out.println("Sem midias para realizar a batalha.");
		} else {
			System.out.println("- Que comece a batalha!\n");

			registroVencedor = gerenciadorAcoesCliente.batalha(registrosBatalha);

			System.out.println("\nVencedor da batalha: " + registroVencedor.getNome());
		}
	}

	private ArrayList<Registro> valuesHashtable(Hashtable<String, ? extends Midia> midias){
		ArrayList<Registro> midiasLista = new ArrayList<>();
		Set<String> keyMidias = midias.keySet();
		for (String key : keyMidias){
			midiasLista.add((Registro) midias.get(key));
		}
		return midiasLista;
	}

	public void sugestContinuar(){
		limpaTela();
		System.out.println("Sugestoes para continuar assistindo!\n");
		ArrayList<Midia> sugestoes = new GerenciadorAcoesCliente().sugestContinuar(main.repositorio);

		if(sugestoes.isEmpty()){
			System.out.println("Todas Series em dia!");
		} else {
			System.out.println("Sugestoes: ");
			for(Midia sugest : sugestoes){
				System.out.println('\t' + sugest.getNome());
			}
		}
	}

	public void horasGastasAssistindo(){
		limpaTela();
		System.out.println("Tempo gasto com suas Series/Filmes:\n");
		int tempoGastoAssistindo = new GerenciadorAcoesCliente().horasGastasAssistindo(main.repositorio);
		System.out.println('\t' + new ProcessadorEstatistico().minutosParaDiasHorasMin(tempoGastoAssistindo));
	}

	public static void limpaTela(){
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
//			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}

	public void printaErroNomeJaExistente(String objeto) {
		System.out.println(objeto + " ja existente. Digite um novo nome ou enter para sair");
	}
	
	public void printaErroNomeNaoEncontrado() {
		System.out.println("Nome nao encontrado. Digite um novo nome ou enter para sair");
	}	
	
	public void pesquisaNaoEncontrada() {
		System.out.println("Nenhum registro encontrado. Precione qualquer tecla para voltar");
		input.nextLine();
	}
	
	public boolean confirmaRemocao(String nome) {
		limpaTela();
		String resp = null;
		do {
			System.out.println("Tem certeza que deseja remover " + nome + "?\n [S] Confirmar	[N] Cancelar");
			resp = input.nextLine();
		}
		while(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
		if(resp.equalsIgnoreCase("S")) {
			return true;
		}
		else {
			return false;
		}
	}
}
