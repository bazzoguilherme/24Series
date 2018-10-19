package Tests.Test_Midias.Test_Registro;

import Program.Midias.Registro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTestVoid {
    private static Registro registro;
    private static final String STATUSPADRAO = "Planejo Assistir";

    @BeforeAll
    static void initAll(){
        registro = new Registro();
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
    @Disabled
    void retornaPossiveisStatus() {
    }

    @Test
    void getNome() {
        assertEquals("", registro.getNome());
    }

    @Test
    void getGenero() {
        assertEquals("", registro.getGenero());
    }

    @Test
    void getDuracao() {
        assertEquals(0, registro.getDuracao());
    }

    @Test
    void getProdutora() {
        assertEquals("", registro.getProdutora());
    }

    @Test
    void getDiretor() {
        assertEquals("", registro.getDiretor());
    }

    @Test
    void getAno() {
        assertEquals(0, registro.getAno());
    }

}