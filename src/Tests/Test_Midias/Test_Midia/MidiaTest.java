package Tests.Test_Midias.Test_Midia;

import Program.Midias.Midia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;

class MidiaTest {
    private static Midia midia;
    private static ArrayList<String> generosSerie;
    private static ArrayList<Integer> episodiosTempTeste;
    private static final int TAM_GENEROS = 2;

    @BeforeAll
    static void initAll(){
        generosSerie = new ArrayList<>();
        generosSerie.add(GENERO_SERIE1_1);
        generosSerie.add(GENERO_SERIE1_2);
        episodiosTempTeste = new ArrayList<>();
        episodiosTempTeste.add(EP_SERIE1_TEMP1);
        episodiosTempTeste.add(EP_SERIE1_TEMP2);
        episodiosTempTeste.add(EP_SERIE1_TEMP3);
        midia = new Midia(NOME_SERIE1, generosSerie, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, episodiosTempTeste);
    }

    @Test
    void getNome() {
        assertEquals(NOME_SERIE1, midia.getNome());
    }

    @Test
    void getGeneroTam(){
        assertEquals(TAM_GENEROS, midia.getGenero().size());
    }

    @Test
    void getGenero() {
        ArrayList<String> generosTeste;
        generosTeste = midia.getGenero();
        assertEquals(GENERO_SERIE1_1, generosTeste.get(0));
        assertEquals(GENERO_SERIE1_2, generosTeste.get(1));
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAO_SERIE1, midia.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals(PRODUTORA_SERIE1, midia.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals(DIRETOR_SERIE1, midia.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(ANO_SERIE1, midia.getAno());
    }
    
    @Test
    void getNroEpisodios() {
        assertTrue(EP_SERIE1_TEMP1 == midia.getNroEpisodios().get(0));
        assertTrue(EP_SERIE1_TEMP2 == midia.getNroEpisodios().get(1));
        assertTrue(EP_SERIE1_TEMP3 == midia.getNroEpisodios().get(2));
    }
}