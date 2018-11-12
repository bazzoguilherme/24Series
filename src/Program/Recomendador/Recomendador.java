package Program.Recomendador;

import Program.Midias.Registro;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Recomendador {

    public Recomendador(){

    }

    public String analisaGenero(ArrayList<Registro> registros){
        Hashtable<String, Integer> contadorGenero = new Hashtable<>();
        ArrayList<String> generosRegistro;
        for (Registro reg : registros){
            generosRegistro = reg.getGenero();

            for (String genReg: generosRegistro){
                Integer cont = contadorGenero.containsKey(genReg) ? contadorGenero.get(genReg) : 0;
                contadorGenero.put(genReg, cont+1);
            }

        }

        return this.stringMaisRecorrente(contadorGenero);
    }

    public String analisaProdutora(ArrayList<Registro> registros){
        Hashtable<String, Integer> contadorProdutora = new Hashtable<>();
        String produtoraRegistro;
        for (Registro reg : registros){
            produtoraRegistro = reg.getProdutora();

            Integer cont = contadorProdutora.containsKey(produtoraRegistro) ? contadorProdutora.get(produtoraRegistro) : 0;
            contadorProdutora.put(produtoraRegistro, cont+1);
        }

        return this.stringMaisRecorrente(contadorProdutora);
    }

    public String analisaDiretor(ArrayList<Registro> registros){
        Hashtable<String, Integer> contadorDiretor = new Hashtable<>();
        String diretorRegistro;
        for (Registro reg : registros){
            diretorRegistro = reg.getDiretor();

            Integer cont = contadorDiretor.containsKey(diretorRegistro) ? contadorDiretor.get(diretorRegistro) : 0;
            contadorDiretor.put(diretorRegistro, cont+1);
        }

        return this.stringMaisRecorrente(contadorDiretor);
    }

    private String stringMaisRecorrente(Hashtable<String, Integer> contador){
        Set<String> keySet = contador.keySet();
        Integer maiorValor = 0;
        String stringMaisRecorrente = "";
        for(String key : keySet){
            if (contador.get(key) > maiorValor){
                maiorValor = contador.get(key);
                stringMaisRecorrente = key;
            }
        }
        return stringMaisRecorrente;
    }

}
