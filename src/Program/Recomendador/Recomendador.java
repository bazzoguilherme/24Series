package Program.Recomendador;

import Program.Controle_Midias.Catalogo;
import Program.Filtros.FiltroGeral;
import Program.Filtros.FiltroRepositorio;
import Program.Midias.Midia;
import Program.Midias.Registro;
import Program.ProcessadorEstatistico.ProcessadorEstatistico;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;


public class Recomendador {
    private static final Double NOTAFILTRO = 7.0;
    private static final int QTDEFILTRORANKING = 10;

    public Recomendador(){

    }

//    public ArrayList<Midia> recomendarParaUsuario(ArrayList<Registro> historico, Catalogo catalogo){
//        ArrayList<Midia> midiasCatalogo = this.valuesHashtable(catalogo.getSeries());
//        midiasCatalogo.addAll(this.valuesHashtable(catalogo.getFilmes()));
//
//        FiltroGeral filtroGeral = new FiltroGeral();
//        ArrayList<Midia> naoAssistidas = filtroGeral.filtraPorNaoAssistidas(this.castRegToMidia(historico), midiasCatalogo);
//
//        FiltroRepositorio filtroRepositorio = new FiltroRepositorio();
//        ArrayList<Midia> midiasAnalise = filtroRepositorio.filtraPorNota(NOTAFILTRO, historico);
//        FiltroRepositorio.ordenaPorNota(this.castMidiaToReg(midiasAnalise));
//        midiasAnalise = filtroGeral.filtraPorRanking(QTDEFILTRORANKING, midiasAnalise);
//
//        ArrayList<String> generosPossiveis = this.analisaGenero(this.castRegToMidia(midiasAnalise));
//
//
//    }

    private ArrayList<Midia> castRegToMidia(ArrayList<Registro> registros){
        ArrayList<Midia> midias = new ArrayList<>();
        for(Registro reg : registros){
            midias.add((Midia) reg);
        }
        return midias;
    }

    private ArrayList<Registro> castMidiaToReg(ArrayList<Midia> midias){
        ArrayList<Registro> registros = new ArrayList<>();
        for(Midia midia : midias){
            registros.add((Registro) midia);
        }
        return registros;
    }


    private ArrayList<Midia> valuesHashtable(Hashtable<String, Midia> midias){
        ArrayList<Midia> midiasLista = new ArrayList<>();
        Set<String> keyMidias = midias.keySet();
        for (String key : keyMidias){
            midiasLista.add(midias.get(key));
        }
        return midiasLista;
    }


    public ArrayList<String> analisaGenero(ArrayList<Registro> registros){
        ArrayList<String> contadorGenero = new ArrayList<>();
        ArrayList<String> generosRegistro;
        for (Registro reg : registros){
            generosRegistro = reg.getGenero();

            for (String genReg: generosRegistro){
                contadorGenero.add(genReg);
            }

        }

        return new ProcessadorEstatistico().calculaModa(contadorGenero);
    }

    public ArrayList<String> analisaProdutora(ArrayList<Registro> registros){
        ArrayList<String> contadorProdutora = new ArrayList<>();
        String produtoraRegistro;
        for (Registro reg : registros){
            produtoraRegistro = reg.getProdutora();

            contadorProdutora.add(produtoraRegistro);
        }

        return new ProcessadorEstatistico().calculaModa(contadorProdutora);
    }

    public ArrayList<String> analisaDiretor(ArrayList<Registro> registros){
        ArrayList<String> contadorDiretor = new ArrayList<>();
        String diretorRegistro;
        for (Registro reg : registros){
            diretorRegistro = reg.getDiretor();

            contadorDiretor.add(diretorRegistro);
        }

        return new ProcessadorEstatistico().calculaModa(contadorDiretor);
    }


}
