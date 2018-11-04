package Program.Filtros;

import Program.Controle_Midias.Catalogo;
import Program.Midias.Midia;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class FiltroGeral {

    public FiltroGeral(){

    }


    public ArrayList<Midia> buscaPorNome(String nome, Catalogo catalogo){
        ArrayList<Midia> midiaComNome = this.buscaMidiaPorNome(nome, catalogo.getSeries());
        midiaComNome.addAll(this.buscaMidiaPorNome(nome, catalogo.getFilmes()));
            // Concatena o resultado ao analisar os filmes com o que já existia para series

        return midiaComNome;
    }

    private ArrayList<Midia> buscaMidiaPorNome(String nome, Hashtable<String, Midia> midiaMap){
        ArrayList<Midia> midiaComNome = new ArrayList<>();
        Set<String> chaveMidias = midiaMap.keySet();

        for (String nomeMidia : chaveMidias){
            if(nomeMidia.toLowerCase().contains(nome.toLowerCase())){
                midiaComNome.add(midiaMap.get(nomeMidia));
            }
        }

        return midiaComNome;
    }

}
