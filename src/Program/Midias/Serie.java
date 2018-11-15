package Program.Midias;

import java.util.ArrayList;

public class Serie extends Registro {
    private int nroEpisodiosAssistidos;
	public static final String FINALIZADO = "Finalizado";
	public static final String ASSISTIR_MAIS_TARDE = "Assistir mais tarde";
	public static final String ASSISTINDO = "Assistindo";
	public static final String REASSISTINDO = "Reassistindo";
	public static final String PAUSA = "Na Geladeira"; // Assistindo, mas foi dado uma pausa
	public static final String CANCELADO = "Cancelado"; // Deixou de ver a serie
	

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

    
    public ArrayList<String> retornaPossiveisStatus(){
        ArrayList<String> status = new ArrayList<String>();
        status.add(ASSISTINDO);
        status.add(ASSISTIR_MAIS_TARDE);
        status.add(FINALIZADO);
        status.add(REASSISTINDO);
        status.add(PAUSA);
        status.add(CANCELADO);
        return status;
    }

    @Override
    public String toString() {
      	return super.toString() + " - Episodios: " + this.getNroEpisodios() + "\nEpisodios assistidos: " + this.getNroEpisodiosAssistidos() + " - Nota: " + this.getNota() + " - " + this.getStatus();
    }

}
