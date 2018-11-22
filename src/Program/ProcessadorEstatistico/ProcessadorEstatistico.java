package Program.ProcessadorEstatistico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
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
			if(f.getStatus().equals(Filme.ASSISTIDO)) {
				horasAssistidas += f.getDuracao();
			}
			
		}
		return horasAssistidas;
	}
	
	public int calculaQtdeFilmesAssistidos(Hashtable<String, Midia> filmes) {
		Iterator<Midia> itr = filmes.values().iterator();
		int filmesAssistidos = 0;
		while(itr.hasNext()) {
			Filme f = (Filme)itr.next();
			if(f.getStatus().equals(Filme.ASSISTIDO)) {
				filmesAssistidos += 1;
			}
			
		}
		return filmesAssistidos;
	}
	
	public ArrayList<String> calculaModa(ArrayList<String> lista) {
		final ArrayList<String> modes;						//Lista que contera a as modas;
	    
	    modes = this.selecionaMaisFrequentes(lista, 0);
	    
	    return(modes);															//retorna lista de modas;
	}
	
	public ArrayList<String> selecionaMaisFrequentes(ArrayList<String> lista, double tolerancia){
		final ArrayList<String> maisFrequentes = new ArrayList<String>();						//Lista que contera os itens mais frequentes dentro da tolerancia escolhida;
	    final Map<String, Integer> countMap; 	//Hash que associa a cada string da lista de entrada, a quantidade de vezes em que ela aparece;

	    	if(!lista.isEmpty()) {												//se a lista de entrada for vazia, a moda eh uma lista vazia;
		    
	    	countMap =  contaOcorrencias(lista);
		    	    	
	    	int max = Collections.max(countMap.values());	 					//variavel temporaria para armazenar maior numero de repeticoes de uma string (valor da moda);   	
	    	double cut = max*(1-tolerancia);
	    	if(cut > 0) {
	    		for (Entry<String, Integer> entry : countMap.entrySet()) {			//para cada elemento da Hash de contagem:
		    		if (entry.getValue() >=  cut) {
		    			maisFrequentes.add(entry.getKey());									//se valor associado a string eh o valor da moda, adiciona a string a lista de modas;
		    	    }
		    	}
	    	}
	    }
		
		return(maisFrequentes);
	}
	
	private Map<String, Integer> contaOcorrencias(ArrayList<String> lista) {
	    final Map<String, Integer> countMap = new HashMap<String, Integer>(); 	//Hash que associa a cada string da lista de entrada, a quantidade de vezes em que ela aparece;
	    String str; 															//variavel temporaria para armazenar string atual;
	    
	    for(int i=0; i<lista.size(); i++) {									//para cada item da lista:
	    	str = lista.get(i);												
	    	if(!countMap.containsKey(str)) {								//se a string ainda nao apareceu ate aqui, coloca no Map de contagem;
	    		countMap.put(str, 1);
	    	}else {
	    		countMap.put(str, countMap.get(str)+1);						//se a string ja apareceu antes na lista de entrada, atualiza seu valor de contagem na Hash;
	    	}
	    }
	    return(countMap);															//retorna Map com String:Ocorrencias;
	}
		
	
	public int calculaTotalEpisodiosAssistidos(Hashtable<String, Midia> series) {
		int totalEps = 0;
		for (Entry<String, Midia> entry : series.entrySet()) {			

    		Serie s = (Serie)entry.getValue();
    		totalEps += s.getNroEpisodiosAssistidos();
    	}
		return totalEps;
	}

	public int calculaEpisodiosRestantes(Serie serie) {
		ArrayList<Integer> eps = serie.getNroEpisodios();
		int totalEps = 0;
		
		totalEps = eps.stream().mapToInt(Integer::intValue).sum();

		return totalEps - serie.getNroEpisodiosAssistidos();
	}

	public ArrayList<Integer> calculaTotalEpisodiosRestantes(ArrayList<Serie> lista) {
		ArrayList<Integer> epsRests = new ArrayList<>(); ;

		for(Serie s : lista) {
			epsRests.add(this.calculaEpisodiosRestantes(s));
		}
		
		return epsRests;
	}

	public int quantidadeTotalEpisodios(Midia midia) {
		int totalEpisodios = 0;
		for (int quantEpisodio : midia.getNroEpisodios()) {
			totalEpisodios += quantEpisodio;
		}
		return totalEpisodios;
	}

	public String minutosParaDiasHorasMin(int minutos){
		String days = " Dias - ";
		String hours = " Horas - ";
		String minutes = " Minutos.";
		String dataFinal = "";

		dataFinal += String.valueOf((int) (minutos /60/24));
		dataFinal += days;
		dataFinal += String.valueOf((int) (minutos /60%24));
		dataFinal += hours;
		dataFinal += String.valueOf((int) (minutos %60));
		dataFinal += minutes;

		return dataFinal;
	}
}
