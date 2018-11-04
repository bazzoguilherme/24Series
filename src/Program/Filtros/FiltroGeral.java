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

    public ArrayList<Midia> filtraPorNome(String nome, ArrayList<Midia> midias){
        ArrayList<Midia> midiasNome = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (midiaInteracao.getNome().toLowerCase().equals(nome.toLowerCase())){
                midiasNome.add(midiaInteracao);
            }
        }

        return midiasNome;
    }

    public ArrayList<Midia> filtraPorGenero(String genero, ArrayList<Midia> midias){
        ArrayList<Midia> midiasGenero = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (this.verificaGeneroEmListaGeneros(midiaInteracao.getGenero(), genero)){
                midiasGenero.add(midiaInteracao);
            }
        }

        return midiasGenero;
    }

    private boolean verificaGeneroEmListaGeneros(ArrayList<String> generosMidia, String generoFiltro){
        for (String genero : generosMidia){
            if(genero.toLowerCase().equals(generoFiltro.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Midia> filtraPorProdutora(String produtora, ArrayList<Midia> midias){
        ArrayList<Midia> midiasProdutora = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (midiaInteracao.getProdutora().toLowerCase().equals(produtora.toLowerCase())){
                midiasProdutora.add(midiaInteracao);
            }
        }

        return midiasProdutora;
    }

    public ArrayList<Midia> filtraPorDiretor(String diretor, ArrayList<Midia> midias){
        ArrayList<Midia> midiasDiretor = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (midiaInteracao.getDiretor().toLowerCase().equals(diretor.toLowerCase())){
                midiasDiretor.add(midiaInteracao);
            }
        }

        return midiasDiretor;
    }

    public ArrayList<Midia> filtraPorAno(int ano, ArrayList<Midia> midias){
        ArrayList<Midia> midiasAno = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (midiaInteracao.getAno() == ano){
                midiasAno.add(midiaInteracao);
            }
        }

        return midiasAno;
    }

    public ArrayList<Midia> filtraPorDuracao(int duracao, ArrayList<Midia> midias){
        ArrayList<Midia> midiasDuracao = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (midiaInteracao.getDuracao() == duracao){
                midiasDuracao.add(midiaInteracao);
            }
        }

        return midiasDuracao;
    }

    public ArrayList<Midia> ordenaPorNome(ArrayList<Midia> midias){
        return new ArrayList<>();
    }

    public ArrayList<Midia> inverteOrdem(ArrayList<Midia> midias){
        return new ArrayList<>();
    }

}
