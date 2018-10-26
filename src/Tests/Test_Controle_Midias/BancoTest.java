package Tests.Test_Controle_Midias;

import Program.Controle_Midias.Banco;
import Program.Midias.Serie;
import Program.Midias.Filme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Tests.Constantes.Constantes_Series.*;
import static Tests.Constantes.Constantes_Filmes.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {
    private Banco banco;
    private Serie serieTeste = new Serie(NOME_SERIE1, GENERO_SERIE01, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, new ArrayList<>());
    private Filme filmeTeste = new Filme(NOME_FILME1, GENERO_FILME01, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1);

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
        banco.adicionaMidia(serieTeste);
        assertFalse(banco.getSeries().isEmpty());
        assertEquals(1, banco.getSeries().size());
    }

    @Test
    void adicionaFilme() {
        banco.adicionaMidia(filmeTeste);
        assertFalse(banco.getFilmes().isEmpty());
        assertEquals(1, banco.getFilmes().size());
    }

    @Test
    void selecionaSerie() {
        banco.adicionaMidia(serieTeste);
        assertEquals(serieTeste, banco.selecionaSerie(NOME_SERIE1));
        assertTrue(banco.selecionaSerie(NOME_SERIE1) instanceof Serie);
    }

    @Test
    void selecionaFilme() {
        banco.adicionaMidia(filmeTeste);
        assertEquals(filmeTeste, banco.selecionaFilme(NOME_FILME1));
        assertTrue(banco.selecionaFilme(NOME_FILME1) instanceof Filme);
    }

    @Test
    void removeSerie() {
        banco.adicionaMidia(serieTeste);
        assertEquals(1, banco.getSeries().size());
        banco.removeSerie(NOME_SERIE1);
        assertEquals(0, banco.getSeries().size());
    }

    @Test
    void removeFilme() {
        banco.adicionaMidia(filmeTeste);
        assertEquals(1, banco.getFilmes().size());
        banco.removeFilme(NOME_FILME1);
        assertEquals(0, banco.getFilmes().size());
    }
}