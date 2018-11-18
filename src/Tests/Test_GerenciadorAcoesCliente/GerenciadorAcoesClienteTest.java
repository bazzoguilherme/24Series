package Tests.Test_GerenciadorAcoesCliente;

import Program.Controle_Midias.Repositorio;
import Program.GerenciadorAcoes.GerenciadorAcoesCliente;
import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Registro;
import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Tests.Constantes.Constantes_Filmes.*;
import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorAcoesClienteTest {
    private static GerenciadorAcoesCliente gerenciador;
    private static Repositorio repositorio;
    ArrayList<Registro> listaRegistro;
    private static Serie serie1;
    private static Serie serie2;
    private static Serie serie3;
    private static Filme filme1;
    private static ArrayList<String> generosSerie1;
    private static ArrayList<String> generosSerie2;
    private static ArrayList<String> generosSerie3;
    private static ArrayList<String> generosFilme1;

    private static ArrayList<Integer> epSerie1;
    private static ArrayList<Integer> epSerie2;
    private static ArrayList<Integer> epSerie3;

    @BeforeAll
    static void setUpClass() {
        gerenciador = new GerenciadorAcoesCliente();
        repositorio = new Repositorio();

        generosSerie1 = new ArrayList<>();
        generosSerie1.add(GENERO_SERIE1_1);
        generosSerie1.add(GENERO_SERIE1_2);

        epSerie1 = new ArrayList<>();
        epSerie1.add(EP_SERIE1_TEMP1);
        epSerie1.add(EP_SERIE1_TEMP2);
        epSerie1.add(EP_SERIE1_TEMP3);

        generosSerie2 = new ArrayList<>();
        generosSerie2.add(GENERO_SERIE2_1);
        generosSerie2.add(GENERO_SERIE2_2);

        epSerie3 = new ArrayList<>();
        epSerie3.add(EP_SERIE3_TEMP1);
        epSerie3.add(EP_SERIE3_TEMP2);
        epSerie3.add(EP_SERIE3_TEMP3);

        generosSerie3 = new ArrayList<>();
        generosSerie3.add(GENERO_SERIE3_1);

        epSerie2 = new ArrayList<>();
        epSerie2.add(EP_SERIE2_TEMP1);
        epSerie2.add(EP_SERIE2_TEMP2);
        epSerie2.add(EP_SERIE2_TEMP3);

        generosFilme1 = new ArrayList<>();
        generosFilme1.add(GENERO_FILME1_1);
        generosFilme1.add(GENERO_FILME1_2);

        serie1 = new Serie(NOME_SERIE1, generosSerie1, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, epSerie1);
        serie2 = new Serie(NOME_SERIE2, generosSerie2, DURACAO_SERIE2, PRODUTORA_SERIE2, DIRETOR_SERIE2, ANO_SERIE2, epSerie2);
        serie3 = new Serie(NOME_SERIE3, generosSerie3, DURACAO_SERIE3, PRODUTORA_SERIE3, DIRETOR_SERIE3, ANO_SERIE3, epSerie3);
        filme1 = new Filme(NOME_FILME1, generosFilme1, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, new ArrayList<Integer>());

    }

    @BeforeEach
    void setUp(){
        this.listaRegistro = new ArrayList<>();
    }

    @Test
    @Disabled
    void batalha1() { //Apenas para verificar execução separadamente
        listaRegistro.add(serie1);
        gerenciador.batalha(listaRegistro);
    }

    @Test
    @Disabled
    void batalha2(){
        listaRegistro.add(serie1);
        listaRegistro.add(serie2);
        gerenciador.batalha(listaRegistro);
    }

    @Test
    void sugere1(){
        serie1.setNroEpisodiosAssistidos(30); // total = 32 // resta = 2
        serie1.setStatus(Serie.ASSISTINDO);
        serie2.setNroEpisodiosAssistidos(50); // total = 60 // resta = 10
        serie2.setStatus(Serie.ASSISTINDO);
        serie3.setNroEpisodiosAssistidos(40); // total = 73 // resta = 33
        serie3.setStatus(Serie.ASSISTINDO);
        repositorio.adicionaSerie(serie1);
        repositorio.adicionaSerie(serie2);
        repositorio.adicionaSerie(serie3);
        ArrayList<Midia> sugeridas = gerenciador.sugestContinuar(repositorio);
        assertEquals(3, sugeridas.size());
        assertEquals(NOME_SERIE1, sugeridas.get(0).getNome());
        assertEquals(NOME_SERIE2, sugeridas.get(1).getNome());
        assertEquals(NOME_SERIE3, sugeridas.get(2).getNome());
    }

    @Test
    void sugere2_1(){
        serie1.setNroEpisodiosAssistidos(32); // total = 32 // resta = 0
        serie1.setStatus(Serie.ASSISTINDO);
        serie2.setNroEpisodiosAssistidos(50); // total = 60 // resta = 10
        serie2.setStatus(Serie.ASSISTINDO);
        serie3.setNroEpisodiosAssistidos(40); // total = 73 // resta = 33
        serie3.setStatus(Serie.ASSISTINDO);
        repositorio.adicionaSerie(serie1);
        repositorio.adicionaSerie(serie2);
        repositorio.adicionaSerie(serie3);
        ArrayList<Midia> sugeridas = gerenciador.sugestContinuar(repositorio);
        assertEquals(2, sugeridas.size());
        assertEquals(NOME_SERIE2, sugeridas.get(0).getNome());
        assertEquals(NOME_SERIE3, sugeridas.get(1).getNome());
    }

    @Test
    void sugere2_2(){
        serie1.setNroEpisodiosAssistidos(32); // total = 32 // resta = 0
        serie1.setStatus(Serie.FINALIZADO);
        serie2.setNroEpisodiosAssistidos(50); // total = 60 // resta = 10
        serie2.setStatus(Serie.ASSISTINDO);
        serie3.setNroEpisodiosAssistidos(40); // total = 73 // resta = 33
        serie3.setStatus(Serie.ASSISTINDO);
        repositorio.adicionaSerie(serie1);
        repositorio.adicionaSerie(serie2);
        repositorio.adicionaSerie(serie3);
        ArrayList<Midia> sugeridas = gerenciador.sugestContinuar(repositorio);
        assertEquals(2, sugeridas.size());
        assertEquals(NOME_SERIE2, sugeridas.get(0).getNome());
        assertEquals(NOME_SERIE3, sugeridas.get(1).getNome());
    }

    @Test
    void sugere3(){
        serie1.setNroEpisodiosAssistidos(32); // total = 32 // resta = 2
        serie1.setStatus(Serie.ASSISTINDO);
        serie2.setNroEpisodiosAssistidos(60); // total = 60 // resta = 10
        serie2.setStatus(Serie.ASSISTINDO);
        serie3.setNroEpisodiosAssistidos(73); // total = 73 // resta = 33
        serie3.setStatus(Serie.ASSISTINDO);
        repositorio.adicionaSerie(serie1);
        repositorio.adicionaSerie(serie2);
        repositorio.adicionaSerie(serie3);
        ArrayList<Midia> sugeridas = gerenciador.sugestContinuar(repositorio);
        assertEquals(0, sugeridas.size());
    }

    @Test
    void horasAssistidadas0(){
        assertEquals(0, gerenciador.horasGastasAssistindo(repositorio));
    }

    @Test
    void horasAssistidas1(){
        serie1.setNroEpisodiosAssistidos(10);
        repositorio.adicionaSerie(serie1);
        assertEquals(650, gerenciador.horasGastasAssistindo(repositorio));
    }

    @Test
    void horasAssistidas2(){
        serie1.setNroEpisodiosAssistidos(10);
        repositorio.adicionaSerie(serie1);
        repositorio.adicionaFilme(filme1); // filme nao marcado como assistido
        assertEquals(650, gerenciador.horasGastasAssistindo(repositorio));
    }

    @Test
    void horasAssistidas3(){
        serie1.setNroEpisodiosAssistidos(10);
        repositorio.adicionaSerie(serie1);
        filme1.setStatus(Filme.ASSISTIDO);
        repositorio.adicionaFilme(filme1);
        assertEquals(757, gerenciador.horasGastasAssistindo(repositorio));
    }

}