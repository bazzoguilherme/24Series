package Tests.Test_Midias.Test_Filme;

import Program.Midias.Filme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmeTestVoid {
    private static Filme filme;

    @BeforeAll
    static void setUpClass(){
        filme = new Filme();
    }

    @Test
    void getNome() {
        assertEquals("", filme.getNome());
    }

    @Test
    void getGenero() {
        assertEquals("", filme.getGenero());
    }

    @Test
    void getDuracao() {
        assertEquals(0, filme.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals("", filme.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals("", filme.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(0, filme.getAno());
    }

    @Test
    void getNota() {
        assertEquals(0.0, filme.getNota());
    }

    @Test
    void getStatus() {
        assertEquals("Planejo Assistir", filme.getStatus());
    }


}