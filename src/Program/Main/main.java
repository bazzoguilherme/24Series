package Program.Main;

import Program.Controle_Midias.Catalogo;
import Program.Controle_Midias.Colecao;
import Program.Controle_Midias.Repositorio;
import Program.GerenciadorAcoes.GerenciadorAcoesCliente;
import Program.Midias.Filme;
import Program.Midias.Registro;
import Program.Midias.Serie;
import Program.UserInterface.UserInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import static Tests.Constantes.Constantes_Filmes.*;
import static Tests.Constantes.Constantes_Series.*;
import static Tests.Constantes.Constantes_Series.ANO_SERIE3;


public class main {
	public static Catalogo catalogo = new Catalogo();
	public static Repositorio repositorio = new Repositorio();
	public static UserInterface userInterface = new UserInterface();
	
    public static void main(String[] args) {
        System.out.println("24 Series");

    }
}