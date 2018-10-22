package Program.Midias;

import java.util.ArrayList;


public class Registro extends Midia {
    private double nota;
    private String status;
    //TODO Verificar status inicial
    private static final double NOTAINICIAL = 0.0;
    private static final String STATUSINICIAL = "Planejo Assistir";

    public Registro(){
        super();
        this.nota = NOTAINICIAL;
        this.status = STATUSINICIAL;

    }

    public Registro(String nome, String genero, int duracao, String produtora, String diretor, int ano){
        super(nome, genero, duracao, produtora, diretor, ano);
        this.nota = NOTAINICIAL;
        this.status = STATUSINICIAL;
    }

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

    public ArrayList retornaPossiveisStatus(){
        return new ArrayList();
    }
}
