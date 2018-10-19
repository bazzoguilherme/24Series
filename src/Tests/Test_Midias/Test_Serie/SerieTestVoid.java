package Tests.Test_Midias.Test_Serie;

import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerieTestVoid {
    private static Serie serie;
    private static final int EPTESTCERTO = 0;
    private static final int EPTESTMAIS = 2;
    private static final int EPTESTMENOS = -5;

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
        serie.setNroEpisodiosAssistidos(EPTESTMAIS);
        assertEquals(EPTESTCERTO, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void setNroEpisodiosAssistidosMenos() {
        serie.setNroEpisodiosAssistidos(EPTESTMENOS);
        assertEquals(EPTESTCERTO, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void quantidadeTotalEpisodios(){
        assertEquals(0, serie.quantidadeTotalEpisodios());
    }

    @Test
    void getNome() {
        assertEquals("", serie.getNome());
    }

    @Test
    void getGenero() {
        assertEquals("", serie.getGenero());
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