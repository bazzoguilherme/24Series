package Program.UserInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	
	public UserInterface() {
		
	}

	public String pedeString(String pedido) {
		Scanner input = new Scanner(System.in);
		String entry;
		
		System.out.println("Informe " + pedido);
		entry = input.nextLine();
		input.close();
		
		return entry;
	}
		
	
	public int pedeInt(String pedido) {
		Scanner input = new Scanner(System.in);
		
		int num = 0;
		
		System.out.println("Informe " + pedido);
		num = this.pedeInt(input);
		input.close();
		return num;
	}
	
	
	private int pedeInt(Scanner input){
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
	
	public ArrayList<Integer> pedeArrayInt(String pedido){
		ArrayList<Integer> nums = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		String resp="y";
		
		System.out.println("Informe " + pedido);
		do {
			nums.add(this.pedeInt(input));
			System.out.println("[enter] Continuar \n[x] Sair");
			resp = input.nextLine();
			//System.out.println(resp);
		}while(!resp.equals("x"));
		
		input.close();

		return nums;
	}
	
	
}
