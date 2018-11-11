package Program.Main;

import Program.Controle_Midias.Catalogo;
import Program.Controle_Midias.Repositorio;
import Program.UserInterface.UserInterface;


public class main {
	public static Catalogo catalogo = new Catalogo();
	public static Repositorio repositorio = new Repositorio();
	public static UserInterface userInterface = new UserInterface();
	
    public static void main(String[] args) {
        System.out.println("24 Series");  
        userInterface.verificaSenhaAdministrador();
    }
}
