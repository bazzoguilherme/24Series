package Tests.Test_Midias.Test_Serie;

import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static Program.Midias.Serie.*;
import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;


class SerieTest {
    private static Serie serie;
    private static ArrayList<String> generosSerie;
    private static ArrayList<Integer> episodiosTempTeste;
    private static final int TAM_GENEROS = 2;
    private static final String STATUSTESTE = "Finalizada";
    private static final double NOTATESTE = 9.8;
    private static final int EPTESTCERTO = 32;
    private static final int EPTEST = 22;
    private static final int EPTESTMAIS = 45;
    private static final int EPTESTMENOS = -5;



    @BeforeAll
    static void setUpClass(){
        episodiosTempTeste = new ArrayList<>();
        episodiosTempTeste.add(EP_SERIE1_TEMP1);
        episodiosTempTeste.add(EP_SERIE1_TEMP2);
        episodiosTempTeste.add(EP_SERIE1_TEMP3);

        generosSerie = new ArrayList<>();
        generosSerie.add(GENERO_SERIE1_1);
        generosSerie.add(GENERO_SERIE1_2);

        serie = new Serie(NOME_SERIE1, generosSerie, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, episodiosTempTeste);
    }

    @Test
    void setNroEpisodiosAssistidos() {
        serie.setNroEpisodiosAssistidos(EPTEST);
        assertEquals(EPTEST, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void setNroEpisodiosAssistidosMais() {
        serie.setNroEpisodiosAssistidos(EPTESTMAIS);
        assertEquals(EPTESTCERTO, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void setNroEpisodiosAssistidosMenos() {
        serie.setNroEpisodiosAssistidos(EPTESTMENOS);
        assertEquals(0, serie.getNroEpisodiosAssistidos());
    }

    @Test
    void quantidadeTotalEpisodios() {
        assertEquals(EPTESTCERTO, serie.quantidadeTotalEpisodios());
    }

    @Test
    void getNome() {
        assertEquals(NOME_SERIE1, serie.getNome());
    }

    @Test
    void getGenero() {
        assertEquals(TAM_GENEROS, serie.getGenero().size());
        assertEquals(GENERO_SERIE1_1, serie.getGenero().get(0));
        assertEquals(GENERO_SERIE1_2, serie.getGenero().get(1));
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAO_SERIE1, serie.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals(PRODUTORA_SERIE1, serie.getProdutora());
    }

    @Test
    void getDiretor() { assertEquals(DIRETOR_SERIE1, serie.getDiretor()); }

    @Test
    void getAno() {
        assertEquals(ANO_SERIE1, serie.getAno());
    }

    @Test
    void getNroEpisodios() {
    	assertTrue(serie.getNroEpisodios().size() == 3);
        assertTrue(EP_SERIE1_TEMP1 == serie.getNroEpisodios().get(0));
        assertTrue(EP_SERIE1_TEMP2 == serie.getNroEpisodios().get(1));
        assertTrue(EP_SERIE1_TEMP3 == serie.getNroEpisodios().get(2));
    }
    
    @Test
    void setNota(){
        serie.setNota(NOTATESTE);
        assertEquals(NOTATESTE, serie.getNota());
    }

    @Test
    void setStatus(){
        serie.setStatus(STATUSTESTE);
        assertEquals(STATUSTESTE, serie.getStatus());
    }
    
    @Test
    void retornaPossiveisStatus() {
    	ArrayList<String> status = serie.retornaPossiveisStatus();
    	assertTrue(status.size() == 6);
    	assertEquals(status.get(0), ASSISTINDO);
    	assertEquals(status.get(1), ASSISTIR_MAIS_TARDE);
    	assertEquals(status.get(2), FINALIZADO);
    	assertEquals(status.get(4), PAUSA);
    	assertEquals(status.get(5), CANCELADO);
    }
}