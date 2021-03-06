package Tests.Test_Midias.Test_Filme;

import Program.Midias.Filme;
import static Program.Midias.Filme.*; 
import static Tests.Constantes.Constantes_Filmes.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


class FilmeTest {
    private static Filme filme;
    private static ArrayList<String> generosFilme;
    private static ArrayList<Integer> nroEpsFilme;
    private static final int TAM_GENEROS = 2;
    private static final String STATUSTESTE = "Finalizada";
    private static final double NOTATESTE = 9.8;

    @BeforeAll
    static void setUpClass(){
        generosFilme = new ArrayList<>();
        generosFilme.add(GENERO_FILME1_1);
        generosFilme.add(GENERO_FILME1_2);
        nroEpsFilme = new ArrayList<>();
        nroEpsFilme.add(EPS_FILMES);    
        filme = new Filme(NOME_FILME1, generosFilme, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, nroEpsFilme);
    }

    @Test
    void getNome() {
        assertEquals(NOME_FILME1, filme.getNome());
    }

    @Test
    void getGenero() {
        assertEquals(TAM_GENEROS, filme.getGenero().size());
        assertEquals(GENERO_FILME1_1, filme.getGenero().get(0));
        assertEquals(GENERO_FILME1_2, filme.getGenero().get(1));
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAO_FILME1, filme.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals(PRODUTORA_FILME1, filme.getProdutora());
    }

    @Test
    void getDiretor() { assertEquals(DIRETOR_FILME1, filme.getDiretor()); }

    @Test
    void getAno() {
        assertEquals(ANO_FILME1, filme.getAno());
    }
    
    @Test
    void getNroEpisodios() {
    	assertTrue(filme.getNroEpisodios().size() == 1);
    	int nroEpsFilme = filme.getNroEpisodios().get(0);
        assertEquals(EPS_FILMES, nroEpsFilme);
    }

    @Test
    void setNota(){
        filme.setNota(NOTATESTE);
        assertEquals(NOTATESTE, filme.getNota());
    }

    @Test
    void setStatus(){
        filme.setStatus(STATUSTESTE);
        assertEquals(STATUSTESTE, filme.getStatus());
    }

    @Test
    void retornaPossiveisStatus() {
    	ArrayList<String> status = filme.retornaPossiveisStatus();
    	assertTrue(status.size() == 2);
    	assertEquals(status.get(0), ASSISTIDO);
    	assertEquals(status.get(1), ASSISTIR_MAIS_TARDE);
    }
}