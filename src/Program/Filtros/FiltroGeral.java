package Program.Filtros;

import Program.Controle_Midias.Catalogo;
import Program.Midias.Midia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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


    public ArrayList<Midia> filtraPorNaoAssistidas(ArrayList<Midia> assistidas, ArrayList<Midia> catalogadas){
        ArrayList<Midia> naoAssistidas = new ArrayList<>();

        for(Midia midia : catalogadas){
            if(!this.verificaMidiaEmListaMidias(midia, assistidas)){
                naoAssistidas.add(midia);
            }
        }

        return naoAssistidas;
    }

    private boolean verificaMidiaEmListaMidias(Midia midiaVerificacao, ArrayList<Midia> midias){
        for (Midia midia : midias){
            if (midia.getNome().equals(midiaVerificacao.getNome())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Midia> filtraPorRanking(int quantidadePedida, ArrayList<Midia> midias){
        return new ArrayList<Midia>();
    }

    
    public static void ordenaPorNome(ArrayList<Midia> midias){
    	
    	Collections.sort(midias, new Comparator<Midia>() {
    	        @Override
    	        public int compare(Midia midia2, Midia midia1)
    	        {
    	            return  midia2.getNome().compareTo(midia1.getNome());
    	        }
    	    });
    }

    public static void inverteOrdem(ArrayList<Midia> midias){
        Collections.reverse(midias);
    }

}
