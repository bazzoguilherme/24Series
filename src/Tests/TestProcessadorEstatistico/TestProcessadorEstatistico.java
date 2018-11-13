package Tests.TestProcessadorEstatistico;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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
	private static Serie serie2;
	private static Serie serie3;
	private static Filme filme1;
	
    private static ArrayList<String> generosFilme;
    private static ArrayList<Integer> nroEpsFilme;
	
    private static ArrayList<String> generosSerie;
    private static ArrayList<Integer> episodiosTempSerie1;
    private static ArrayList<Integer> episodiosTempSerie2;
    private static ArrayList<Integer> episodiosTempSerie3;

    
	private Hashtable<String, Midia> series;
	private Hashtable<String, Midia> filmes;
	
	private static ProcessadorEstatistico procEst;
	
	@BeforeAll
	static void setUpClass() {
		procEst = new ProcessadorEstatistico();
		
		episodiosTempSerie1 = new ArrayList<>();
		episodiosTempSerie1.add(EP_SERIE1_TEMP1);
		episodiosTempSerie1.add(EP_SERIE1_TEMP2);
		episodiosTempSerie1.add(EP_SERIE1_TEMP3);
		
		episodiosTempSerie2 = new ArrayList<>();
		episodiosTempSerie2.add(12);
		episodiosTempSerie2.add(15);
		episodiosTempSerie2.add(10);
        
		episodiosTempSerie3 = new ArrayList<>();
		episodiosTempSerie3.add(EP_SERIE3_TEMP1);
		episodiosTempSerie3.add(EP_SERIE3_TEMP2);
		episodiosTempSerie3.add(EP_SERIE3_TEMP3);

		
        generosSerie = new ArrayList<>();
        generosSerie.add(GENERO_SERIE1_1);
        generosSerie.add(GENERO_SERIE1_2);

        serie1 = new Serie(NOME_SERIE1, generosSerie, DURACAO_SERIE1, PRODUTORA_SERIE1, DIRETOR_SERIE1, ANO_SERIE1, episodiosTempSerie1);
        serie2 = new Serie(NOME_SERIE2, generosSerie, DURACAO_SERIE2, PRODUTORA_SERIE2, DIRETOR_SERIE2, ANO_SERIE2, episodiosTempSerie2);
        serie3 = new Serie(NOME_SERIE3, generosSerie, DURACAO_SERIE3, PRODUTORA_SERIE3, DIRETOR_SERIE3, ANO_SERIE3, episodiosTempSerie3);
        
        generosFilme = new ArrayList<>();
        generosFilme.add(GENERO_FILME1_1);
        generosFilme.add(GENERO_FILME1_2);
        nroEpsFilme = new ArrayList<>();
        nroEpsFilme.add(EPS_FILMES);        
        
	}
	
	@BeforeEach
	void setUp() {
        filme1 = new Filme(NOME_FILME1, generosFilme, DURACAO_FILME1, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, nroEpsFilme);
		
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
	void testCalculaHorasAssistidasSeriesVazio() {
		
		assertEquals(0, procEst.calculaHorasAssistidasSeries(series));
	}

	@Test
	void testCalculaHorasAssistidasSeriesUnica() {
		serie1.setNroEpisodiosAssistidos(4);
		
		series.put(serie1.getNome(), serie1);
		
		assertEquals(serie1.getNroEpisodiosAssistidos()*DURACAO_SERIE1, procEst.calculaHorasAssistidasSeries(series));
	}
	
	@Test 
	void testCalculaHorasAssistidasSeriesTam3() {
		serie1.setNroEpisodiosAssistidos(5);
		serie2.setNroEpisodiosAssistidos(10);
		serie3.setNroEpisodiosAssistidos(7);
		
		series.put(serie1.getNome(), serie1);
		series.put(serie2.getNome(), serie2);
		series.put(serie3.getNome(), serie3);

		int totalHoras = DURACAO_SERIE1 * serie1.getNroEpisodiosAssistidos()
					   + DURACAO_SERIE2 * serie2.getNroEpisodiosAssistidos()
					   + DURACAO_SERIE3 * serie3.getNroEpisodiosAssistidos();
		
		assertEquals(totalHoras, procEst.calculaHorasAssistidasSeries(series));
	}	
	
	
	@Test
	void testCalculaHorasAssistidasFilmesVazio() {
		
		assertEquals(0, procEst.calculaHorasAssistidasFilmes(filmes));
	}
	
	@Test
	void testCalculaHorasAssistidasFilmesUnicoNaoAssistido() {
		
		filmes.put(filme1.getNome(), filme1);
		
		assertEquals(0, procEst.calculaHorasAssistidasFilmes(filmes));
	}
	
	@Test
	void testCalculaHorasAssistidasFilmesUnicoAssistido() {
		
		filme1.setStatus("Assistido");
		filmes.put(filme1.getNome(), filme1);
		
		
		assertEquals(filme1.getDuracao(), procEst.calculaHorasAssistidasFilmes(filmes));
	}
	
	@Test
	void testCalculaHorasAssistidasFilmesTam3() {
		
		Filme filme2 = new Filme("Pokemon 2000", generosFilme, 113, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, nroEpsFilme); 
		Filme filme3 = new Filme("The Lion King", generosFilme, 150, PRODUTORA_FILME1, DIRETOR_FILME1, ANO_FILME1, nroEpsFilme); 
		
		filme2.setStatus("Assistido");
		filme3.setStatus("Assistido");
		
		int totalHoras = filme2.getDuracao() + filme3.getDuracao();
		
		filmes.put(filme1.getNome(), filme1);
		filmes.put(filme2.getNome(), filme2);
		filmes.put(filme3.getNome(), filme3);
		
		assertEquals(totalHoras, procEst.calculaHorasAssistidasFilmes(filmes));
	}
	
	@Test
	void testCalculaModaListaStringVazia() {
		ArrayList<String> lista = new ArrayList<>();
		ArrayList<String> moda;
		
		moda = procEst.calculaModa(lista);
		
		assertEquals(true, moda.isEmpty());
	}
	
	@Test
	void testCalculaModaListaStringTam3Unimodal() {
		ArrayList<String> lista = new ArrayList<>();
		ArrayList<String> moda;
		
		lista.add("Hunter X Hunter");
		lista.add("No Game No Life");
		lista.add("Hunter X Hunter");

		moda = procEst.calculaModa(lista);
		assertEquals(1, moda.size());
		assertEquals("Hunter X Hunter", moda.get(0));
	}
	
	@Test
	void testCalculaModaListaStringTam5Bimodal() {
		ArrayList<String> lista = new ArrayList<>();
		ArrayList<String> moda;
		
		lista.add("Hunter X Hunter");
		lista.add("No Game No Life");
		lista.add("Hunter X Hunter");
		lista.add("No Game No Life");
		lista.add("Made in Abyss");
		
		moda = procEst.calculaModa(lista);
		assertEquals(2, moda.size());
		
		assertEquals("Hunter X Hunter", moda.get(0));
		assertEquals("No Game No Life", moda.get(1));
	}
	
//	@Test
//	void calculaModaListaDoubleVazia() {
//		ArrayList<Double> lista = new ArrayList<>();
//		ArrayList<Double> moda;
//		
//		moda = procEst.calculaModa(lista);
//		assertEquals(true, moda.isEmpty());
//	}
	
	
	@Test
	void testCalculaTotalEpisodiosAssistidosHashVazia() {
		
		assertEquals(0,	procEst.calculaTotalEpisodiosAssistidos(series));
	}

	@Test
	void testCalculaTotalEpisodiosAssistidosHashTam1() {
		serie1.setNroEpisodiosAssistidos(18);
		
		series.put(serie1.getNome(), serie1);
		
		assertEquals(serie1.getNroEpisodiosAssistidos(), procEst.calculaTotalEpisodiosAssistidos(series));
	}
	
	
	@Test
	void testCalculaTotalEpisodiosAssistidosHashTam3() {
		serie1.setNroEpisodiosAssistidos(18);
		serie2.setNroEpisodiosAssistidos(30);
		serie3.setNroEpisodiosAssistidos(40);
		
		series.put(serie1.getNome(), serie1);
		series.put(serie2.getNome(), serie2);
		series.put(serie3.getNome(), serie3);

		
		assertEquals(serie1.getNroEpisodiosAssistidos()+serie2.getNroEpisodiosAssistidos()+serie3.getNroEpisodiosAssistidos(),
				procEst.calculaTotalEpisodiosAssistidos(series));
	}
	
	@Test
	void testCalculaEpisodiosRestantesSerieIncompleta() {
		serie1.setNroEpisodiosAssistidos(18);
			
		assertEquals(EP_SERIE1_TEMP1+EP_SERIE1_TEMP2+EP_SERIE1_TEMP3-18, procEst.calculaEpisodiosRestantes(serie1));
	}
	
	@Test
	void testCalculaEpisodiosRestantesSerieCompleta() {
		serie1.setNroEpisodiosAssistidos(EP_SERIE1_TEMP1+EP_SERIE1_TEMP2+EP_SERIE1_TEMP3);
			
		assertEquals(0, procEst.calculaEpisodiosRestantes(serie1));
	}
	
	@Test
	void testCalculaTotalEpisodiosRestantesListaVazia() {
		ArrayList<Serie> lista = new ArrayList<>();
		ArrayList<Integer> epsR = procEst.calculaTotalEpisodiosRestantes(lista);

		assertEquals(0, epsR.size());
	}
	
	@Test
	void testCalculaTotalEpisodiosRestantesListaTam3() {
		serie1.setNroEpisodiosAssistidos(18);
		serie2.setNroEpisodiosAssistidos(30);
		serie3.setNroEpisodiosAssistidos(40);

		ArrayList<Serie> lista = new ArrayList<>();
		
		lista.add(serie1);
		lista.add(serie2);
		lista.add(serie3);

		ArrayList<Integer> epsR = procEst.calculaTotalEpisodiosRestantes(lista);

		assertEquals((Integer)14, epsR.get(0));
		assertEquals((Integer)7, epsR.get(1));
		assertEquals((Integer)33, epsR.get(2));
		assertEquals(3, epsR.size());
	}
	
	
}
