package Program.ProcessadorEstatistico;

import java.util.Hashtable;
import java.util.Iterator;

import Program.Midias.Midia;
import Program.Midias.Serie;

public class ProcessadorEstatistico {

	public ProcessadorEstatistico(){
	}
	
	public int calculaNumeroSeries(Hashtable<String, Midia> series) {	
		return series.size();
	}
	
	public int calculaNumeroFilmes(Hashtable<String, Midia> filmes) {	
		return filmes.size();
	}
	
	public int calculaHorasAssistidasSeries(Hashtable<String, Midia> series) {
		Iterator<Midia> itr = series.values().iterator();
		int horasAssistidas = 0;
				
		while(itr.hasNext()) {
			Serie s = (Serie)itr.next();
			horasAssistidas += s.getNroEpisodiosAssistidos() * s.getDuracao();
		}
		return horasAssistidas;
	}
}
