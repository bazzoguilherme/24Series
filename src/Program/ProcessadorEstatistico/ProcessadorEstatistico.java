package Program.ProcessadorEstatistico;

import java.util.Hashtable;
import java.util.Iterator;

import Program.Midias.Filme;
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
	
	public int calculaHorasAssistidasFilmes(Hashtable<String, Midia> filmes) {
		Iterator<Midia> itr = filmes.values().iterator();
		int horasAssistidas = 0;
		while(itr.hasNext()) {
			Filme f = (Filme)itr.next();
			if(f.getStatus().equals("Assistido")) {
				horasAssistidas += f.getDuracao();
			}
			
		}
		return horasAssistidas;
	}
	
}
