package Program.Controle_Midias;

import Program.Midias.Registro;

import java.util.Hashtable;

public class Repositorio extends Banco {
    private Hashtable<String, Colecao> colecoes;

    public Repositorio(){
        super();
        this.colecoes = new Hashtable<>();
    }

    public Hashtable<String, Colecao> getColecoes(){
        return this.colecoes;
    }

    public void adicionaColecao(Colecao novaColecao){
        this.colecoes.put(novaColecao.getNome(), novaColecao);
    }

    public void removeColecao(String nomeColecao){
        this.colecoes.remove(nomeColecao);
    }

    public Colecao selecionaColecao(String nomeColecao){
        return this.colecoes.get(nomeColecao);
    }
    
    public Registro selecionaRegistro(String nome){
        Registro registro = (Registro)this.selecionaSerie(nome);
        if(registro == null)
        {
        	return (Registro)this.selecionaFilme(nome);
        }
        return registro;         
    }
}
