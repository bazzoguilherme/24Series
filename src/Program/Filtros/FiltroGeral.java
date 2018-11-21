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
            // Concatena o resultado ao analisar os filmes com o que ja existia para series

        return midiaComNome;
    }

    public ArrayList<Midia> buscaMidiaPorNome(String nome, Hashtable<String, Midia> midiaMap){
        ArrayList<Midia> midiaComNome = new ArrayList<>();
        Set<String> chaveMidias = midiaMap.keySet();

        for (String nomeMidia : chaveMidias){
            if(nomeMidia.toLowerCase().contains(nome.toLowerCase())){
                midiaComNome.add(midiaMap.get(nomeMidia));
            }
        }

        return midiaComNome;
    }

    public ArrayList<Midia> filtraPorNome(String nome, ArrayList<? extends Midia> midias){
        ArrayList<Midia> midiasNome = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (midiaInteracao.getNome().toLowerCase().equals(nome.toLowerCase())){
                midiasNome.add(midiaInteracao);
            }
        }

        return midiasNome;
    }

    public ArrayList<Midia> filtraPorGenero(String genero, ArrayList<? extends Midia> midias){
        ArrayList<Midia> midiasGenero = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (this.verificaGeneroEmListaGeneros(midiaInteracao.getGenero(), genero)){
                midiasGenero.add(midiaInteracao);
            }
        }

        return midiasGenero;
    }

    public ArrayList<Midia> filtraPorGenero(ArrayList<String> generos, ArrayList<? extends Midia> midias){
        ArrayList<Midia> midiasGenero = new ArrayList<>();
        ArrayList<Midia> arraySecundario;

        for (String genero : generos){
            arraySecundario = this.filtraPorGenero(genero, midias);
            this.uniaoArrayMidia(midiasGenero, arraySecundario);
        }

        return midiasGenero;
    }

    public void uniaoArrayMidia(ArrayList<Midia> lista1, ArrayList<Midia> lista2){
        for(Midia midia : lista2){
            if (!this.verificaMidiaEmListaMidias(midia, lista1)){
                lista1.add(midia);
            }
        }
    }

    private boolean verificaGeneroEmListaGeneros(ArrayList<String> generosMidia, String generoFiltro){
        for (String genero : generosMidia){
            if(genero.toLowerCase().equals(generoFiltro.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Midia> filtraPorProdutora(String produtora, ArrayList<? extends Midia> midias){
        ArrayList<Midia> midiasProdutora = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (midiaInteracao.getProdutora().toLowerCase().equals(produtora.toLowerCase())){
                midiasProdutora.add(midiaInteracao);
            }
        }

        return midiasProdutora;
    }

    public ArrayList<Midia> filtraPorDiretor(String diretor, ArrayList<? extends Midia> midias){
        ArrayList<Midia> midiasDiretor = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (midiaInteracao.getDiretor().toLowerCase().equals(diretor.toLowerCase())){
                midiasDiretor.add(midiaInteracao);
            }
        }

        return midiasDiretor;
    }

    public ArrayList<Midia> filtraPorAno(int ano, ArrayList<? extends Midia> midias){
        ArrayList<Midia> midiasAno = new ArrayList<>();

        for (Midia midiaInteracao : midias){
            if (midiaInteracao.getAno() == ano){
                midiasAno.add(midiaInteracao);
            }
        }

        return midiasAno;
    }

    public ArrayList<Midia> filtraPorDuracao(int duracao, ArrayList<? extends Midia> midias){
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

    public <T> ArrayList<T> filtraPorRanking(int quantidadePedida, ArrayList<T> midias){
        if (midias == null || quantidadePedida<0){
            return null;
        } else if (midias.size() < quantidadePedida){
            return midias;
        }else{
            ArrayList<T> midiasRanking = new ArrayList<>();

            for (int i=0; i<quantidadePedida; i++){
                midiasRanking.add(midias.get(i));
            }

            return midiasRanking;
        }
    }
    
    public static void ordenaPorNome(ArrayList<? extends Midia> midias){
    	
    	Collections.sort(midias, new Comparator<Midia>() {
    	        @Override
    	        public int compare(Midia midia2, Midia midia1)
    	        {
    	            return  midia2.getNome().compareTo(midia1.getNome());
    	        }
    	    });
    }

    public static void inverteOrdem(ArrayList<? extends Midia> midias){
        Collections.reverse(midias);
    }

}
