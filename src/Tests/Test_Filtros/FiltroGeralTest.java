package Tests.Test_Filtros;

import Program.Arquivos.ProcessadorArquivo;
import Program.Controle_Midias.Catalogo;
import Program.Filtros.FiltroGeral;
import Program.Midias.Midia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Tests.Constantes.Constantes_Filmes.NOME_FILME1;
import static Tests.Constantes.Constantes_Series.NOME_SERIE1;
import static Tests.Constantes.Constantes_Series.NOME_SERIE2;
import static org.junit.jupiter.api.Assertions.*;

class FiltroGeralTest {
    private static FiltroGeral filtroGeral;
    private static Catalogo catalogo;
    private static ProcessadorArquivo processArquivo;
    private static final String NOME_ARQUIVO = "24catalogoTeste.csv";
    private static final String NOMEVAZIO_TESTE = "";
    private static final String NOMERETORNOVAZIO_TESTE = "Q";
    private static final String NOME1LETRA1MIDIA_TESTE = "n";
    private static final String NOME1LETRA2MIDIAS_TESTE = "a";
    private static final String NOME1SUBPALAVRA1MIDIAS_TESTE = "mr.";

    @BeforeAll
    static void setUpClass(){
        filtroGeral = new FiltroGeral();
        catalogo = new Catalogo();
        processArquivo = new ProcessadorArquivo();

        catalogo = processArquivo.criaCatalogo(NOME_ARQUIVO);
    }

    @Test
    void buscaPorNomeVazio() {
        assertEquals(3, filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo).size());
    }

    @Test
    void buscaPorNomeRetornoVazio(){
        assertEquals(0, filtroGeral.buscaPorNome(NOMERETORNOVAZIO_TESTE, catalogo).size());
    }

    @Test
    void buscaPorNome1Letra1Midia(){ // 1 Midia esperada para 'n' : "Your Name"
        ArrayList<Midia> midiaRetorno = filtroGeral.buscaPorNome(NOME1LETRA1MIDIA_TESTE, catalogo);
        assertEquals(1, midiaRetorno.size());
        assertEquals(NOME_FILME1, midiaRetorno.get(0).getNome());
    }

    @Test
    void buscaPorNome1Letra2Midias(){ // 2 Midias esperadas para 'a': "Your Name", "Haikyuu"
        ArrayList<Midia> midiaRetorno = filtroGeral.buscaPorNome(NOME1LETRA2MIDIAS_TESTE, catalogo);
        assertEquals(2, midiaRetorno.size());
        assertEquals(NOME_SERIE2, midiaRetorno.get(0).getNome());
        assertEquals(NOME_FILME1, midiaRetorno.get(1).getNome());
            // Teste correto analisando a partir dos índices pois é sabido que os primeiros indices estarão as series
    }

    @Test
    void buscaPorNomeSubPalavra(){ // Procura por Midias que contém alguma subpalavra
        ArrayList<Midia> midiaRetorno = filtroGeral.buscaPorNome(NOME1SUBPALAVRA1MIDIAS_TESTE, catalogo);
        assertEquals(1, midiaRetorno.size());
        assertEquals(NOME_SERIE1, midiaRetorno.get(0).getNome());
    }
}