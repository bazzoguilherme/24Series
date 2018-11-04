package Tests.Test_Filtros;

import Program.Arquivos.ProcessadorArquivo;
import Program.Controle_Midias.Catalogo;
import Program.Filtros.FiltroGeral;
import Program.Midias.Midia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static Tests.Constantes.Constantes_Filmes.NOME_FILME1;
import static Tests.Constantes.Constantes_Series.*;
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
    private static final String FILTRONOME_ERRADO = "Sr. Robot";
    private static final String FILTROGENERO_ERRADO = "Terror"; // Errado pois não está em nenhum dos casos de teste, porém qualquer outro nome inválido resultará no mesmo


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

    @Test
    void filtraPorNomeErrado(){
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
        ArrayList<Midia> midiasNome = filtroGeral.filtraPorNome(FILTRONOME_ERRADO, midias);
        assertEquals(0, midiasNome.size());
    }

    @Test
    void filtraPorNomeCorreto(){
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
        ArrayList<Midia> midiasNome = filtroGeral.filtraPorNome(NOME_SERIE1, midias);
        assertEquals(1, midiasNome.size());
        assertEquals(NOME_SERIE1, midiasNome.get(0).getNome());
    }

    @Test
    void filtraPorGenero0(){
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
        ArrayList<Midia> midiasGenero = filtroGeral.filtraPorGenero(FILTROGENERO_ERRADO, midias); // Terror (nenhum caso de teste)
        assertEquals(0, midiasGenero.size());
    }

    @Test
    void filtraPorGenero1(){
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
        ArrayList<Midia> midiasGenero = filtroGeral.filtraPorGenero(GENERO_SERIE1_1, midias); // Drama (apenas Mr. Robot)
        assertEquals(1, midiasGenero.size());
        assertEquals(NOME_SERIE1, midiasGenero.get(0).getNome());
    }

    @Test
    void filtraPorGenero2(){
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
        ArrayList<Midia> midiasGenero = filtroGeral.filtraPorGenero(GENERO_SERIE2_1, midias); // Anime (Haikyuu e Your Name)
        assertEquals(2, midiasGenero.size());
    }

    @Test
    void filtraPorProdutora(){
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
        ArrayList<Midia> midiasProdutora = filtroGeral.filtraPorProdutora(PRODUTORA_SERIE1, midias); // UCP (Mr. Robot)
        assertEquals(1, midiasProdutora.size());
        assertEquals(NOME_SERIE1, midiasProdutora.get(0).getNome());
    }

    @Test
    void filtraPorDiretor(){
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
        ArrayList<Midia> midiasDiretor = filtroGeral.filtraPorDiretor(DIRETOR_SERIE1, midias); // Sam Esmail (Mr. Robot)
        assertEquals(1, midiasDiretor.size());
        assertEquals(NOME_SERIE1, midiasDiretor.get(0).getNome());
    }

    @Test
    void filtraPorAno(){
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
        ArrayList<Midia> midiasAno = filtroGeral.filtraPorAno(ANO_SERIE1, midias); // 2015 (Mr. Robot)
        assertEquals(1, midiasAno.size());
        assertEquals(NOME_SERIE1, midiasAno.get(0).getNome());
    }

    @Test
    void filtraPorDuracao(){
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
        ArrayList<Midia> midiasDuracao = filtroGeral.filtraPorDuracao(DURACAO_SERIE1, midias); // 65 (Mr. Robot)
        assertEquals(1, midiasDuracao.size());
        assertEquals(NOME_SERIE1, midiasDuracao.get(0).getNome());
    }
    
    @Test
    void ordenaPorNome() {
    	boolean ordenado = true;
        ArrayList<Midia> midias = filtroGeral.buscaPorNome(NOMEVAZIO_TESTE, catalogo);
    	FiltroGeral.ordenaPorNome(midias);
    	for(int i=0; i < midias.size()-1; i++) {
    		if(midias.get(i).getNome().compareTo(midias.get(i+1).getNome()) > 0) {
    			ordenado = false;
    		}
    		System.out.println(midias.get(i).getNome());
    	}
    	System.out.println(midias.get(midias.size()-1).getNome());
    	assertEquals(true, ordenado);
    }


}