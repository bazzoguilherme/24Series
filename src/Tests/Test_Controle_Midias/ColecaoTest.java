package Tests.Test_Controle_Midias;

import Program.Controle_Midias.Colecao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColecaoTest {
    private static Colecao colecao;
    private static final String NOMECOLECAO = "Animes";
    private static final String NOVONOMECOLECAO = "Favoritos";

    @BeforeEach
    void setUp(){
        colecao = new Colecao(NOMECOLECAO);
    }

    @Test
    void getNome() {
        assertEquals(NOMECOLECAO, colecao.getNome());
    }

    @Test
    void setNome() {
        colecao.setNome(NOVONOMECOLECAO);
        assertEquals(NOVONOMECOLECAO, colecao.getNome());
    }
}