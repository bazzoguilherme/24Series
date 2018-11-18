package Tests.Test_Arquivo;

import Program.Arquivos.ProcessadorArquivo;
import Program.Controle_Midias.Catalogo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ProcessadorArquivoTest {
    private static ProcessadorArquivo processaArq;
    private static final String NOMETESTE1 = "Mr. Robot";
    private static final String NOMETESTE2 = "Haikyuu";
    private static final String NOMETESTE3 = "Your Name";
    private static final String NOMEARQUIVOTESTE = "24catalogoTeste.csv";
    private static final String NOMEARQUIVOTESTEERRO = "23catalogoTeste.csv";
    private static final String NOMEARQUIVOTESTESAIDA = "novo24TesteSaida.csv";

    @BeforeAll
    static void setUpClass(){
        processaArq = new ProcessadorArquivo();
    }

    @Test
    void criaCatalogo() {
        Catalogo catalogoTeste;
        catalogoTeste = processaArq.criaCatalogo(NOMEARQUIVOTESTE);
        assertEquals(NOMETESTE1, catalogoTeste.selecionaSerie(NOMETESTE1).getNome());
        assertEquals(NOMETESTE2, catalogoTeste.selecionaSerie(NOMETESTE2).getNome());
        assertEquals(NOMETESTE3, catalogoTeste.selecionaFilme(NOMETESTE3).getNome());
    }

    @Test
    void arquivoNaoEncontrado(){ // Verifica se não há erro durante a execução com um arquivo inexistente
        processaArq.criaCatalogo(NOMEARQUIVOTESTEERRO);
    }

    @Test
    void gravaCatalogo(){
        Catalogo catalogoTeste;
        catalogoTeste = processaArq.criaCatalogo(NOMEARQUIVOTESTE);
        processaArq.gravaCatalogo(NOMEARQUIVOTESTESAIDA, catalogoTeste);
    }
}