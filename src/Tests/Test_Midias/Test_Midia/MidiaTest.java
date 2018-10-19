package Tests.Test_Midias.Test_Midia;

import Program.Midias.Midia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MidiaTest {
    private static Midia midia;
    private static final int DURACAOMIDIA = 65;

    @BeforeAll
    static void initAll(){
        midia = new Midia("Mr. Robot", "Drama", DURACAOMIDIA, "UCP", "Sam Esmail", 2015);
    }

    @Test
    void getNome() {
        assertEquals("Mr. Robot", midia.getNome());
    }

    @Test
    void getGenero() {
        assertEquals("Drama", midia.getGenero());
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAOMIDIA, midia.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals("UCP", midia.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals("Sam Esmail", midia.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(2015, midia.getAno());
    }
}