package Program.ProcessadorEstatistico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public List<String> calculaModa(List<String> lista) {
		final List<String> modes = new ArrayList<String>();
	    final Map<String, Integer> countMap = new HashMap<String, Integer>();
	    String str;
	    
	    if(!lista.isEmpty()) {
		    for(int i=0; i<lista.size(); i++) {
		    	str = lista.get(i);
		    	if(!countMap.containsKey(str)) {
		    		countMap.put(str, 1);
		    	}else {
		    		countMap.put(str, countMap.get(str)+1);
		    	}
		    }
		    
	    	int max = Collections.max(countMap.values());	    	
	    	for (Entry<String, Integer> entry : countMap.entrySet()) {
	    		if (entry.getValue()== max) {
	    	        modes.add(entry.getKey());
	    	    }
	    	}
	    }
	    return(modes);
	}
	
}
