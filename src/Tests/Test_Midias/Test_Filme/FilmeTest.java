package Tests.Test_Midias.Test_Filme;

import Program.Midias.Filme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static Tests.Constantes.Constantes_Filmes.*;
import static org.junit.jupiter.api.Assertions.*;

class FilmeTest {
    private static Filme filme;
    private static final String STATUSTESTE = "Finalizada";
    private static final double NOTATESTE = 9.8;

    @BeforeAll
    static void setUpClass(){
        filme = new Filme(NOME_FILME1, GENERO_FILME01, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1);
    }

    @Test
    void getNome() {
        assertEquals(NOME_FILME1, filme.getNome());
    }

    @Test
    void getGenero() {
        assertEquals(GENERO_FILME01, filme.getGenero());
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
    void setNota(){
        filme.setNota(NOTATESTE);
        assertEquals(NOTATESTE, filme.getNota());
    }

    @Test
    void setStatus(){
        filme.setStatus(STATUSTESTE);
        assertEquals(STATUSTESTE, filme.getStatus());
    }

}