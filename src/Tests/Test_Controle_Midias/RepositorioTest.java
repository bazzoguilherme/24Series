package Tests.Test_Controle_Midias;

import Program.Controle_Midias.Colecao;
import Program.Controle_Midias.Repositorio;
import static Tests.Constantes.Constantes_Series.*;
import static Tests.Constantes.Constantes_Filmes.*;
import Program.Midias.Serie;
import Program.Midias.Filme;
import static Program.Midias.Filme.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class RepositorioTest {
    private static Repositorio repositorio;
    private static Colecao colecao;
    private static final String NOMECOLECAO = "Favoritos";
    private static final String NOMEINEXISTENTE = "Inexistente";
    private static Filme filme1; 
    private static ArrayList<String> generosFilme;
    private static ArrayList<Integer> nroEpsFilme;
    private static Serie serie1;
    private static ArrayList<String> generosSerie;
    private static ArrayList<Integer> nroEpsSerie;

    @BeforeAll
    static void setUpClass(){
        repositorio = new Repositorio();
        colecao = new Colecao(NOMECOLECAO);
        
        generosFilme = new ArrayList<>();
        generosFilme.add(GENERO_FILME1_1);
        nroEpsFilme = new ArrayList<>();
        nroEpsFilme.add(EPS_FILMES);    
        filme1 = new Filme(NOME_FILME1, generosFilme, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, nroEpsFilme);
    
        nroEpsSerie = new ArrayList<>();
        nroEpsSerie.add(EP_SERIE1_TEMP1);
        generosSerie = new ArrayList<>();
        generosSerie.add(GENERO_SERIE1_1);
        serie1 = new Serie(NOME_SERIE1, generosSerie, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, nroEpsSerie);
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
    
    @Test
    void selecionaRegistroNomeVazio() {
    	assertNull(repositorio.selecionaRegistro(""));    	
    }
    
    @Test
    void selecionaRegistroInexistente() {
    	assertNull(repositorio.selecionaRegistro(NOMEINEXISTENTE));    	
    }
    
    @Test
    void selecionaRegistroFilme() {
    	repositorio.adicionaFilme(filme1);
    	assertEquals(filme1, repositorio.selecionaRegistro(filme1.getNome()));
    }
    
    @Test
    void selecionaRegistroSerie() {
    	repositorio.adicionaSerie(serie1);
    	assertEquals(serie1, repositorio.selecionaRegistro(serie1.getNome()));
    }
}