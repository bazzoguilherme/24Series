package Tests.Test_Midias.Test_Serie;

import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;


class SerieTest {
    private static Serie serie;
    private static final String STATUSTESTE = "Finalizada";
    private static final double NOTATESTE = 9.8;
    private static final int EPTESTCERTO = 32;
    private static final int EPTEST = 22;
    private static final int EPTESTMAIS = 45;
    private static final int EPTESTMENOS = -5;


    @BeforeAll
    static void setUpClass(){
        ArrayList<Integer> episodiosTempTeste = new ArrayList<>();
        episodiosTempTeste.add(EP_SERIE1_TEMP1);
        episodiosTempTeste.add(EP_SERIE1_TEMP2);
        episodiosTempTeste.add(EP_SERIE1_TEMP3);
        serie = new Serie(NOME_SERIE1, GENERO_SERIE01, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, episodiosTempTeste);
    }

    @Test
    @Disabled
    void getNroEpisodios() {
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
        assertEquals(GENERO_SERIE01, serie.getGenero());
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
    void setNota(){
        serie.setNota(NOTATESTE);
        assertEquals(NOTATESTE, serie.getNota());
    }

    @Test
    void setStatus(){
        serie.setStatus(STATUSTESTE);
        assertEquals(STATUSTESTE, serie.getStatus());
    }
}