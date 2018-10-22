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
    private final String SEPATADORCSVLISTAEP = "-";
    private final String MENSAGEMARQNAOENCONTRADO = "Arquivo não encontrado.";
    private final String MENSAGEMARQERROEXEC = "Erro durante o processo de leitura do arquivo.";
    private final String IDENTIFICADORSERIE = "S";
    private final String IDENTIFICADORFILME = "F";

    public ProcessadorArquivo(){

    }

    public Catalogo criaCatalogo(String nomeArquivo) {
        Catalogo catalogo = new Catalogo();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                this.novaMidiaCatalogo(line, catalogo);

            }
        } catch (FileNotFoundException noFile){
            System.out.println(MENSAGEMARQNAOENCONTRADO);
        } catch (IOException e){
            System.out.println(MENSAGEMARQERROEXEC);
        }
        return catalogo;
    }

    private void novaMidiaCatalogo (String lineCSV, Catalogo catalogo){
        Midia novaMidia;

        novaMidia = this.createObjectMidia(lineCSV);
        catalogo.adicionaMidia(novaMidia);
    }

    private Midia createObjectMidia(String lineCSV){
        String[] midiaParts;
        midiaParts = lineCSV.split(SEPATADORCSV);

        if (midiaParts[0].equals(IDENTIFICADORSERIE)) {
            ArrayList<Integer> nroEpisodios = new ArrayList<>();

            for (String quantEpidodios : midiaParts[7].split(SEPATADORCSVLISTAEP)){
                nroEpisodios.add(Integer.valueOf(quantEpidodios));
            }

            return new Serie(midiaParts[1], midiaParts[2], Integer.parseInt(midiaParts[3]), midiaParts[4], midiaParts[5], Integer.parseInt(midiaParts[6]), nroEpisodios);
        } else {
            return new Filme(midiaParts[1], midiaParts[2], Integer.parseInt(midiaParts[3]), midiaParts[4], midiaParts[5], Integer.parseInt(midiaParts[6]));
        }
    }

    public void gravaCatalogo(String nomeArquivo) {

    }

}
