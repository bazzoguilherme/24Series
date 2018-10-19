package Tests.Test_Midias.Test_Filme;

import Program.Midias.Filme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmeTest {
    private static Filme filme;
    private static final String NOMETESTE = "Your Name";
    private static final String GENEROTESTE = "Animacao";
    private static final int DURACAOTESTE = 107;
    private static final String PRODUTORATESTE = "CoMix";
    private static final String DIRETORTESTE = "Makoto Shinkai";
    private static final int ANOTESTE = 2016;
    private static final String STATUSTESTE = "Finalizada";
    private static final double NOTATESTE = 9.8;

    @BeforeAll
    static void setUpClass(){
        filme = new Filme(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE);
    }

    @Test
    void getNome() {
        assertEquals(NOMETESTE, filme.getNome());
    }

    @Test
    void getGenero() {
        assertEquals(GENEROTESTE, filme.getGenero());
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAOTESTE, filme.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals(PRODUTORATESTE, filme.getProdutora());
    }

    @Test
    void getDiretor() { assertEquals(DIRETORTESTE, filme.getDiretor()); }

    @Test
    void getAno() {
        assertEquals(ANOTESTE, filme.getAno());
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