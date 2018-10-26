package Tests.Test_Midias.Test_Registro;

import Program.Midias.Registro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static Tests.Constantes.Constantes_Series.*;
import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {
    private static Registro registro;
    private static final String STATUSPADRAO = "Planejo Assistir";

    @BeforeAll
    static void initAll(){
        registro = new Registro(NOME_SERIE1, GENERO_SERIE01, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1);
    }

    @Test
    void getNota() {
        assertEquals(0.0, registro.getNota());
    }

    @Test
    void getStatus() {
        assertEquals(STATUSPADRAO, registro.getStatus());
    }

    @Test
    void getNome() {
        assertEquals(NOME_SERIE1, registro.getNome());
    }

    @Test
    void getGenero() {
        assertEquals(GENERO_SERIE01, registro.getGenero());
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAO_SERIE1, registro.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals(PRODUTORA_SERIE1, registro.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals(DIRETOR_SERIE1, registro.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(ANO_SERIE1, registro.getAno());
    }

    @Test
    @Disabled
    void retornaPossiveisStatus() {
    }
}