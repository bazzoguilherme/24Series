package Tests.Test_Midias.Test_Midia;

import Program.Midias.Midia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MidiaTestVoid {
    private static Midia midia;

    @BeforeAll
    static void initAll() {
        midia = new Midia();
    }

    @Test
    void getNome() {
        assertEquals("", midia.getNome());
    }

    @Test
    void getGenero() {
        assertTrue(midia.getGenero().isEmpty());
    }

    @Test
    void getDuracao() {
        assertEquals(0, midia.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals("", midia.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals("", midia.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(0, midia.getAno());
    }
}