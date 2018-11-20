package Program.Filtros;

import Program.Midias.Registro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * <h1>Filtra registros</h1>
 * Esta classe apresenta metodos que realizam filtros sobre os atributos de Registro.
 * 
 * @author Guilherme Bazzo
 * @author Guilherme Malta
 * @author Nicolas Duranti
 *
 * @see Registro
 * @see FiltroRepositorioTest
 */
public class FiltroRepositorio extends FiltroGeral{

    public FiltroRepositorio(){
        super();
    }

    /**
     * Este metodo recebe uma serie de registros e seleciona os que possuem uma nota 
     * maior ou igual que uma determinada nota.
     * 
     * @param nota			Nota utilizada como referencia para selecionar os registros
     * @param registros		Lista de registros a serem filtrados 
     * @return				A lista dos regitros selecionados (com nota maior ou igual a nota)
     */
    public ArrayList<Registro> filtraPorNota(double nota, ArrayList<Registro> registros){
        ArrayList<Registro> registrosNota = new ArrayList<>();
        for (Registro registro : registros){
            if(registro.getNota() >= nota){
                registrosNota.add(registro);
            }
        }
        return registrosNota;
    }
    
    /**
     * Este metodo recebe uma serie de registros e seleciona os que possuem uma nota 
     * extamente igual a uma determinada nota.
     * 
     * @param nota			Nota utilizada como referencia para selecionar os registros
     * @param registros		Lista de registros a serem filtrados 
     * @return				A lista dos regitros selecionados (com nota igual a nota)
     */
    public ArrayList<Registro> filtraPorNotaIgual(double nota, ArrayList<Registro> registros){
        ArrayList<Registro> registrosNota = new ArrayList<>();
        for (Registro registro : registros){
            if(registro.getNota() == nota){
                registrosNota.add(registro);
            }
        }
        return registrosNota;
    }
    
    /**
     * Este metodo recebe uma serie de registros e seleciona os que pussuem status igual a um determinado status
     * 
     * @param status		Status utilizado como referencia para selecionar os registros
     * @param registros		Lista de registros a serem filtrados
     * @return				A lista dos registros selecionados (com status igual ao parametro status)
     */
    public ArrayList<Registro> filtraPorStatus(String status, ArrayList<Registro> registros){
        ArrayList<Registro> registrosStatus = new ArrayList<>();
        for (Registro registro : registros){
            if(registro.getStatus().equals(status)){
                registrosStatus.add(registro);
            }
        }
        return registrosStatus;
    }

    /**
     * Ordena uma lista de registros tendo como criterio de ordenacao sua nota.
     * A lista reorganizada fica em ordem decrescente, isto eh, o indice 0 possui
     * o registro de maior nota.
     * 
     * @param registros		Lista de registros a serem ordenados
     */
    public static void ordenaPorNota(ArrayList<Registro> registros){
        Collections.sort(registros, new Comparator<Registro>() {
            @Override
            public int compare(Registro reg1, Registro reg2)
            {
                return reg2.getNota() < reg1.getNota() ? -1 : reg2.getNota() == reg1.getNota() ? 0 : 1;
            }
        });
    }

    /**
     * Ordena uma lista de registros tendo como criterio de ordenacao seu status.
     * Assim, realiza a ordenacao de acorco com a ordem alfabetica
     * 
     * @param registros		Lista de registros a serem ordenados
     */
    public static void ordenaPorStatus(ArrayList<Registro> registros){
        Collections.sort(registros, new Comparator<Registro>() {
            @Override
            public int compare(Registro reg1, Registro reg2)
            {
                return  reg1.getStatus().compareTo(reg2.getStatus());
            }
        });
    }
}
