package Program.Midias;

import java.util.ArrayList;

public class Filme extends Registro{

    public Filme(){
        super();
    }

    public Filme(String nome, ArrayList<String> genero, int duracao, String produtora, String diretor, int ano, ArrayList<Integer> nroEpisodios){
        super(nome, genero, duracao, produtora, diretor, ano, nroEpisodios);
    }

    @Override
    public String toString(){
        return "Filme: " +  super.getNome() + " - " + super.getGenero() + " - " + super.getDuracao() + "min - " + super.getDiretor() + " - " + super.getAno();
    }

}
