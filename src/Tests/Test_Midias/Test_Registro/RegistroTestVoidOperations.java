package Tests.Test_Midias.Test_Registro;

import Program.Midias.Registro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTestVoidOperations {
    private static Registro registro;
    private static final String STATUSTESTE = "Assistindo";
    private static final String STATUSPADRAO = "Planejo Assistir";
    private static final double NOTATESTE = 9.8;
    private static final double NOTAPADRAO = 0.0;

    @BeforeAll
    static void initAll(){
        registro = new Registro();
    }

    @BeforeEach
    void init(){
        registro.setNota(NOTAPADRAO);
        registro.setStatus(STATUSPADRAO);
    }

    @Test
    void getNota() {
        assertEquals(NOTAPADRAO, registro.getNota());
    }

    @Test
    void getStatus() {
        assertEquals(STATUSPADRAO, registro.getStatus());
    }

    @Test
    void setNota() {
        registro.setNota(NOTATESTE);
        assertEquals(NOTATESTE, registro.getNota());
    }

    @Test
    void setStatus() {
        registro.setStatus(STATUSTESTE);
        assertEquals(STATUSTESTE, registro.getStatus());
    }

}