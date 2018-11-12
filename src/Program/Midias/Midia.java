package Program.Midias;

import java.util.ArrayList;

public class Midia {
    private String nome;
    private ArrayList<String> genero;
    private int duracao;
    private String produtora;
    private String diretor;
    private int ano;
    private ArrayList<Integer> nroEpisodios;

    public Midia(){
        this.nome = "";
        this.genero = new ArrayList<>();
        this.duracao = 0;
        this.produtora = "";
        this.diretor = "";
        this.ano = 0;
        this.nroEpisodios = new ArrayList<>();
    }

    public Midia(String nome, ArrayList<String> genero, int duracao, String produtora, String diretor, int ano, ArrayList<Integer> nroEpisodios){
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.produtora = produtora;
        this.diretor = diretor;
        this.ano = ano;
        this.nroEpisodios = nroEpisodios;
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

    public ArrayList<Integer> getNroEpisodios(){
        return this.nroEpisodios;
    }

    @Override
    public String toString(){
        return this.getNome() + " - " + this.getGenero() + " - " + "Duracao: " + this.getDuracao() + "mins - Produtora: " + this.getProdutora() + " - Direcao: " +  this.getDiretor() + " - " + this.getAno();
    }


    public String toArq(){
        return this.getNome() + "," + this.listaStringToArq(this.getGenero()) + "," + this.getDuracao() + "," + this.getProdutora() + "," +  this.getDiretor() + "," + this.getAno() + "," + this.listaIntegerToArq(this.getNroEpisodios());
    }

    private String listaStringToArq(ArrayList<String> listaString){
        String stringSaida="";

        for(String str : listaString){
            stringSaida = stringSaida.concat(str);
            stringSaida = stringSaida.concat("-");
        }

        return stringSaida.length()>1 ? stringSaida.substring(0, stringSaida.length() - 1) : "";
    }

    private String listaIntegerToArq(ArrayList<Integer> listaInteger){
        String stringSaida="";


        for(Integer integer : listaInteger){
            stringSaida =  stringSaida.concat(String.valueOf(integer));
            stringSaida =  stringSaida.concat("-");
        }

        return stringSaida.length()>1 ? stringSaida.substring(0, stringSaida.length() - 1) : "";
    }
}
