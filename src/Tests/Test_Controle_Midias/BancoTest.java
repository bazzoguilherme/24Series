package Tests.Test_Controle_Midias;

import Program.Controle_Midias.Banco;
import Program.Midias.Serie;
import Program.Midias.Filme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {
    private Banco banco;
    private static final String NOMETESTE = "Mr. Robot";
    private static final String GENEROTESTE = "Drama";
    private static final int DURACAOTESTE = 65;
    private static final String PRODUTORATESTE = "UCP";
    private static final String DIRETORTESTE = "Sam Esmail";
    private static final int ANOTESTE = 2015;

    @BeforeEach
    void setUpClass(){
        banco = new Banco();
    }

    @Test
    void getSeriesVoid() {
        assertTrue(banco.getSeries().isEmpty());
    }

    @Test
    void getFilmesVoid() {
        assertTrue(banco.getFilmes().isEmpty());
    }

    @Test
    void getSeries(){
        banco.adicionaMidia(new Serie());
        assertFalse(banco.getSeries().isEmpty());
        assertEquals(1, banco.getSeries().size());
    }

    @Test
    void getFilmes(){
        banco.adicionaMidia(new Filme());
        assertFalse(banco.getFilmes().isEmpty());
    }

    @Test
    void adicionaSerie() {
        banco.adicionaMidia(new Serie(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE, new ArrayList<>()));
        assertFalse(banco.getSeries().isEmpty());
        assertEquals(1, banco.getSeries().size());
    }

    @Test
    void adicionaFilme() {
        banco.adicionaMidia(new Filme(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE));
        assertFalse(banco.getFilmes().isEmpty());
        assertEquals(1, banco.getFilmes().size());
    }

    @Test
    void selecionaSerie() {
        Serie serie = new Serie(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE, new ArrayList<>());
        banco.adicionaMidia(serie);
        assertEquals(serie, banco.selecionaSerie(NOMETESTE));
        assertTrue(banco.selecionaSerie(NOMETESTE) instanceof Serie);
    }

    @Test
    void selecionaFilme() {
        Filme filme = new Filme(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE);
        banco.adicionaMidia(filme);
        assertEquals(filme, banco.selecionaFilme(NOMETESTE));
        assertTrue(banco.selecionaFilme(NOMETESTE) instanceof Filme);
    }

    @Test
    void removeSerie() {
        banco.adicionaMidia(new Serie(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE, new ArrayList<>()));
        assertEquals(1, banco.getSeries().size());
        banco.removeSerie(NOMETESTE);
        assertEquals(0, banco.getSeries().size());
    }

    @Test
    void removeFilme() {
        banco.adicionaMidia(new Filme(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE));
        assertEquals(1, banco.getFilmes().size());
        banco.removeFilme(NOMETESTE);
        assertEquals(0, banco.getFilmes().size());
    }
}