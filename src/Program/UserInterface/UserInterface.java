package Program.UserInterface;

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
		String entry;
		boolean entradaAceita;
		int num = -1;
		
		System.out.println("Informe " + pedido);
		do {
			try {
					entradaAceita = true;
					entry = input.nextLine();
					num = Integer.parseInt(entry);
				} catch (java.lang.NumberFormatException e) {
					entradaAceita = false;
					System.out.println("Valor invalido. Digite novamente, por favor: ");
				}
		}while(!entradaAceita);
		input.close();
		return num;
	}
	
	
	
	
}
