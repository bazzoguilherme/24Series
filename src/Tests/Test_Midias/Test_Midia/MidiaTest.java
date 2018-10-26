package Tests.Test_Midias.Test_Midia;

import Program.Midias.Midia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;

class MidiaTest {
    private static Midia midia;

    @BeforeAll
    static void initAll(){
        midia = new Midia(NOME_SERIE1, GENERO_SERIE01, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1);
    }

    @Test
    void getNome() {
        assertEquals(NOME_SERIE1, midia.getNome());
    }

    @Test
    void getGenero() {
        assertEquals(GENERO_SERIE01, midia.getGenero());
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAO_SERIE1, midia.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals(PRODUTORA_SERIE1, midia.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals(DIRETOR_SERIE1, midia.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(ANO_SERIE1, midia.getAno());
    }
}