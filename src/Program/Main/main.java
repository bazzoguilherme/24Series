package Program.Main;

import Program.Arquivos.ProcessadorArquivo;
import Program.Controle_Midias.Catalogo;
import Program.Controle_Midias.Repositorio;
import Program.GerenciadorAcoes.GerenciadorMenu;
import Program.UserInterface.UserInterface;

public class main {
	public static Catalogo catalogo = new Catalogo();
	public static Repositorio repositorio = new Repositorio();
	public static UserInterface userInterface = new UserInterface();
	private static final String NOME_ARQUIVO = "24catalogo.csv";
	
    public static void main(String[] args) {
        ProcessadorArquivo processadorArquivo = new ProcessadorArquivo();
        GerenciadorMenu gerenciadorMenu = new GerenciadorMenu();

        catalogo = processadorArquivo.criaCatalogo(NOME_ARQUIVO);

        gerenciadorMenu.escolhaUsuario();

        processadorArquivo.gravaCatalogo(NOME_ARQUIVO, catalogo);

        UserInterface.limpaTela();

        main.userInterface.closeInputScanner();
    }
}