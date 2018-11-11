package Program.UserInterface;

import java.util.ArrayList;
import java.util.Scanner;

import Program.Main.main;

public class UserInterface {
	private static Scanner input;
	
	public UserInterface() {
		input = new Scanner(System.in);
	}
	
	public <T> int selecionaOpcao(ArrayList<T> opcoes) {
		String entry;
		boolean entradaAceita;
		int num = 0;
		
		System.out.println("Selecione uma opcao: ");
		for(int i = 0; i < opcoes.size(); i++) {
			System.out.println(" " + (i+1) + ") " + opcoes.get(i));
		}
		
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
		
		return num-1;
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
