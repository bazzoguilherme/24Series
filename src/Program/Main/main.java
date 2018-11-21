package Program.Main;

import Program.Arquivos.ProcessadorArquivo;
import Program.Controle_Midias.Catalogo;
import Program.Controle_Midias.Repositorio;
import Program.GerenciadorAcoes.GerenciadorMenu;
import Program.UserInterface.UserInterface;

/**
 * O programa 24Series implementa um projeto de repositorio para filmes e series,
 * disponibilizando diversas funcionalidades para o usuario
 * 
 * @author Guilherme Bazzo 
 * @author Guilherme Malta
 * @author Nicoals Duranti
 * @version 1.0
 * @since 19-11-2018 
 */
public class main {
	public static Catalogo catalogo = new Catalogo();
	public static Repositorio repositorio = new Repositorio();
	public static UserInterface userInterface = new UserInterface();
	private static final String NOME_ARQUIVO_CATALOGO = "24catalogo.csv";
	private static final String NOME_ARQUIVO_REPOSITORIO = "24RepositorioUsuario.csv";
    private static final String NOME_ARQUIVO_COLECAO = "24ColecoesUsuario.csv";

    public static void main(String[] args) {
        ProcessadorArquivo processadorArquivo = new ProcessadorArquivo();
        GerenciadorMenu gerenciadorMenu = new GerenciadorMenu();

        catalogo = processadorArquivo.criaCatalogo(NOME_ARQUIVO_CATALOGO);
        repositorio = processadorArquivo.criaRepositorio(NOME_ARQUIVO_REPOSITORIO);
        processadorArquivo.criaColecoes(NOME_ARQUIVO_COLECAO, repositorio);

        gerenciadorMenu.escolhaUsuario();

        processadorArquivo.gravaCatalogo(NOME_ARQUIVO_CATALOGO, catalogo);
        processadorArquivo.gravaRepositorio(NOME_ARQUIVO_REPOSITORIO, repositorio);
        processadorArquivo.gravaColecao(NOME_ARQUIVO_COLECAO, repositorio);

        UserInterface.limpaTela();

        main.userInterface.closeInputScanner();
    }
}