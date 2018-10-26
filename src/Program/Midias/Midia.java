package Program.Midias;

import java.util.ArrayList;

public class Midia {
    private String nome;
    private ArrayList<String> genero;
    private int duracao;
    private String produtora;
    private String diretor;
    private int ano;

    public Midia(){
        this.nome = "";
        this.genero = new ArrayList<>();
        this.duracao = 0;
        this.produtora = "";
        this.diretor = "";
        this.ano = 0;
    }

    public Midia(String nome, ArrayList<String> genero, int duracao, String produtora, String diretor, int ano){
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.produtora = produtora;
        this.diretor = diretor;
        this.ano = ano;
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<String> getGenero() {
        return this.genero;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public String getProdutora() {
        return this.produtora;
    }

    public String getDiretor() {
        return this.diretor;
    }

    public int getAno() {
        return this.ano;
    }
}
