package Program.Midias;

import java.util.ArrayList;

public class Filme extends Registro{
	public static final int EPS_FILMES = 1; // Para os filmes, o atributo NroEpisodios é sempre 1
	public static final String ASSISTIDO = "Assistido";
	public static final String ASSISTIR_MAIS_TARDE = "Assistir mais tarde";

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

    public ArrayList<String> retornaPossiveisStatus(){
        ArrayList<String> status = new ArrayList<String>();
        status.add(ASSISTIDO);
        status.add(ASSISTIR_MAIS_TARDE);
        return status;
    }
}
