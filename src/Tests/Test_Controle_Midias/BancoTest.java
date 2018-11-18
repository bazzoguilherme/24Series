package Tests.Test_Controle_Midias;

import Program.Controle_Midias.Banco;
import Program.Controle_Midias.Catalogo;
import Program.Midias.Midia;
import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Tests.Constantes.Constantes_Series.*;
import static Tests.Constantes.Constantes_Filmes.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {
    private Banco banco;
    private static ArrayList<String> generosSerie;
    private static ArrayList<String> generosFilme;
    private static Midia serieTeste;
    private static Midia filmeTeste;


    @BeforeAll
    static void setUpClass(){
        generosSerie = new ArrayList<>();
        generosSerie.add(GENERO_SERIE1_1);
        generosSerie.add(GENERO_SERIE1_2);

        generosFilme = new ArrayList<>();
        generosFilme.add(GENERO_FILME1_1);
        generosFilme.add(GENERO_FILME1_2);

        serieTeste = new Midia(NOME_SERIE1, generosSerie, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, new ArrayList<>());
        filmeTeste = new Midia(NOME_FILME1, generosFilme, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, new ArrayList<>());
    }


    @BeforeEach
    void setUp(){
        banco = new Catalogo();
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
        banco.adicionaMidia(new Serie(), IDENTIFICADOR_SERIE);
        assertFalse(banco.getSeries().isEmpty());
        assertEquals(1, banco.getSeries().size());
    }

    @Test
    void getFilmes(){
        banco.adicionaMidia(new Midia(), IDENTIFICADOR_FILME);
        assertFalse(banco.getFilmes().isEmpty());
    }

    @Test
    void adicionaSerie() {
        banco.adicionaMidia(serieTeste, IDENTIFICADOR_SERIE);
        assertFalse(banco.getSeries().isEmpty());
        assertEquals(1, banco.getSeries().size());
    }

    @Test
    void adicionaFilme() {
        banco.adicionaMidia(filmeTeste, IDENTIFICADOR_FILME);
        assertFalse(banco.getFilmes().isEmpty());
        assertEquals(1, banco.getFilmes().size());
    }

    @Test
    void selecionaSerie() {
        banco.adicionaMidia(serieTeste, IDENTIFICADOR_SERIE);
        assertEquals(serieTeste, banco.selecionaSerie(NOME_SERIE1));
    }

    @Test
    void selecionaFilme() {
        banco.adicionaMidia(filmeTeste, IDENTIFICADOR_FILME);
        assertEquals(filmeTeste, banco.selecionaFilme(NOME_FILME1));
    }

    @Test
    void removeSerie() {
        banco.adicionaMidia(serieTeste, IDENTIFICADOR_SERIE);
        assertEquals(1, banco.getSeries().size());
        banco.removeSerie(NOME_SERIE1);
        assertEquals(0, banco.getSeries().size());
    }

    @Test
    void removeFilme() {
        banco.adicionaMidia(filmeTeste, IDENTIFICADOR_FILME);
        assertEquals(1, banco.getFilmes().size());
        banco.removeFilme(NOME_FILME1);
        assertEquals(0, banco.getFilmes().size());
    }
}