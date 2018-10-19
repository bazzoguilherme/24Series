package Tests.Test_Controle_Midias;

import Program.Controle_Midias.Colecao;
import Program.Midias.Filme;
import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ColecaoTestVoidNome {
    private static Colecao colecao;
    private final String COLECAOPADRAO = "Colecao Padrao";
    private final String NOMECOLECAOTESTE = "Meus Favoritos";
    private static final String NOMETESTE = "Mr. Robot";
    private static final String GENEROTESTE = "Drama";
    private static final int DURACAOTESTE = 65;
    private static final String PRODUTORATESTE = "UCP";
    private static final String DIRETORTESTE = "Sam Esmail";
    private static final int ANOTESTE = 2015;
    private static final String NOMETESTEERRO = "Mouse";

    @BeforeEach
    void setUp(){
        colecao = new Colecao();
    }


    @Test
    void getNome() {
        assertEquals(COLECAOPADRAO, colecao.getNome());
    }

    @Test
    void getRegistros() {
        assertTrue(colecao.getRegistros().isEmpty());
    }

    @Test
    void setNome() {
        colecao.setNome(NOMECOLECAOTESTE);
        assertEquals(NOMECOLECAOTESTE, colecao.getNome());
    }

    @Test
    void adicionaRegistro() {
        colecao.adicionaRegistro(new Serie());
        assertEquals(1, colecao.getRegistros().size());
        colecao.adicionaRegistro(new Filme());
        assertEquals(1, colecao.getRegistros().size()); //Não será inserido, chave "" (String vazia já existe)
        colecao.adicionaRegistro(new Serie(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE, new ArrayList<>()));
        assertEquals(2, colecao.getRegistros().size());
    }

    @Test
    void removeRegistro() {
        colecao.adicionaRegistro(new Serie(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE, new ArrayList<>()));
        assertEquals(1,colecao.getRegistros().size());
        colecao.removeRegistro(NOMETESTEERRO);
        assertFalse(colecao.getRegistros().isEmpty());
        colecao.removeRegistro(NOMETESTE);
        assertTrue(colecao.getRegistros().isEmpty());
    }
}