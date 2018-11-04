package Program.Arquivos;

import Program.Controle_Midias.Catalogo;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Serie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessadorArquivo {
    private final String SEPATADORCSV = ",";
    private final String SEPATADORCSV_SECUNDARIO = "-";
    private final String MENSAGEMARQNAOENCONTRADO = "Arquivo não encontrado.";
    private final String MENSAGEMARQERROEXEC = "Erro durante o processo de leitura do arquivo.";
    private final String IDENTIFICADORSERIE = "S";
    private final String IDENTIFICADORFILME = "F";

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

    public void gravaCatalogo(String nomeArquivo) {

    }

}
