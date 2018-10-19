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

                this.novoObjetoCatalogo(line, catalogo);

            }
        } catch (FileNotFoundException noFile){
            System.out.println(MENSAGEMARQNAOENCONTRADO);
        } catch (IOException e){
            System.out.println(MENSAGEMARQERROEXEC);
        }
        return catalogo;
    }

    private void novoObjetoCatalogo (String lineCsv, Catalogo catalogo){
        Midia novaMidia;
        String[] midiaParts;

        midiaParts = lineCsv.split(SEPATADORCSV);
        novaMidia = createObjectMidia(midiaParts);
        catalogo.adicionaMidia(novaMidia);
    }

    public void gravaCatalogo(String nomeArquivo) {

    }

    private Midia createObjectMidia(String[] midiaParts){
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

}
