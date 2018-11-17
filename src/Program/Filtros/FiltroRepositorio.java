package Program.Filtros;

import Program.Midias.Midia;
import Program.Midias.Registro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FiltroRepositorio extends FiltroGeral{

    public FiltroRepositorio(){
        super();
    }


    public ArrayList<Registro> filtraPorNota(double nota, ArrayList<Registro> registros){
        ArrayList<Registro> registrosNota = new ArrayList<>();
        for (Registro registro : registros){
            if(registro.getNota() >= nota){
                registrosNota.add(registro);
            }
        }
        return registrosNota;
    }
    
    public ArrayList<Registro> filtraPorNotaIgual(double nota, ArrayList<Registro> registros){
        ArrayList<Registro> registrosNota = new ArrayList<>();
        for (Registro registro : registros){
            if(registro.getNota() == nota){
                registrosNota.add(registro);
            }
        }
        return registrosNota;
    }
    
    public ArrayList<Registro> filtraPorStatus(String status, ArrayList<Registro> registros){
        ArrayList<Registro> registrosStatus = new ArrayList<>();
        for (Registro registro : registros){
            if(registro.getStatus().equals(status)){
                registrosStatus.add(registro);
            }
        }
        return registrosStatus;
    }

    public static void ordenaPorNota(ArrayList<Registro> registros){
        Collections.sort(registros, new Comparator<Registro>() {
            @Override
            public int compare(Registro reg1, Registro reg2)
            {
                return reg2.getNota() < reg1.getNota() ? -1 : reg2.getNota() == reg1.getNota() ? 0 : 1;
            }
        });
    }

    public static void ordenaPorStatus(ArrayList<Registro> registros){
        Collections.sort(registros, new Comparator<Registro>() {
            @Override
            public int compare(Registro reg1, Registro reg2)
            {
                return  reg1.getStatus().compareTo(reg2.getStatus());
            }
        });
    }

    public ArrayList<Registro> filtraPorRelevancia(ArrayList<Registro> registros){
        return new ArrayList<>();
    }


}
