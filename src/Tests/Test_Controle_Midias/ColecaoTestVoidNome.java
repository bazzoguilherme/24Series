package Tests.Test_Controle_Midias;

import Program.Controle_Midias.Colecao;
import Program.Midias.Filme;
import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;

class ColecaoTestVoidNome {
    private static Colecao colecao;
    private final String COLECAOPADRAO = "Colecao Padrao";
    private final String NOMECOLECAOTESTE = "Meus Favoritos";
    private static final String NOMETESTEERRO = "Mouse";

    private static Serie serie1;
    private static ArrayList<String> generosSerie;

    @BeforeAll
    static void setUpClass(){
        generosSerie = new ArrayList<>();
        generosSerie.add(GENERO_SERIE1_1);
        generosSerie.add(GENERO_SERIE1_2);

        serie1 = new Serie(NOME_SERIE1, generosSerie, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, new ArrayList<>());
    }

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
        colecao.adicionaRegistro(serie1);
        assertEquals(2, colecao.getRegistros().size());
    }

    @Test
    void removeRegistro() {
        colecao.adicionaRegistro(serie1);
        assertEquals(1,colecao.getRegistros().size());
        colecao.removeRegistro(NOMETESTEERRO);
        assertFalse(colecao.getRegistros().isEmpty());
        colecao.removeRegistro(NOME_SERIE1);
        assertTrue(colecao.getRegistros().isEmpty());
    }
}