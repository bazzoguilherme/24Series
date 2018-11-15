package Tests.Test_Midias.Test_Serie;

import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerieTestVoid {
    private static Serie serie;
    private static final int EP_TESTCERTO = 0;
    private static final int EP_TESTMAIS = 2;
    private static final int EP_TESTMENOS = -5;

    @BeforeAll
    static void setUpClass(){
        serie = new Serie();
    }

    @Test
    void getNroEpisodiosAssistidos() {
        assertEquals(0, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void setNroEpisodiosAssistidosMais() {
        serie.setNroEpisodiosAssistidos(EP_TESTMAIS);
        assertEquals(EP_TESTCERTO, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void setNroEpisodiosAssistidosMenos() {
        serie.setNroEpisodiosAssistidos(EP_TESTMENOS);
        assertEquals(EP_TESTCERTO, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void getNome() {
        assertEquals("", serie.getNome());
    }

    @Test
    void getGenero() {
        assertTrue(serie.getGenero().isEmpty());
    }

    @Test
    void getDuracao() {
        assertEquals(0, serie.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals("", serie.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals("", serie.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(0, serie.getAno());
    }

}