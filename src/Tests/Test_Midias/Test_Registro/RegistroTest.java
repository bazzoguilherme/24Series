package Tests.Test_Midias.Test_Registro;

import Program.Midias.Registro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {
    private static Registro registro;
    private static final String NOMETESTE = "Mr. Robot";
    private static final String GENEROTESTE = "Drama";
    private static final int DURACAOTESTE = 65;
    private static final String PRODUTORATESTE = "UCP";
    private static final String DIRETORTESTE = "Sam Esmail";
    private static final int ANOTESTE = 2015;
    private static final String STATUSPADRAO = "Planejo Assistir";

    @BeforeAll
    static void initAll(){
        registro = new Registro(NOMETESTE, GENEROTESTE, DURACAOTESTE, PRODUTORATESTE, DIRETORTESTE, ANOTESTE);
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
        assertEquals(NOMETESTE, registro.getNome());
    }

    @Test
    void getGenero() {
        assertEquals(GENEROTESTE, registro.getGenero());
    }

    @Test
    void getDuracao() {
        assertEquals(DURACAOTESTE, registro.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals(PRODUTORATESTE, registro.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals(DIRETORTESTE, registro.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(ANOTESTE, registro.getAno());
    }

    @Test
    @Disabled
    void retornaPossiveisStatus() {
    }
}