package Program.ProcessadorEstatistico;

import java.util.Hashtable;

import Program.Midias.Midia;

public class ProcessadorEstatistico {

	public ProcessadorEstatistico(){
	}
	
	public int calculaNumeroSeries(Hashtable<String, Midia> series) {	
		return series.size();
	}
	
	public int calculaNumeroFilmes(Hashtable<String, Midia> filmes) {	
		return filmes.size();
	}
	
	
	
	
	
}
