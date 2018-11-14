package Tests.Test_GerenciadorAcoesCliente;

import Program.GerenciadorAcoes.GerenciadorAcoesCliente;
import Program.Midias.Filme;
import Program.Midias.Registro;
import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Tests.Constantes.Constantes_Filmes.*;
import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorAcoesClienteTest {
    private static GerenciadorAcoesCliente gerenciador;
    ArrayList<Registro> listaRegistro;
    private static Serie serie1;
    private static Serie serie2;
    private static Serie serie3;
    private static Filme filme1;
    private static ArrayList<String> generosSerie1;
    private static ArrayList<String> generosSerie2;
    private static ArrayList<String> generosSerie3;
    private static ArrayList<String> generosFilme1;

    @BeforeAll
    static void setUpClass() {
        gerenciador = new GerenciadorAcoesCliente();

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

    }

    @BeforeEach
    void setUp(){
        this.listaRegistro = new ArrayList<>();
    }

    @Test
    void batalha1() { //Apenas para verificar execução separadamente
        listaRegistro.add(serie1);
        gerenciador.batalha(listaRegistro);
    }

    @Test
    void batalha2(){
        listaRegistro.add(serie1);
        listaRegistro.add(serie2);
        gerenciador.batalha(listaRegistro);
    }
}