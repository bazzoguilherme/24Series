package Program.Midias;

public class Midia {
    private String nome;
    private String genero;
    private int duracao;
    private String produtora;
    private String diretor;
    private int ano;

    public Midia(){
        this.nome = "";
        this.genero = "";
        this.duracao = 0;
        this.produtora = "";
        this.diretor = "";
        this.ano = 0;
    }

    public Midia(String nome, String genero, int duracao, String produtora, String diretor, int ano){
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

    public String getGenero() {
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
