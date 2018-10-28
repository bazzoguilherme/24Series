package Program.Controle_Midias;

import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Serie;

import java.util.Hashtable;

public class Banco {
    private Hashtable<String, Serie> series;
    private Hashtable<String, Filme> filmes;

    public Banco(){
        this.series = new Hashtable<>();
        this.filmes = new Hashtable<>();
    }

    public Hashtable<String, Serie> getSeries() {
        return this.series;
    }

    public Hashtable<String, Filme> getFilmes() {
        return this.filmes;
    }

    public void adicionaMidia(Midia novaMidia){
        if ((novaMidia instanceof Serie)) {
            this.adicionaSerie((Serie)novaMidia);
        } else {
            this.adicionaFilme((Filme)novaMidia);
        }
    }

    public void adicionaSerie(Serie novaSerie){
        if (!series.containsKey(novaSerie.getNome())) {
            this.series.put(novaSerie.getNome(), novaSerie);
        }
    }

    public void adicionaFilme(Filme novoFilme){
        if(!filmes.containsKey((novoFilme.getNome()))){
            this.filmes.put(novoFilme.getNome(), novoFilme);
        }
    }

    public Midia selecionaSerie(String nome){
        return series.get(nome);
    }

    public Midia selecionaFilme(String nome){
        return filmes.get(nome);
    }

    public void removeSerie(String nome){
        series.remove(nome);
    }

    public void removeFilme(String nome){
        filmes.remove(nome);
    }

}
