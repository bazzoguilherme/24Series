package Tests.Test_Filtros;

import Program.Filtros.FiltroRepositorio;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Registro;
import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FiltroRepositorioTest {
    private static FiltroRepositorio filtroRepositorio;
    private ArrayList<Registro> registros;
    private static Serie serie1;
    private static Serie serie2;
    private static Filme filme1;
    private static Filme filme2;
    public static final String ASSISTINDO = "Assistindo";
    public static final String REASSISTINDO = "Reassistindo";
    public static final Double NOTA1 = 8.9;
    public static final Double NOTA2 = 9.2;
    public static final Double NOTA3 = 9.0;
    public static final Double NOTA4 = 9.0;


    @BeforeAll
    static void setUpClass(){
        filtroRepositorio = new FiltroRepositorio();
        serie1 = new Serie();
        serie1.setStatus(ASSISTINDO);
        serie1.setNota(NOTA1);
        serie2 = new Serie();
        serie2.setStatus(ASSISTINDO);
        serie2.setNota(NOTA2);
        filme1 = new Filme();
        filme1.setStatus(REASSISTINDO);
        filme1.setNota(NOTA3);
        filme2 = new Filme();
        filme2.setStatus(ASSISTINDO);
        filme2.setNota(NOTA4);
    }

    @BeforeEach
    void setUp(){
        registros = new ArrayList<>();
        registros.add(serie1);
        registros.add(serie2);
        registros.add(filme1);
        registros.add(filme2);
    }


    @Test
    void filtraPorNota() {
        ArrayList<Registro> regNotas = filtroRepositorio.filtraPorNota(NOTA3, registros);
        assertEquals(3, regNotas.size());
    }

    @Test
    void filtraPorStatus() {
        ArrayList<Registro> regStatus = filtroRepositorio.filtraPorStatus(ASSISTINDO, registros);
        assertEquals(3, regStatus.size());
    }

    @Test
    void ordenaPorNota() {
        FiltroRepositorio.ordenaPorNota(registros);
        for(int i=0; i < registros.size()-1; i++) {
            if(registros.get(i).getNota() < registros.get(i+1).getNota()) { // verifica se a nota de algum dos elemtos é menor que a do proximo (falha na ordenacao)
                fail("fail message");
            }
        }
        assertTrue(true);
    }

    @Test
    void ordenaPorStatus() {
        boolean ordenado = true;
        FiltroRepositorio.ordenaPorStatus(registros);
        for(int i=0; i < registros.size()-1; i++) {
            if(registros.get(i).getStatus().compareTo(registros.get(i+1).getStatus()) > 0) {
                ordenado = false;
            }
        }
        assertTrue(ordenado);
    }
}