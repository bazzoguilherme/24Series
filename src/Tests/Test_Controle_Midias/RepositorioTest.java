package Tests.Test_Controle_Midias;

import Program.Controle_Midias.Colecao;
import Program.Controle_Midias.Repositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioTest {
    private static Repositorio repositorio;
    private static Colecao colecao;
    private static final String NOMECOLECAO = "Favoritos";

    @BeforeAll
    static void setUpClass(){
        repositorio = new Repositorio();
        colecao = new Colecao(NOMECOLECAO);
    }

    @Test
    void getColecoes() {
        assertTrue(repositorio.getColecoes().isEmpty());
    }

    @Test
    void adicionaColecao() {
        repositorio.adicionaColecao(colecao);
        assertFalse(repositorio.getColecoes().isEmpty());
        repositorio.removeColecao(colecao.getNome());
    }

    @Test
    void removeColecao() {
        repositorio.adicionaColecao(colecao);
        assertFalse(repositorio.getColecoes().isEmpty());
        repositorio.removeColecao(colecao.getNome());
        assertTrue(repositorio.getColecoes().isEmpty());
    }

    @Test
    void selecionaColecao() {
        repositorio.adicionaColecao(colecao);
        assertFalse(repositorio.getColecoes().isEmpty());
        assertEquals(NOMECOLECAO, repositorio.selecionaColecao(NOMECOLECAO).getNome());
        repositorio.removeColecao(colecao.getNome());
    }
}