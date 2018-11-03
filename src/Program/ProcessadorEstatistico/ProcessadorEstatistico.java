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
		final List<String> modes = new ArrayList<String>();						//Lista que contera a as modas;
	    final Map<String, Integer> countMap = new HashMap<String, Integer>(); 	//Hash que associa a cada string da lista de entrada, a quantidade de vezes em que ela aparece;
	    String str; 															//variavel temporaria para armazenar string atual;
	    
	    if(!lista.isEmpty()) {													//se a lista de entrada for vazia, a moda eh uma lista vazia;
		    for(int i=0; i<lista.size(); i++) {									//para cada item da lista:
		    	str = lista.get(i);												
		    	if(!countMap.containsKey(str)) {								//se a string ainda nao apareceu ate aqui, coloca na Hash de contagem;
		    		countMap.put(str, 1);
		    	}else {
		    		countMap.put(str, countMap.get(str)+1);						//se a string ja apareceu antes na lista de entrada, atualiza seu valor de contagem na Hash;
		    	}
		    }
		    
	    	int max = Collections.max(countMap.values());	 					//variavel temporaria para armazenar maior numero de repeticoes de uma string (valor da moda);   	
	    	for (Entry<String, Integer> entry : countMap.entrySet()) {			//para cada elemento da Hash de contagem:
	    		if (entry.getValue()== max) {
	    	        modes.add(entry.getKey());									//se valor associado a string eh o valor da moda, adiciona a string a lista de modas;
	    	    }
	    	}
	    }
	    return(modes);															//retorna lista de modas;
	}
	
	public int calculaTotalEpisodiosAssistidos(Hashtable<String, Midia> series) {
		int totalEps = 0;
		for (Entry<String, Midia> entry : series.entrySet()) {			

    		Serie s = (Serie)entry.getValue();
    		totalEps += s.getNroEpisodiosAssistidos();
    	}
		return totalEps;
	}
	
	
}
