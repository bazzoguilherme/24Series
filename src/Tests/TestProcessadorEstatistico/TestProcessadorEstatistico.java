package Tests.TestProcessadorEstatistico;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Program.Midias.Filme;
import Program.Midias.Midia;
import Program.Midias.Serie;
import Program.ProcessadorEstatistico.ProcessadorEstatistico;
import static Tests.Constantes.Constantes_Series.*;
import static Tests.Constantes.Constantes_Filmes.*;
import static Program.Midias.Filme.EPS_FILMES;

class TestProcessadorEstatistico {

	private static Serie serie1;
	private static Filme filme1;
	
    private static ArrayList<String> generosFilme;
    private static ArrayList<Integer> nroEpsFilme;
	
    private static ArrayList<String> generosSerie;
    private static ArrayList<Integer> episodiosTempTeste;
    
	private Hashtable<String, Midia> series;
	private Hashtable<String, Midia> filmes;
	
	private static ProcessadorEstatistico procEst;
	
	@BeforeAll
	static void setUpClass() {
		procEst = new ProcessadorEstatistico();
		
		episodiosTempTeste = new ArrayList<>();
        episodiosTempTeste.add(EP_SERIE1_TEMP1);
        episodiosTempTeste.add(EP_SERIE1_TEMP2);
        episodiosTempTeste.add(EP_SERIE1_TEMP3);

        generosSerie = new ArrayList<>();
        generosSerie.add(GENERO_SERIE1_1);
        generosSerie.add(GENERO_SERIE1_2);

        serie1 = new Serie(NOME_SERIE1, generosSerie, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, episodiosTempTeste);

        generosFilme = new ArrayList<>();
        generosFilme.add(GENERO_FILME1_1);
        generosFilme.add(GENERO_FILME1_2);
        nroEpsFilme = new ArrayList<>();
        nroEpsFilme.add(EPS_FILMES);    
        
        filme1 = new Filme(NOME_FILME1, generosFilme, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, nroEpsFilme);
    
        
	}
	
	@BeforeEach
	void setUp() {
		series = new Hashtable<>();
		filmes = new Hashtable<>();
	}
	
	
	@Test
	void testCalculaNumeroSeriesTamEquals0() {		
		assertEquals(0, procEst.calculaNumeroSeries(series));
	}
	
	@Test
	void testCalculaNumeroSeriesTamEquals1() {
		series.put(serie1.getNome(), serie1);
		
		assertEquals(1, procEst.calculaNumeroSeries(series));
	}
	
	@Test
	void testCalculaNumeroSeriesTamEquals3() {
		series.put(serie1.getNome()+"1", serie1);
		series.put(serie1.getNome()+"2", serie1);
		series.put(serie1.getNome()+"3", serie1);

		assertEquals(3, procEst.calculaNumeroSeries(series));
	}
	
	@Test
	void testCalculaNumeroFilmessTamEquals0() {		
		assertEquals(0, procEst.calculaNumeroFilmes(filmes));
	}
	
	@Test
	void testCalculaNumeroFilmessTamEquals1() {
		filmes.put(filme1.getNome(), filme1);
		
		assertEquals(1, procEst.calculaNumeroFilmes(filmes));
	}
	
	@Test
	void testCalculaNumeroFilmessTamEquals3() {
		filmes.put(filme1.getNome()+"1", filme1);
		filmes.put(filme1.getNome()+"2", filme1);
		filmes.put(filme1.getNome()+"3", filme1);

		assertEquals(3, procEst.calculaNumeroFilmes(filmes));
	}		
	
	@Test
	void testCalculaHorasAssistidasSeries0Eps() {
		
		assertEquals(0, procEst.calculaHorasAssistidasSeries(series));
	}

// Ainda a implementar
//	@Test
//	void testCalculaHorasAssistidasSeries4Eps() {
//		serie1.setNota(9.5);
//		serie1.setNroEpisodiosAssistidos(4);
//		
//		series.put(serie1.getNome(), serie1);
//		
//		assertEquals(4*65, procEst.calculaHorasAssistidasSeries(series));
//	}
}
