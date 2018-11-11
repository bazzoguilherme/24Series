package Program.Controle_Midias;

import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Serie;

import java.util.Hashtable;

public abstract class Banco {
    private Hashtable<String, Midia> series;
    private Hashtable<String, Midia> filmes;

    public Banco(){
        this.series = new Hashtable<>();
        this.filmes = new Hashtable<>();
    }

    public Hashtable<String, Midia> getSeries() {
        return this.series;
    }

    public Hashtable<String, Midia> getFilmes() {
        return this.filmes;
    }

    public void adicionaMidia(Midia novaMidia, char identificadorTipoMidia){
        if (identificadorTipoMidia == 'S') {
            this.adicionaSerie(novaMidia);
        } else {
            this.adicionaFilme(novaMidia);
        }
    }
    
    public void adicionaSerie(Midia novaSerie){
        if (!series.containsKey(novaSerie.getNome())) {
            this.series.put(novaSerie.getNome(), novaSerie);
        }
    }

    public void adicionaFilme(Midia novoFilme){
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
