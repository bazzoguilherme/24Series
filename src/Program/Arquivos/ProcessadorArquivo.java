package Program.Arquivos;

import Program.Controle_Midias.Catalogo;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Serie;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class ProcessadorArquivo {
    private final String SEPATADORCSV = ",";
    private final String SEPATADORCSV_SECUNDARIO = "-";
    private final String MENSAGEMARQNAOENCONTRADO = "Arquivo não encontrado.";
    private final String MENSAGEMARQERROEXEC = "Erro durante o processo de leitura do arquivo.";
    private final String IDENTIFICADORSERIE = "S";
    private final String IDENTIFICADORFILME = "F";
    private final String CABECALHOCSV = "Tipo,Nome,Genero,Duracao,Produtora,Diretor,Ano,EpisodiosTemporada\n";

    public ProcessadorArquivo(){

    }

    public Catalogo criaCatalogo(String nomeArquivo) {
        Catalogo catalogo = new Catalogo();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linhaCSV;
            br.readLine();
            while ((linhaCSV = br.readLine()) != null) {

                this.novaMidiaCatalogo(linhaCSV, catalogo);

            }
        } catch (FileNotFoundException noFile){
            System.out.println(MENSAGEMARQNAOENCONTRADO);
        } catch (IOException e){
            System.out.println(MENSAGEMARQERROEXEC);
        }
        return catalogo;
    }

    private void novaMidiaCatalogo (String linhaCSV, Catalogo catalogo){
        Midia novaMidia;

        novaMidia = this.createObjectMidia(linhaCSV);
        catalogo.adicionaMidia(novaMidia, linhaCSV.charAt(0));
    }

    private Midia createObjectMidia(String linhaCSV){
        String[] midiaParts;
        midiaParts = linhaCSV.split(SEPATADORCSV);

        return new Midia(midiaParts[1], criaListaString(midiaParts[2]), Integer.parseInt(midiaParts[3]), midiaParts[4], midiaParts[5], Integer.parseInt(midiaParts[6]), criaListaInteger(midiaParts[7]));

    }

    private ArrayList<String> criaListaString(String linhaCSV){
        ArrayList<String> generosMidia = new ArrayList<>();
        for (String genero : linhaCSV.split(SEPATADORCSV_SECUNDARIO)){
            generosMidia.add(genero);
        }
        return generosMidia;
    }

    private ArrayList<Integer> criaListaInteger(String linhaCSV){
        ArrayList<Integer> episodiosSerie = new ArrayList<>();
        for (String quantEpidodios : linhaCSV.split(SEPATADORCSV_SECUNDARIO)){
            episodiosSerie.add(Integer.valueOf(quantEpidodios));
        }
        return episodiosSerie;
    }

    public void gravaCatalogo(String nomeArquivo, Catalogo catalogo) {
        try {
            PrintWriter file = new PrintWriter(new File(nomeArquivo));
            StringBuilder stringBuilder = new StringBuilder();

            ArrayList<Midia> midias = this.valuesHashtable(catalogo.getSeries());
            midias.addAll(this.valuesHashtable(catalogo.getFilmes()));

            int quantSeries = catalogo.getSeries().size();
            int cont = 1;

            stringBuilder.append(CABECALHOCSV);

            for (Midia midia : midias){
                if(cont>quantSeries){       // Como as series são inseridas antes que os filmes no array, sabendo o numero de series e' possivel
                                            // saber quando preciso colocar "qual" identificador do tipo de Midia
                    stringBuilder.append(IDENTIFICADORFILME+",");
                } else {
                    stringBuilder.append(IDENTIFICADORSERIE+",");
                    cont++;
                }

                stringBuilder.append(midia.toArq());
                stringBuilder.append('\n');
            }

//            System.out.println(stringBuilder.toString());
            file.write(stringBuilder.toString());
            file.close();
        } catch (FileNotFoundException e){
            System.out.println(MENSAGEMARQNAOENCONTRADO);
        }
    }

    private ArrayList<Midia> valuesHashtable(Hashtable<String, Midia> midias){
        ArrayList<Midia> midiasLista = new ArrayList<>();
        Set<String> keyMidias = midias.keySet();
        for (String key : keyMidias){
            midiasLista.add(midias.get(key));
        }
        return midiasLista;
    }

}
