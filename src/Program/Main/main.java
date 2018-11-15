package Program.Main;

import Program.Controle_Midias.Catalogo;
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
        ArrayList<String> gen = new ArrayList<>();
        gen.add("gen1");
        ArrayList<Integer> num = new ArrayList<>();
        num.add(5);
        Serie s1 = new Serie("s1", gen, 10, "prod", "dir", 20, num);
        Filme f1 = new Filme("F1", gen, 10, "prod", "dir", 2000,num);
        Filme f4 = new Filme("tes1", gen, 10, "prod", "dir", 2000,num);
        Filme f2 = new Filme("a1", gen, 10, "prod", "dir", 2000,num);
        Filme f3 = new Filme("1", gen, 10, "prod", "dir", 2000,num);
        repositorio.adicionaFilme(f1);
        repositorio.adicionaFilme(f4);
        repositorio.adicionaFilme(f2);
        repositorio.adicionaFilme(f3);
        ArrayList<Filme> F = new ArrayList<>();
        ArrayList<Serie> S = new ArrayList<>();
        F.add(f1);
        F.add(f4);
        F.add(f2);
        F.add(f3);
        String s = userInterface.menuVerSerie(s1);
    }
}