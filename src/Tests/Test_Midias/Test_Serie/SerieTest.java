package Tests.Test_Midias.Test_Serie;

import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class SerieTest {
    private static Serie serie;
    private static final String NOMETESTE = "Mr. Robot";
    private static final String GENEROTESTE = "Drama";
    private static final int DURACAOTESTE = 65;
    private static final String PRODUTORATESTE = "UCP";
    private static final String DIRETORTESTE = "Sam Esmail";
    private static final int ANOTESTE = 2015;
    private static final String STATUSTESTE = "Finalizada";
    private static final double NOTATESTE = 9.8;
    private static final int EPTESTCERTO = 32;
    private static final int EPTEST = 22;
    private static final int EPTESTMAIS = 45;
    private static final int EPTESTMENOS = -5;
    private static final int EPTEMP1 = 10;
    private static final int EPTEMP2 = 12;
    private static final int EPTEMP3 = 10;


    @BeforeAll
    static void setUpClass(){
        ArrayList<Integer> episodiosTempTeste = new ArrayList<>();
        episodiosTempTeste.add(EPTEMP1);
        episodiosTempTeste.add(EPTEMP2);
        episodiosTempTeste.add(EPTEMP3);
        serie = new Serie(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE, episodiosTempTeste);
    }

    @Test
    @Disabled
    void getNroEpisodios() {
    }

    @Test
    void setNroEpisodiosAssistidos() {
        serie.setNroEpisodiosAssistidos(EPTEST);
        assertEquals(EPTEST, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void setNroEpisodiosAssistidosMais() {
        serie.setNroEpisodiosAssistidos(EPTESTMAIS);
        assertEquals(EPTESTCERTO, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void setNroEpisodiosAssistidosMenos() {
        serie.setNroEpisodiosAssistidos(EPTESTMENOS);
        assertEquals(0, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void quantidadeTotalEpisodios() {
        assertEquals(EPTESTCERTO, serie.quantidadeTotalEpisodios());
    }

    @Test
    void getNome() {
        assertEquals(NOMETESTE, serie.getNome());
    }

    @Test
    void getGenero() {
        assertEquals(GENEROTESTE, serie.getGenero());
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAOTESTE, serie.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals(PRODUTORATESTE, serie.getProdutora());
    }

    @Test
    void getDiretor() { assertEquals(DIRETORTESTE, serie.getDiretor()); }

    @Test
    void getAno() {
        assertEquals(ANOTESTE, serie.getAno());
    }

    @Test
    void setNota(){
        serie.setNota(NOTATESTE);
        assertEquals(NOTATESTE, serie.getNota());
    }

    @Test
    void setStatus(){
        serie.setStatus(STATUSTESTE);
        assertEquals(STATUSTESTE, serie.getStatus());
    }
}