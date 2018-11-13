package Program.Recomendador;

import Program.Midias.Registro;
import Program.ProcessadorEstatistico.ProcessadorEstatistico;

import java.util.ArrayList;


public class Recomendador {

    public Recomendador(){

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
