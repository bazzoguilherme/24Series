package Tests.Test_Midias.Test_Registro;

import Program.Midias.Registro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;

class RegistroTestOperations {
    private static Registro registro;
    private static ArrayList<String> generosSerie;
    private static final double NOTATESTE = 9.8;
    private static final double NOTAPADRAO = 0.0;
    private static final String STATUSTESTE = "Assistindo";
    private static final String STATUSPADRAO = "Planejo Assistir";

    @BeforeAll
    static void setUpClass(){
        generosSerie = new ArrayList<>();
        generosSerie.add(GENERO_SERIE1_1);
        generosSerie.add(GENERO_SERIE1_2);
        registro = new Registro(NOME_SERIE1, generosSerie, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1);
    }

    @BeforeEach
    void init(){
        registro.setNota(NOTAPADRAO);
        registro.setStatus(STATUSPADRAO);
    }

    @Test
    void getNota() {
        assertEquals(NOTAPADRAO, registro.getNota());
    }

    @Test
    void getStatus() {
        assertEquals(STATUSPADRAO, registro.getStatus());
    }

    @Test
    void setNota() {
        registro.setNota(NOTATESTE);
        assertEquals(NOTATESTE, registro.getNota());
    }

    @Test
    void setStatus() {
        registro.setStatus(STATUSTESTE);
        assertEquals(STATUSTESTE, registro.getStatus());
    }

}