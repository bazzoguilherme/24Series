package Program.GerenciadorAcoes;

import java.util.ArrayList;

import Program.Main.main;
import Program.Midias.Midia;

public class GerenciadorMenu {
	private static final String SENHA = "ggn24";

	public GerenciadorMenu() {
	}

	public void escolhaUsuario() {
		String opcao = null;
		
		while(!opcao.equalsIgnoreCase("S")) {
			opcao = main.userInterface.menuEscolhaUsuario();
			switch(opcao) {
				case "1":
					verificaSenhaAdministrador();
					break;
				case "2":
					//menuPrincipalCliente();
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
		String opcao = null;
		
		while(!opcao.equalsIgnoreCase("S")) {
			opcao = main.userInterface.menuPrincipalAdm();
			switch(opcao) {
				case "1":
					//verCatalogo();
					break;
				case "2":
					//dados
					break;
			}
		}	
	}
	
	private void verCatalogo() {
		ArrayList<Midia> midiaFilmes = new ArrayList<Midia>(main.catalogo.getFilmes().values());
		ArrayList<Midia> midiaSeries = new ArrayList<Midia>(main.catalogo.getSeries().values());
		String opcao = null;
		
		while(!opcao.equalsIgnoreCase("V")) {
			opcao = main.userInterface.menuVerCatalogo(midiaFilmes, midiaSeries);
			switch(opcao.toUpperCase()) {
			case "F":
				GerenciadorAcoesAdm gerenciadorAcoesAdm = new GerenciadorAcoesAdm();
				gerenciadorAcoesAdm.adicionarMidiaFilme();
				break;
			case "S":
				GerenciadorAcoesAdm gerenciadorAcoesAdm2 = new GerenciadorAcoesAdm();
				gerenciadorAcoesAdm2.adicionarMidiaSerie();
				break;
			default: // opcao e' um numero -> usuario deseja ver a midia
				int indice = Integer.parseInt(opcao) - 1;
				// CONTINUAR
			}
		}
	}
}
