package Tests.Test_Controle_Midias;

import Program.Arquivos.ProcessadorArquivo;
import Program.Controle_Midias.Catalogo;
import Program.Midias.Serie;
import Program.Midias.Filme;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoTest {
    private static Catalogo catalogo;
    private static ProcessadorArquivo processaArq;
    private static final String NOMETESTE1 = "Mr. Robot";
    private static final String NOMETESTE2 = "Haikyuu";
    private static final String NOMETESTE3 = "Your Name";
    private static final String NOMEARQUIVOTESTE = "24catalogoTeste.csv";

    @BeforeAll
    static void setUpClass(){
        catalogo = new Catalogo();
        processaArq = new ProcessadorArquivo();
    }

    @Test
    void selecionaMidia() {
        catalogo = processaArq.criaCatalogo(NOMEARQUIVOTESTE);
        assertEquals(NOMETESTE1,catalogo.selecionaMidia(NOMETESTE1).getNome());
        assertEquals(NOMETESTE2,catalogo.selecionaMidia(NOMETESTE2).getNome());
        assertEquals(NOMETESTE3,catalogo.selecionaMidia(NOMETESTE3).getNome());
    }
}