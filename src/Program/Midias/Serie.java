package Program.Midias;

import java.util.ArrayList;

public class Serie extends Registro {
    private int nroEpisodiosAssistidos;

    public Serie(){
        super();
        this.nroEpisodiosAssistidos = 0;
    }

    public Serie(String nome, ArrayList<String> genero, int duracao, String produtora, String diretor, int ano, ArrayList<Integer> nroEpisodios){
        super(nome, genero, duracao, produtora, diretor, ano, nroEpisodios);
        this.nroEpisodiosAssistidos = 0;
    }

    public int getNroEpisodiosAssistidos() {
        return this.nroEpisodiosAssistidos;
    }

    public void setNroEpisodiosAssistidos(int quantidadeAssistida){
        int quantidadeTotalEpisodios = this.quantidadeTotalEpisodios();

        if (quantidadeTotalEpisodios < quantidadeAssistida){
            this.nroEpisodiosAssistidos = quantidadeTotalEpisodios;
        } else if (quantidadeAssistida < 0){
            this.nroEpisodiosAssistidos = 0;
        }
        else {
            this.nroEpisodiosAssistidos = quantidadeAssistida;
        }
    }

    public int quantidadeTotalEpisodios() {
        int totalEpisodios = 0;
        for (int quantEpisodio : super.getNroEpisodios()) {
            totalEpisodios += quantEpisodio;
        }
        return totalEpisodios;
    }

    @Override
    public String toString(){
        return "Serie: " +  super.getNome() + " - " + super.getGenero() + " - " + super.getDuracao() + "min/Episodio - " + super.getDiretor() + " - " + super.getAno();
    }

}
