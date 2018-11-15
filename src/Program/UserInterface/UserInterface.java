package Program.UserInterface;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Scanner;

import Program.Controle_Midias.Colecao;
import Program.Main.main;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Serie;

public class UserInterface {
	private static Scanner input;
	private static final String SENHA = "ggn24";
	
	public UserInterface() {
		input = new Scanner(System.in);
	}
	
	public String menuEscolhaUsuario() {
		String opcao = null;
		
		do {
			System.out.println("Selecione o tipo de usuario:");
			System.out.println("1 - Administrador");
			System.out.println("2 - Cliente");
			System.out.println("\nS - Sair");
			opcao = input.nextLine();
		}
		while(!opcao.equals("1") && !opcao.equals("2") && !opcao.equalsIgnoreCase("S"));
		return opcao;
	}
	
	public boolean verificaSenhaAdministrador() {
		System.out.println("Digite a senha de acesso:");
		String senha = input.nextLine();
		
		do {
			if(senha.equals(SENHA)) {
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
	
	public String menuPrincipalCliente() {
		String opcao = null;
		do {
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
	
	public String menuVerRepositorio(ArrayList<Filme> filmes, ArrayList<Serie> series ) {
		int numFilmes = filmes.size();
		int numSeries = series.size();
		String opcao = null;
		
		do {
			System.out.println("A - Adicionar novo registro");
			System.out.println("P - Pesquisar\n");
			for(int i = 1; i <= numFilmes; i++) {
				Filme f = filmes.get(i-1); 
				System.out.println(i + "- (F) " + f.getNome() + " - " + f.getStatus() + " - Nota: " + f.getNota() );
			}
			for(int i = numFilmes + 1; i <= numFilmes+numSeries; i++) {
				Serie s = series.get(i-1); 
				System.out.println(i + "- (S) " + s.getNome() + " - " + s.getStatus() + " - Nota: " + s.getNota() );
			}
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("A") && !opcao.equalsIgnoreCase("P") && !opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, numFilmes+numSeries));
	return opcao;
	}
	
	public String menuVerColecoes(ArrayList<Colecao> colecoes) {
		int numColecoes = colecoes.size();
		String opcao = null;
		
		do {
			System.out.println("A - Adicionar nova colecao\n");
			for(int i = 1; i <= numColecoes; i++) {
				Colecao c = colecoes.get(i-1); 
				System.out.println(i + c.getNome());
			}
			System.out.println("\nV - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("A") && !opcao.equalsIgnoreCase("V") && !verificaIntervalo(opcao, numColecoes));
	return opcao;
	}	
	
	public String menuVerFilme(Filme filme) {
		String opcao = null;
		
		do {
			System.out.println(filme);
			System.out.println("\nN - Atualizar nota");
			System.out.println("S - Atualizar status");
			System.out.println("V - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("N") && !opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("V"));
		return opcao; 
	}
	
	public String menuVerSerie(Serie serie) {
		String opcao = null;
		
		do {
			System.out.println(serie);
			System.out.println("\nN - Atualizar nota");
			System.out.println("S - Atualizar status");
			System.out.println("E - Atualizar numero de episodios assistidos");
			System.out.println("V - Voltar");
			opcao = input.nextLine();
		}
		while(!opcao.equalsIgnoreCase("N") && !opcao.equalsIgnoreCase("E") && !opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("V"));
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

	public void printaErroNomeJaExistente(String objeto) {
		System.out.println(objeto + " ja existente. Digite um novo nome ou enter para sair");
	}
	
	public void printaErroNomeNaoEncontrado() {
		System.out.println("Nome nao encontrado. Digite um novo nome ou enter para sair");
	}	
}
