package Tests.Test_Recomendador;

import Program.Controle_Midias.Catalogo;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Registro;
import Program.Midias.Serie;
import Program.Recomendador.Recomendador;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Tests.Constantes.Constantes_Filmes.*;
import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;

class RecomendadorTest {
    private static Recomendador recomendador;
    private static Catalogo catalogo;
    ArrayList<Registro> listaRegistro;
    private static Serie serie1;
    private static Serie serie2;
    private static Serie serie3;
    private static Filme filme1;
    private static Midia Mserie1;
    private static Midia Mserie2;
    private static Midia Mserie3;
    private static Midia Mfilme1;
    private static ArrayList<String> generosSerie1;
    private static ArrayList<String> generosSerie2;
    private static ArrayList<String> generosSerie3;
    private static ArrayList<String> generosFilme1;

    private static final String GENEROESPERADO = "Anime";
    private static final String PRODUTORAESPERADO = PRODUTORA_SERIE2;
    private static final String DIRETORESPERADO = DIRETOR_SERIE2;

    @BeforeAll
    static void setUpClass(){
        generosSerie1 = new ArrayList<>();
        generosSerie1.add(GENERO_SERIE1_1);
        generosSerie1.add(GENERO_SERIE1_2);

        generosSerie2 = new ArrayList<>();
        generosSerie2.add(GENERO_SERIE2_1);
        generosSerie2.add(GENERO_SERIE2_2);

        generosSerie3 = new ArrayList<>();
        generosSerie3.add(GENERO_SERIE3_1);

        generosFilme1 = new ArrayList<>();
        generosFilme1.add(GENERO_FILME1_1);
        generosFilme1.add(GENERO_FILME1_2);

        serie1 = new Serie(NOME_SERIE1, generosSerie1, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, new ArrayList<Integer>());
        serie2 = new Serie(NOME_SERIE2, generosSerie2, DURACAO_SERIE2, PRODUTORA_SERIE2, DIRETOR_SERIE2, ANO_SERIE2, new ArrayList<Integer>());
        serie3 = new Serie(NOME_SERIE3, generosSerie3, DURACAO_SERIE3, PRODUTORA_SERIE3, DIRETOR_SERIE3, ANO_SERIE3, new ArrayList<Integer>());
        filme1 = new Filme(NOME_FILME1, generosFilme1, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, new ArrayList<Integer>());

        Mserie1 =  new Midia(NOME_SERIE1, generosSerie1, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, new ArrayList<Integer>());
        Mserie2 =  new Midia(NOME_SERIE2, generosSerie2, DURACAO_SERIE2, PRODUTORA_SERIE2, DIRETOR_SERIE2, ANO_SERIE2, new ArrayList<Integer>());
        Mserie3 =  new Midia(NOME_SERIE3, generosSerie3, DURACAO_SERIE3, PRODUTORA_SERIE3, DIRETOR_SERIE3, ANO_SERIE3, new ArrayList<Integer>());
        Mfilme1 =  new Midia(NOME_FILME1, generosFilme1, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, new ArrayList<Integer>());

        recomendador = new Recomendador();
        catalogo = new Catalogo();
        catalogo.adicionaSerie(Mserie1);
        catalogo.adicionaSerie(Mserie2);
        catalogo.adicionaSerie(Mserie3);
        catalogo.adicionaFilme(Mfilme1);
    }

    @BeforeEach
    void setUp(){
        this.listaRegistro = new ArrayList<>();
    }

    @Test
    void recomendadarParaUsuario(){
        serie1.setNota(8.0);
        serie2.setNota(9.0);
        listaRegistro.add(serie1);
        listaRegistro.add(serie2);
        ArrayList<Midia> recomendacoes = recomendador.recomendarParaUsuario(listaRegistro, catalogo);
        for(Midia midia : recomendacoes){
            System.out.println(midia);
        }
    }

    @Test
    void recomendadarParaUsuarioSemNota(){
        listaRegistro.add(serie1);
        listaRegistro.add(serie2);
        ArrayList<Midia> recomendacoes = recomendador.recomendarParaUsuario(listaRegistro, catalogo);
        for(Midia midia : recomendacoes){
            System.out.println(midia);
        }
    }

    @Test
    void recomendadarParaUsuarioSemHistorico(){
        ArrayList<Midia> recomendacoes = recomendador.recomendarParaUsuario(listaRegistro, catalogo);
        for(Midia midia : recomendacoes){
            System.out.println(midia);
        }
    }

    @Test
    void analisaGeneroVoid() {
        assertEquals(0, recomendador.analisaGenero(listaRegistro).size());
    }

    @Test
    void analisaGenero() {
        listaRegistro.add(serie1);
        listaRegistro.add(serie2);
        // listaRegistro.add(serie3);
        listaRegistro.add(filme1);

        assertEquals(1, recomendador.analisaGenero(listaRegistro).size());
        assertEquals(GENEROESPERADO, recomendador.analisaGenero(listaRegistro).get(0));
    }

    @Test
    void analisaProdutoraVoid(){
        assertEquals(0, recomendador.analisaProdutora(listaRegistro).size());
    }

    @Test // Teste retorna as 4 produtoras
    void analisaProdutoraDiferentes(){
        listaRegistro.add(serie1);
        listaRegistro.add(serie2);
        listaRegistro.add(serie3);
        listaRegistro.add(filme1);

        assertEquals(4, recomendador.analisaProdutora(listaRegistro).size());
    }

    @Test
    void analisaProdutoraIguais(){
        listaRegistro.add(serie1);
        listaRegistro.add(serie2);
        listaRegistro.add(serie2);
        listaRegistro.add(serie3);
        listaRegistro.add(filme1);

        assertEquals(1, recomendador.analisaProdutora(listaRegistro).size());
        assertEquals(PRODUTORAESPERADO, recomendador.analisaProdutora(listaRegistro).get(0));
    }

    @Test
    void analisaDiretorVoid(){
        assertEquals(0, recomendador.analisaDiretor(listaRegistro).size());
    }

    @Test  // Teste retorna as 4 produtoras (mesma moda ->1)
    void analisaDiretorDiferentes(){
        listaRegistro.add(serie1);
        listaRegistro.add(serie2);
        listaRegistro.add(serie3);
        listaRegistro.add(filme1);

        assertEquals(4, recomendador.analisaDiretor(listaRegistro).size());
    }

    @Test
    void analisaDiretorIguais(){
        listaRegistro.add(serie1);
        listaRegistro.add(serie2);
        listaRegistro.add(serie2);
        listaRegistro.add(serie3);
        listaRegistro.add(filme1);

        assertEquals(1, recomendador.analisaDiretor(listaRegistro).size());
        assertEquals(DIRETORESPERADO, recomendador.analisaDiretor(listaRegistro).get(0));

    }

}