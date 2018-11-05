package Program.GerenciadorAcoes;

import java.util.ArrayList;

import Program.Controle_Midias.Colecao;
import Program.Main.main;
import Program.Midias.Registro;
import Program.Midias.Serie;
import Program.UserInterface.UserInterface;

public class GerenciadorAcoesCliente {
	
	private static final String PEDENOTA = "a nota que deseja dar a ";
	private static final String PEDENROEPS = "o numero de novos episodios que assistiu";
	private static final String PEDENOME_COLECAO = "o nome que deseja dar a sua colecao:";
		
	public GerenciadorAcoesCliente() {
	}
	
	public void atribuiNota(Registro registro) {
		int nota = main.userInterface.pedeInt(PEDENOTA + registro.getNome() + ":");
		registro.setNota(nota);
	}
	
//	public void atualizaStatus(Registro registro) {
//		ArrayList<String> possiveisStatus = registro.retornaPossiveisStatus();
//		int indice = main.userInterface.selecionaOpcao(possiveisStatus);
//		registro.setStatus(possiveisStatus.get(indice));			
//	}
	
	public void atualizaNroEpisodiosAssistidos(Serie serie) {
		int novos_eps = main.userInterface.pedeInt(PEDENROEPS);
		int quantidadeAssistida = serie.getNroEpisodiosAssistidos() + novos_eps;
		serie.setNroEpisodiosAssistidos(quantidadeAssistida);
	}
	
	public void criaColecao() {
		String nome = null;
		Boolean erro = true;  // flag erro
		while(erro)
		{
			nome = main.userInterface.pedeString(PEDENOME_COLECAO);
			if(nome.equals(""))
			{
				return;
			}
			if(!main.repositorio.getColecoes().containsKey(nome))
			{
				erro = false;
			}
			else
			{
				main.userInterface.printaErroNomeJaExistente("Colecao"); 
			}
		}
		Colecao novaColecao = new Colecao(nome);
		main.repositorio.getColecoes().put(nome, novaColecao);
	}
}
