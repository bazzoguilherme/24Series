package Tests.Test_Midias.Test_Registro;

import Program.Midias.Registro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {
    private static Registro registro;
    private static ArrayList<String> generosSerie;
    private static final String STATUSPADRAO = "Planejo Assistir";

    @BeforeAll
    static void initAll(){
        generosSerie = new ArrayList<>();
        generosSerie.add(GENERO_SERIE1_1);
        generosSerie.add(GENERO_SERIE1_2);
        registro = new Registro(NOME_SERIE1, generosSerie, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1);
    }

    @Test
    void getNota() {
        assertEquals(0.0, registro.getNota());
    }

    @Test
    void getStatus() {
        assertEquals(STATUSPADRAO, registro.getStatus());
    }

    @Test
    void getNome() {
        assertEquals(NOME_SERIE1, registro.getNome());
    }

    @Test
    void getGenero() {
        ArrayList<String> generosTeste;
        generosTeste = registro.getGenero();
        assertEquals(GENERO_SERIE1_1, generosTeste.get(0));
        assertEquals(GENERO_SERIE1_2, generosTeste.get(1));
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAO_SERIE1, registro.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals(PRODUTORA_SERIE1, registro.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals(DIRETOR_SERIE1, registro.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(ANO_SERIE1, registro.getAno());
    }

    @Test
    @Disabled
    void retornaPossiveisStatus() {
    }
}