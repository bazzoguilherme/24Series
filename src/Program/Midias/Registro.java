package Program.Midias;

import java.util.ArrayList;
import static Program.Midias.Serie.ASSISTIR_MAIS_TARDE;

public abstract class Registro extends Midia{
    private double nota;
    private String status;
    private static final double NOTAINICIAL = 0.0;
    public static final Integer NOTAMAXIMA = 10;
    private static final String STATUSINICIAL = ASSISTIR_MAIS_TARDE;

    public Registro(){
        super();
        this.nota = NOTAINICIAL;
        this.status = STATUSINICIAL;
    }
    
    public Registro(String nome, ArrayList<String> genero, int duracao, String produtora, String diretor, int ano, ArrayList<Integer> nroEpisodios){
        super(nome, genero, duracao, produtora, diretor, ano, nroEpisodios);
        this.nota = NOTAINICIAL;
        this.status = STATUSINICIAL;
    }
    
    public abstract ArrayList<String> retornaPossiveisStatus();

    public double getNota(){
        return this.nota;
    }

    public String getStatus(){
        return this.status;
    }

    public void setNota(double nota){
        this.nota = nota;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String toArq(){
        return super.toArq() + "," + this.status + "," + this.nota;
    }
}
